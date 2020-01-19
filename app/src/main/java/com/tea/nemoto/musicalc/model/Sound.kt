package com.tea.nemoto.musicalc.model

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.common.NumberDotType
import com.tea.nemoto.musicalc.common.SoundType

// 音声を再生するクラス(音声ファイルはres/rawに配置)
// TODO：音声のロード時間が長いため、起動直後は音が再生されない場合がある
object Sound {
    private lateinit var soundPool: SoundPool
    private var soundType: SoundType = SoundType.Guitar
    var bass0 = 0
    var bass00 = 0
    var bass1 = 0
    var bass2 = 0
    var bass3 = 0
    var bass4 = 0
    var bass5 = 0
    var bass6 = 0
    var bass7 = 0
    var bass8 = 0
    var bass9 = 0

    var guitar0 = 0
    var guitar00 = 0
    var guitar1 = 0
    var guitar2 = 0
    var guitar3 = 0
    var guitar4 = 0
    var guitar5 = 0
    var guitar6 = 0
    var guitar7 = 0
    var guitar8 = 0
    var guitar9 = 0

    var piano0 = 0
    var piano00 = 0
    var piano1 = 0
    var piano2 = 0
    var piano3 = 0
    var piano4 = 0
    var piano5 = 0
    var piano6 = 0
    var piano7 = 0
    var piano8 = 0
    var piano9 = 0

    var drumPlus = 0
    var drumSub = 0
    var drumMul = 0
    var drumDiv = 0
    var drumEqual = 0
    var drumDot = 0

    // soundPoolは初期化されている前提で動作するため、
    // 必ずMainActivityのonCreate()時にsetUp()を行うこと
    fun setUp(context: Context){
        val attributes = AudioAttributes.Builder().apply {
            setUsage(AudioAttributes.USAGE_GAME)
            setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        }.build()

        soundPool = SoundPool.Builder().apply {
            setMaxStreams(10)
            setAudioAttributes(attributes)
        }.build()

        bass0=soundPool.load(context,R.raw.sba4_0,1)
        bass00=soundPool.load(context,R.raw.sba4_00,1)
        bass1=soundPool.load(context,R.raw.sba41_09,1)
        bass2=soundPool.load(context,R.raw.sba4_57,1)
        bass3=soundPool.load(context,R.raw.sba3_45,1)
        bass4=soundPool.load(context,R.raw.sba3_57,1)
        bass5=soundPool.load(context,R.raw.sba2_45,1)
        bass6=soundPool.load(context,R.raw.sba2_57,1)
        bass7=soundPool.load(context,R.raw.sba2_79,1)
        bass8=soundPool.load(context,R.raw.sba1_57,1)
        bass9=soundPool.load(context,R.raw.sba1_79,1)

        guitar0=soundPool.load(context,R.raw.gui6_1,1)
        guitar00=soundPool.load(context,R.raw.gui5_1,1)
        guitar1=soundPool.load(context,R.raw.gui5_3,1)
        guitar2=soundPool.load(context,R.raw.gui4_1,1)
        guitar3=soundPool.load(context,R.raw.gui4_3,1)
        guitar4=soundPool.load(context,R.raw.gui3_1,1)
        guitar5=soundPool.load(context,R.raw.gui3_3,1)
        guitar6=soundPool.load(context,R.raw.gui2_1,1)
        guitar7=soundPool.load(context,R.raw.gui1_1,1)
        guitar8=soundPool.load(context,R.raw.gui1_6,1)
        guitar9=soundPool.load(context,R.raw.gui1_8,1)

        piano0=soundPool.load(context,R.raw.pi_do,1)
        piano00=soundPool.load(context,R.raw.pi_re,1)
        piano1=soundPool.load(context,R.raw.pi_mi,1)
        piano2=soundPool.load(context,R.raw.pi_fa,1)
        piano3=soundPool.load(context,R.raw.pi_so,1)
        piano4=soundPool.load(context,R.raw.pi_ra,1)
        piano5=soundPool.load(context,R.raw.pi_si,1)
        piano6=soundPool.load(context,R.raw.pi_c,1)
        piano7=soundPool.load(context,R.raw.pi_f,1)
        piano8=soundPool.load(context,R.raw.pi_g,1)
        piano9=soundPool.load(context,R.raw.pi_am,1)

        drumPlus =soundPool.load(context,R.raw.dr_sna,1)
        drumSub =soundPool.load(context,R.raw.dr_hat,1)
        drumMul =soundPool.load(context,R.raw.dr_sna2,1)
        drumDiv =soundPool.load(context,R.raw.dr_tum,1)
        drumEqual =soundPool.load(context,R.raw.dr_cym,1)
        drumDot =soundPool.load(context,R.raw.dr_bas,1)
    }

    fun release(){
        soundPool.release()
    }

    fun setSoundType(type: SoundType){
        this.soundType = type
    }

    fun playNumberOrDot(key: NumberDotType){
        when(key){
            NumberDotType.Zero -> {
                play0()
            }
            NumberDotType.Zero2 -> {
                play00()
            }
            NumberDotType.One -> {
                play1()
            }
            NumberDotType.Two -> {
                play2()
            }
            NumberDotType.Three -> {
                play3()
            }
            NumberDotType.Four -> {
                play4()
            }
            NumberDotType.Five -> {
                play5()
            }
            NumberDotType.Six -> {
                play6()
            }
            NumberDotType.Seven -> {
                play7()
            }
            NumberDotType.Eight -> {
                play8()
            }
            NumberDotType.Nine -> {
                play9()
            }
            NumberDotType.Dot -> {
                playDot()
            }
        }
    }

    fun playPlus(){
        soundPool.play(drumPlus, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun playSub(){
        soundPool.play(drumSub, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun playMul(){
        soundPool.play(drumMul, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun playDiv(){
        soundPool.play(drumDiv, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    fun playEqual(){
        soundPool.play(drumEqual, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun playDot(){
        soundPool.play(drumDot, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play0(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar0
            }
            SoundType.Bass -> {
                id = bass0
            }
            SoundType.Piano -> {
                id = piano0
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play00(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar00
            }
            SoundType.Bass -> {
                id = bass00
            }
            SoundType.Piano -> {
                id = piano00
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play1(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar1
            }
            SoundType.Bass -> {
                id = bass1
            }
            SoundType.Piano -> {
                id = piano1
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play2(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar2
            }
            SoundType.Bass -> {
                id = bass2
            }
            SoundType.Piano -> {
                id = piano2
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play3(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar3
            }
            SoundType.Bass -> {
                id = bass3
            }
            SoundType.Piano -> {
                id = piano3
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play4(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar4
            }
            SoundType.Bass -> {
                id = bass4
            }
            SoundType.Piano -> {
                id = piano4
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play5(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar5
            }
            SoundType.Bass -> {
                id = bass5
            }
            SoundType.Piano -> {
                id = piano5
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play6(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar6
            }
            SoundType.Bass -> {
                id = bass6
            }
            SoundType.Piano -> {
                id = piano6
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play7(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar7
            }
            SoundType.Bass -> {
                id = bass7
            }
            SoundType.Piano -> {
                id = piano7
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play8(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar8
            }
            SoundType.Bass -> {
                id = bass8
            }
            SoundType.Piano -> {
                id = piano8
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

    private fun play9(){
        var id = 0
        when (this.soundType) {
            SoundType.Guitar -> {
                id = guitar9
            }
            SoundType.Bass -> {
                id = bass9
            }
            SoundType.Piano -> {
                id = piano9
            }
        }
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }
}
