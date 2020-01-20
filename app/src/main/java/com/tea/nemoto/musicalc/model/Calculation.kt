package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.CalcData
import com.tea.nemoto.musicalc.common.IState
import com.tea.nemoto.musicalc.common.NumberDotType
import com.tea.nemoto.musicalc.common.Operator
import java.math.BigDecimal
import kotlin.Exception

public object Calculation {
    // 最大表示桁数
    private const val MAX_DIGIT: Int = 16

    // 計算で保持する内部値
    private var mLeftValue: Double = 0.0
    private var mRightValue: Double = 0.0
    private var mOperator: Operator = Operator.None
    private var mState: IState = InputLeftSideState

    // region ViewModelから利用する処理
    // 状態によりstateのインスタンスを差し替える
    public fun inputNumber(key: NumberDotType){
        mState.inputNumber(this, key)
    }

    public fun inputOperator(key: Operator){
        mState.inputOperator(this, key)
    }

    public fun inputClear(){
        mState.inputClear(this)
    }

    public fun inputClearAll(){
        mState.inputClearAll(this)
    }

    public fun inputRec(){
        mState.inputRec(this)
    }

    public fun inputEqual(){
        mState.inputEqual(this)
    }
    // endregion

    // region State側からコールする共通処理
    // 表示中の値に入力値を加える
    // ※Error表示後はErrorStateから初期化を行うため、数値以外の文字列については考慮不要
    public fun addNum(key: NumberDotType){
        try {
            val calcResult: String = CalcData.resultData.get()!!
            var setValue: String = calcResult

            if (calcResult.length >= MAX_DIGIT) {
                // 入力上限値以上の場合はAddしない
                return
            }

            if (calcResult == "0") {
                // 表示値が「0」の場合
                if (key == NumberDotType.Zero || key == NumberDotType.Zero2) {
                    // 「0・00」が入力された場合はAddしない
                    return
                }
                if (key == NumberDotType.Dot) {
                    // 「.」が入力された場合は0の後にAddする
                    setValue += key.text
                } else {
                    // その他の場合は、入力値で上書きする
                    setValue = key.text
                }
            } else if (key == NumberDotType.Dot && calcResult.contains(".")) {
                // 既に「.」が含まれている場合はAddしない
                return
            } else {
                setValue += key.text
            }
            CalcData.resultData.set(setValue)
        }
        catch (ex: Exception){
            CalcData.resultData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 計算過程Textに左辺を追加
    public fun setLeftProcess(){
        try {
            // 小数点以下の不要な0は削除
            if(mLeftValue.toString().endsWith(".0")){
                CalcData.calcProcessData.set(mLeftValue.toInt().toString())
            }
            else{
                CalcData.calcProcessData.set(mLeftValue.toString())
            }
        }
        catch (ex: Exception){
            CalcData.calcProcessData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 計算過程Textに演算子を追加
    public fun setOperatorProcess(op: Operator){
        try {
            val calcProcess = CalcData.calcProcessData.get()!!
            var writeText = calcProcess

            // 左辺や右辺があれば演算子を追加してよい
            if(calcProcess != "") {
                // 末尾が演算子の場合は、入力した演算子に置き換える
                if (calcProcess.endsWith(Operator.Plus.text) ||
                    calcProcess.endsWith(Operator.Minus.text) ||
                    calcProcess.endsWith(Operator.Times.text) ||
                    calcProcess.endsWith(Operator.Divide.text)
                ) {
                    writeText = writeText.substring(0, writeText.length - 1)
                }
                writeText += op.text
                CalcData.calcProcessData.set(writeText)
            }
        }
        catch (ex: Exception){
            CalcData.calcProcessData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 計算過程Textをクリア
    public fun clearCalcProcess(){
        try {
            CalcData.calcProcessData.set("")
        }
        catch (ex: Exception){
            CalcData.calcProcessData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 画面に表示されている値を左辺にセット
    public fun setLeftValue(){
        try {
            mLeftValue = CalcData.resultData.get()!!.toDouble()
        }
        catch (ex: Exception){
            CalcData.resultData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 画面に表示されている値を右辺にセット
    public fun setRightValue(){
        try {
            mRightValue = CalcData.resultData.get()!!.toDouble()
        }
        catch (ex: Exception){
            CalcData.resultData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 押された演算子をセット
    public fun setOperator(key: Operator){
        mOperator = key
    }

    // 状態を更新する(現在の状態から変化する場合のみ)
    public fun updateState(destState: IState){
        if(this.mState != destState){
            this.mState = destState
        }
    }

    // 表示されている値を0にする(クラス変数の右辺左辺は変更しない)
    public fun clear(){
        CalcData.resultData.set("0")
    }

    // 表示されている値を0にし、演算子、右辺左辺を初期化する
    public fun clearAll(){
        CalcData.resultData.set("0")
        this.initialize()
    }

    // 計算処理
    public fun calculate(){
        try {
            fourArithmeticOperations(mLeftValue, mRightValue, mOperator)
        }
        catch (ex: Exception){
            CalcData.resultData.set("ERROR")
            updateState(ErrorState)
        }
    }

    // 定数計算を行う
    // 右辺はそのままで、左辺の入力値は画面から取得する
    public fun constantCalculate(){
        try {
            val left: Double = CalcData.resultData.get()!!.toDouble()
            fourArithmeticOperations(left, mRightValue, mOperator)
        }
        catch (ex: Exception){
            CalcData.resultData.set("ERROR")
            updateState(ErrorState)
        }
    }
    // endregion

    // region privateメソッド
    private fun initialize(){
        try {
            CalcData.resultData.set("0")
            mOperator = Operator.None
            mLeftValue = 0.0
            mRightValue = 0.0
            updateState(InputLeftSideState)
        }
        catch (ex: Exception){
            // 初期化でエラーが起きた際は握りつぶす
        }
    }

    // 四則演算
    private fun fourArithmeticOperations(left: Double, right: Double, op: Operator) {
        // Doubleで計算すると、小数点以下の計算に丸め誤差が生じるため
        // BigDecimalに変換してから計算する
        // ex)123.56 - 0.6 = 122.960000...1 等となる(122.96が正解)
        var result = BigDecimal(0)
        val bdLeft = BigDecimal.valueOf(left)
        val bdRight = BigDecimal.valueOf(right)

        when (op) {
            Operator.Plus -> {
                result = bdLeft + bdRight
            }
            Operator.Minus -> {
                result = bdLeft - bdRight
            }
            Operator.Times -> {
                result = bdLeft * bdRight
            }
            Operator.Divide -> {
                // 除算時、右辺が0かどうかを判定
                if (bdRight.compareTo(BigDecimal.ZERO) == 0) {
                    // "0"を返却すると計算結果としては誤りとなる。
                    // 0除算は計算できない旨を明示する
                    CalcData.resultData.set("0で割ることはできません")
                    updateState(ErrorState)
                    return
                } else {
                    result = bdLeft / bdRight
                }
            }
            Operator.None -> {
                // 処理なし
            }
        }

        // 小数点以下の不要な0を削除する
        // TODO：関数に切り出す||処理が不格好
        var strResult = result.toString()
        if (strResult.contains(".")) {
            while (strResult.endsWith("0")) {
                strResult = strResult.substring(0, strResult.length - 1)
            }

            if(strResult.contains(".")){
                strResult = strResult.substring(0, strResult.length - 1)
            }
        }
        CalcData.resultData.set(strResult)
    }
    // endregion
}
