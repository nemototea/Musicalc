package com.tea.nemoto.musicalc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public class ResultAreaFragmentViewModel : ViewModel(){
    private val mResult = MutableLiveData<String>().apply{
        value = "1000000"
    }
    val result: LiveData<String>
        get() = mResult
}
