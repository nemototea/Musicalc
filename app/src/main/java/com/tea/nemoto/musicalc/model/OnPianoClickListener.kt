package com.tea.nemoto.musicalc.model

import com.nightonke.boommenu.BoomButtons.*
import com.tea.nemoto.musicalc.common.SoundType

class OnPianoClickListener: OnBMClickListener {

    override fun onBoomButtonClick(index: Int){
        Sound.setSoundType(SoundType.Piano)
    }
}
