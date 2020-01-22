package com.tea.nemoto.musicalc.model

import com.nightonke.boommenu.BoomButtons.*
import com.tea.nemoto.musicalc.common.SoundType

class OnGuitarClickListener: OnBMClickListener {
    override fun onBoomButtonClick(index: Int){
        Sound.setSoundType(SoundType.Guitar)
    }
}
