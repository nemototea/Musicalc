package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.CalcState
import com.tea.nemoto.musicalc.common.IState
import com.tea.nemoto.musicalc.common.NumberDotType
import com.tea.nemoto.musicalc.common.Operator

// 右辺入力中の状態での動作を定義
public object InputRightSideState : IState {

    override fun getStateValue(): CalcState {
        return CalcState.InputRightSide
    }

    override fun inputNumber(calculation: Calculation, key: NumberDotType) {
        // 入力中の値に数値を追加する
        calculation.addNum(key)
    }

    override fun inputOperator(calculation: Calculation, key: Operator) {
        // 現在の入力値を右辺として確定し、計算を行う
        calculation.setRightValue()
        calculation.calculate()
        calculation.clearCalcProcess()
        // 計算結果を左辺として確定し演算子をセット
        calculation.setLeftValue()
        calculation.setOperator(key)
        calculation.setLeftProcess()
        calculation.setOperatorProcess(key)
        // 演算子入力状態に遷移
        calculation.updateState(InputOperatorState)
    }

    override fun inputClear(calculation: Calculation) {
        // 右辺の入力値のみクリアする
        calculation.clear()
    }

    override fun inputClearAll(calculation: Calculation) {
        // 式を全てクリアし、左辺入力状態に遷移する
        calculation.clearAll()
        calculation.clearCalcProcess()
        calculation.updateState(InputLeftSideState)
    }

    override fun inputEqual(calculation: Calculation) {
        // 現在の入力値を右辺として確定し、計算をする
        calculation.setRightValue()
        calculation.calculate()
        calculation.clearCalcProcess()
        // 計算終了状態に遷移する
        calculation.updateState(FinishCalcState)
    }

    override fun inputRec(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
