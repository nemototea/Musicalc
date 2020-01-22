package com.tea.nemoto.musicalc.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.databinding.FragmentButtonareaBinding
import com.tea.nemoto.musicalc.model.Sound
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
        binding.sound = Sound

        return binding.root
    }
}
