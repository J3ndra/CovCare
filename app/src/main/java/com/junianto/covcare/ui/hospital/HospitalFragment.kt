package com.junianto.covcare.ui.hospital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.junianto.covcare.R

class HospitalFragment : Fragment() {

    private lateinit var hospitalViewModel: HospitalViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        hospitalViewModel =
                ViewModelProvider(this).get(HospitalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_hospital, container, false)
        return root
    }
}