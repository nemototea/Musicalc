package com.tea.nemoto.musicalc.view

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tea.nemoto.musicalc.R
import com.tea.nemoto.musicalc.databinding.FragmentResultareaBinding

class ResultAreaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Fragmentとlayoutを紐付ける
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentResultareaBinding>(inflater, R.layout.fragment_resultarea, container, false)

        return binding.root
    }
}
