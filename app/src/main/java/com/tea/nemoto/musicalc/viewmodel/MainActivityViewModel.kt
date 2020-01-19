package com.tea.nemoto.musicalc.viewmodel

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tea.nemoto.musicalc.model.Sound

public class MainActivityViewModel : ViewModel(){
    // 終了時にsoundPoolをリリースする
    override fun onCleared(){
        Sound.release()
        super.onCleared()
    }
}
