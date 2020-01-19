package com.tea.nemoto.musicalc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tea.nemoto.musicalc.common.NumberDotType
import com.tea.nemoto.musicalc.common.Operator
import com.tea.nemoto.musicalc.model.Calculation
import com.tea.nemoto.musicalc.model.Sound

public class ButtonAreaFragmentViewModel : ViewModel(){
    // 各ボタンタップ時の動作はModelで行う
    fun numberTapped(number: NumberDotType){
        Calculation.inputNumber(number)
        Sound.playNumberOrDot(number)
    }

    fun addTapped(){
        Calculation.inputOperator(Operator.Plus)
        Sound.playPlus()
    }

    fun subTapped(){
        Calculation.inputOperator(Operator.Minus)
        Sound.playSub()
    }

    fun mulTapped(){
        Calculation.inputOperator(Operator.Times)
        Sound.playMul()
    }

    fun divTapped(){
        Calculation.inputOperator(Operator.Divide)
        Sound.playDiv()
    }

    fun clearTapped(){
        Calculation.inputClear()
    }

    fun clearAllTapped(){
        Calculation.inputClearAll()
    }

    fun equalTapped(){
        Calculation.inputEqual()
        Sound.playEqual()
    }

    fun recTapped(){
        Calculation.inputRec()
    }
}
