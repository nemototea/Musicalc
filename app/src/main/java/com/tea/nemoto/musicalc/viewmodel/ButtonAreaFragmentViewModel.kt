package com.tea.nemoto.musicalc.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.common.NumberDotType
import com.tea.nemoto.musicalc.common.Operator
import com.tea.nemoto.musicalc.common.SoundType
import com.tea.nemoto.musicalc.model.Calculation
import com.tea.nemoto.musicalc.model.Sound
import kotlinx.android.synthetic.main.fragment_buttonarea.view.*

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

    fun playStopTapped() {
        Sound.playStopBeat()
    }

    fun instTapped() {
        when (Sound.getSoundType()) {
            SoundType.Guitar -> {
                Sound.setSoundType(SoundType.Bass)
            }
            SoundType.Bass -> {
                Sound.setSoundType(SoundType.Piano)
            }
            SoundType.Piano -> {
                Sound.setSoundType(SoundType.Guitar)
            }
        }
    }
}
