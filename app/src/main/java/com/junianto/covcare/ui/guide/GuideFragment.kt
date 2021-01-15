package com.junianto.covcare.ui.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentGuideBinding

class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_guide, container, false)

        binding.btnGoToHotline.setOnClickListener {
            findNavController().navigate(R.id.action_guideFragment_to_hotlineFragment)
        }

        binding.btnAboutDev.setOnClickListener {
            findNavController().navigate(R.id.action_guideFragment_to_aboutFragment)
        }

        return binding.root
    }
}