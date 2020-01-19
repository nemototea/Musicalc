package com.tea.nemoto.musicalc.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tea.nemoto.musicalc.common.CalcData

public class ResultAreaFragmentViewModel : ViewModel(){
    private var mResult = MutableLiveData<String>().apply{
        value = "0"
    }
    val result: LiveData<String>
        get() = mResult

    // Viewが参照するプロパティ
    val resultTest = ObservableField<String>("0")

    // CalcDataのresultDataを監視する。
    // 値が変更されたら、通知を受け取る。
    // 通知を受け取ったコールバック？があれば、そこでresultTestに値をセットして、Viewに反映される。

    //   val callBack: Observable.OnPropertyChangedCallback = CbListner()


    //   val aa = CalcData.resultData.addOnPropertyChangedCallback(callBack)

}

//private class CbListner: Observable.OnPropertyChangedCallback(){
//
//    fun override onPropertyChanged(ob: Observable, i: Int){
//
//    }
//}
