package com.tea.nemoto.musicalc.model

import com.nightonke.boommenu.BoomButtons.*
import com.tea.nemoto.musicalc.common.SoundType

class OnBassClickListener: OnBMClickListener {
    override fun onBoomButtonClick(index: Int){
        Sound.setSoundType(SoundType.Bass)
    }
}
