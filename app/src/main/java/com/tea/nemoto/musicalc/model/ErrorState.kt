package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.CalcState
import com.tea.nemoto.musicalc.common.IState
import com.tea.nemoto.musicalc.common.NumberDotType
import com.tea.nemoto.musicalc.common.Operator

// エラーを表示した状態での動作を定義
public object ErrorState : IState {

    override fun getStateValue(): CalcState {
        return CalcState.Error
    }

    override fun inputNumber(calculation: Calculation, key: NumberDotType) {
        // 計算結果をクリアして値入力開始
        calculation.clearAll()
        calculation.addNum(key)
        calculation.updateState(InputLeftSideState)
    }

    override fun inputOperator(calculation: Calculation, key: Operator) {
        // 何もしない
    }

    override fun inputClear(calculation: Calculation) {
        // エラー時はclearAllする
        calculation.clearAll()
        calculation.updateState(InputLeftSideState)
    }

    override fun inputClearAll(calculation: Calculation) {
        calculation.clearAll()
        calculation.updateState(InputLeftSideState)
    }

    override fun inputEqual(calculation: Calculation) {
        // 何もしない
    }

    override fun inputRec(calculation: Calculation) {
        // 何もしない
    }

}
