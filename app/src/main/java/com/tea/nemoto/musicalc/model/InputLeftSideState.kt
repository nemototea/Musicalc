package com.tea.nemoto.musicalc.model

import com.tea.nemoto.musicalc.common.*

// ※インスタンス複数必要なく、IStateを継承するため、シングルトンクラスとする
// ※シングルトン使用時の注意
//   Androidの場合、参照がない場合はガベージコレクションで回収される可能性がある
//   回収後に参照すると初期化が走るため、シングルトンでデータ管理などは行わないようにしたい
//   参考：https://discuss.kotlinlang.org/t/singleton-with-object-declarations-gets-garbage-collected/4786

// 左辺入力中の状態での動作を定義
public object InputLeftSideState : IState {

    override fun getStateValue(): CalcState {
        return CalcState.InputLeftSide
    }

    override fun inputNumber(calculation: Calculation, key: NumberDotType) {
        // 入力中の値に数値を追加する
        calculation.addNum(key)
    }

    override fun inputOperator(calculation: Calculation, key: Operator) {
        // 左辺を確定・演算子をセットし、状態遷移する
        calculation.setLeftValue()
        calculation.setOperator(key)
        calculation.setLeftProcess()
        calculation.setOperatorProcess(key)
        calculation.updateState(InputOperatorState)
    }

    override fun inputClear(calculation: Calculation) {
        calculation.clear()
    }

    override fun inputClearAll(calculation: Calculation) {
        calculation.clearAll()
        calculation.clearCalcProcess()
    }

    override fun inputEqual(calculation: Calculation) {
        // 左辺入力中のため、何も行わない
    }

    override fun inputRec(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
