package com.tea.nemoto.musicalc.common

import com.tea.nemoto.musicalc.model.Calculation

// 状態クラスに継承させるインタフェース定義
// ※状態に応じてボタン押下時の挙動を入れ替えたいため
public interface IState {
    fun getStateValue():CalcState
    fun inputNumber(calculation: Calculation, key: Int)
    fun inputOperator(calculation: Calculation, key: Operator)
    fun inputClear(calculation: Calculation)
    fun inputClearAll(calculation: Calculation)
    fun inputEqual(calculation: Calculation)
    fun inputRec(calculation: Calculation)
}
