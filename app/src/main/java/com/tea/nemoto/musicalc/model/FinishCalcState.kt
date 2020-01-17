package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.CalcState
import com.tea.nemoto.musicalc.common.IState
import com.tea.nemoto.musicalc.common.Operator

// 計算終了後の状態での動作を定義
public object FinishCalcState : IState {

    override fun getStateValue(): CalcState {
        return CalcState.FinishCalc
    }

    override fun inputNumber(calculation: Calculation, key: Int) {
        // 計算結果をクリアして値入力開始
        calculation.clearAll()
        calculation.addNum(key)
        calculation.updateState(InputLeftSideState)
    }

    override fun inputOperator(calculation: Calculation, key: Operator) {
        // 計算結果の値を左辺として確定し、演算子を設定する
        calculation.setLeftValue()
        calculation.setOperator(key)
        calculation.updateState(InputOperatorState)
    }

    override fun inputClear(calculation: Calculation) {
        // 計算終了時はclearAllする
        // ※Windows標準電卓のCEと同じ動作
        calculation.clearAll()
        calculation.updateState(InputLeftSideState)
    }

    override fun inputClearAll(calculation: Calculation) {
        calculation.clearAll()
        calculation.updateState(InputLeftSideState)
    }

    override fun inputEqual(calculation: Calculation) {
        // 計算結果が算出された状態で「＝」を押下した場合は定数計算を行う
        calculation.constantCalculate()
    }

    override fun inputRec(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
