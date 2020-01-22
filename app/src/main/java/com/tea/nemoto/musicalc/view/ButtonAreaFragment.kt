package com.tea.nemoto.musicalc.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nightonke.boommenu.BoomButtons.*
import com.nightonke.boommenu.BoomMenuButton
import com.nightonke.boommenu.ButtonEnum
import com.nightonke.boommenu.Piece.PiecePlaceEnum
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.databinding.FragmentButtonareaBinding
import com.tea.nemoto.musicalc.model.OnBassClickListener
import com.tea.nemoto.musicalc.model.OnGuitarClickListener
import com.tea.nemoto.musicalc.model.OnPianoClickListener
import com.tea.nemoto.musicalc.viewmodel.ButtonAreaFragmentViewModel
import kotlinx.android.synthetic.main.fragment_buttonarea.*

public class ButtonAreaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        // FragmentのViewModel生成と、DataBindingを行う
        val binding = DataBindingUtil.inflate<FragmentButtonareaBinding>(
            inflater,
            R.layout.fragment_buttonarea,
            container,
            false
        )
        binding.viewModel = ButtonAreaFragmentViewModel()

        if (savedInstanceState == null) {
            // BoomButtonのタイプを設定する
            bmb.setButtonEnum(ButtonEnum.TextInsideCircle)
            bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_3_1)
            bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_3_3)

            // BoomButtonの中身のアイコンとイベントリスナーを設定する
            bmb.addBuilder(
                TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.piano)
                    .normalTextRes(R.string.piano)
                    .listener(OnPianoClickListener())
            )
            bmb.addBuilder(
                TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.guitar)
                    .normalTextRes(R.string.guitar)
                    .listener(OnGuitarClickListener())
            )
            bmb.addBuilder(
                TextInsideCircleButton.Builder()
                    .normalImageRes(R.drawable.bass)
                    .normalTextRes(R.string.bass)
                    .listener(OnBassClickListener())
            )
        }

        return binding.root
    }
}
