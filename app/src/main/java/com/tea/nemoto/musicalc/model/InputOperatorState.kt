package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.CalcState
import com.tea.nemoto.musicalc.common.IState
import com.tea.nemoto.musicalc.common.Operator

// 演算子入力中の状態での動作を定義
public object InputOperatorState : IState {

    override fun getStateValue(): CalcState {
        return CalcState.InputOperator
    }

    override fun inputNumber(calculation: Calculation, key: Int) {
        // 入力内容をクリアし、右辺の入力に遷移する
        calculation.clear()
        calculation.addNum(key)
        calculation.updateState(InputLeftSideState)
    }

    override fun inputOperator(calculation: Calculation, key: Operator) {
        // 演算子をセットしなおす
        calculation.setOperator(key)
    }

    override fun inputClear(calculation: Calculation) {
        // 入力内容をクリアし、右辺入力状態に遷移
        // ※演算子は、本ステータス遷移時点で入力されているもので確定
        // ※Windows標準電卓のCEと同じ動作
        calculation.clear()
        calculation.updateState(InputRightSideState)
    }

    override fun inputClearAll(calculation: Calculation) {
        // 入力内容をクリアし、左辺入力状態に遷移する
        calculation.clearAll()
        calculation.updateState(InputLeftSideState)
    }

    override fun inputEqual(calculation: Calculation) {
        // 現在表示されている値を右辺としてセット
        calculation.setRightValue()
        // 計算を実施し、計算終了状態に遷移する
        calculation.calculate()
        calculation.updateState(FinishCalcState)
    }

    override fun inputRec(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
