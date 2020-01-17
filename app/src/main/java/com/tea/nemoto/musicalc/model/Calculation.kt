package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.IState
import com.tea.nemoto.musicalc.common.Operator
import kotlin.Exception

public object Calculation {
    private var mLeftValue: Double = 0.0
    private var mRightValue: Double = 0.0
    private var mOperator: Operator = Operator.None
    private var mState: IState = InputLeftSideState

    // region ViewModelから利用する処理
    // 状態によりstateのインスタンスを差し替える
    public fun inputNumber(key: Int){
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
    public fun addNum(key: Int){
        // TODO:画面の表示を取得＆設定できるようにしたい
        // 入力値上限チェック
        if(true){
            // 上限値以上の場合は追加せずリターン
            return
        }

        if(true && true){
            // 入力値が「.」かつ、「.」が1つもない場合
            // 末尾に.をAppendする
        }
        else if(true){
            // 数字入力時、「0」のみだった場合、
            // 0を削除して、入力値を新しく入れる。
        }
        else{
            // 入力値をAppendする
        }
    }

    // 画面に表示されている値を左辺にセット
    public fun setLeftValue(){
        mLeftValue = 0.0 // TODO：画面側にアクセス
    }

    // 画面に表示されている値を右辺にセット
    public fun setRightValue(){
        mRightValue = 0.0 // TODO：画面側にアクセス
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

    public fun clear(){
        // 表示されている値を0にする
        // TODO：画面側にアクセス
    }

    public fun clearAll(){
        // 表示されている値を0にする
        // TODO：画面側にアクセス
        // 演算子、右辺左辺を初期化する
        this.initialize()
    }

    public fun calculate(){
        var result: Double = fourArithmeticOperations(mLeftValue, mRightValue, mOperator)
        // TODO：画面側に計算結果を通知
    }

    // 定数計算を行う
    // 右辺はそのままで、左辺の入力値は画面から取得する
    public fun constantCalculate(){
        var result: Double = fourArithmeticOperations(mLeftValue, mRightValue, mOperator)
        // TODO：画面側にアクセス(表示値を取得、結果を通知)

    }
    // endregion

    // region privateメソッド
    private fun initialize(){
        try {
            // TODO：画面初期化も行いたい
            mOperator = Operator.None
            mLeftValue = 0.0
            mRightValue = 0.0
            updateState(InputLeftSideState)
        }
        catch (ex: Exception){
            // 初期化でエラーが起きた際は握りつぶす
            // TODO:画面にERROR表示
        }
    }

    private fun fourArithmeticOperations(left: Double, right: Double, op: Operator): Double{
        var result: Double = 0.0

        try{
            when(op){
                Operator.Plus -> {
                    result = left + right
                }
                Operator.Minus -> {
                    result = left - right
                }
                Operator.Times ->{
                    result = left * right
                }
                Operator.Divide -> {
                    if(right == 0.0){
                        // "0"を返却すると計算結果として誤りとなるため、
                        // TODO:画面にエラーを表示する
                        result = 0.0
                    }
                    else{
                        result = left / right
                    }
                }
                Operator.None -> {
                    // 処理なし
                }
            }
        }
        catch (ex: Exception){
            // 計算でエラーになった際は初期化する
            this.initialize()
        }

        return result
    }
    // endregion
}
