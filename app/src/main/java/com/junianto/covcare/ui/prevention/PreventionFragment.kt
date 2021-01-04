package com.junianto.covcare.ui.prevention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentPreventionBinding

class PreventionFragment : Fragment() {

    private lateinit var binding: FragmentPreventionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_prevention, container, false)

        return binding.root
    }
}