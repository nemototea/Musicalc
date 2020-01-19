package com.tea.nemoto.musicalc.common

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

object CalcData {
    // みんなで監視する計算結果
    val resultData = ObservableField<String>("0")
}
