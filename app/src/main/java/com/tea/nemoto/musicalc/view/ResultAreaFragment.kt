package com.tea.nemoto.musicalc.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.common.CalcData
import com.tea.nemoto.musicalc.databinding.FragmentResultareaBinding
import com.tea.nemoto.musicalc.viewmodel.ResultAreaFragmentViewModel

public class ResultAreaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        // FragmentのViewModel生成と、DataBindingを行う
        val binding = DataBindingUtil.inflate<FragmentResultareaBinding>(inflater, R.layout.fragment_resultarea, container, false)
        binding.viewModel = ResultAreaFragmentViewModel()
        binding.calcData = CalcData

        return binding.root
    }
}
