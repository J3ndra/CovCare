package com.junianto.covcare.ui.symptoms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentSymptomsBinding

class SymptomsFragment : Fragment() {

    private lateinit var binding: FragmentSymptomsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_symptoms, container, false)

        return binding.root
    }
}