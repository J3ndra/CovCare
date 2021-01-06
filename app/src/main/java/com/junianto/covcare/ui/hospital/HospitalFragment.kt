package com.junianto.covcare.ui.hospital

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentHospitalBinding

class HospitalFragment : Fragment() {

    private lateinit var binding: FragmentHospitalBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hospital, container, false)

        binding.btnToHospitalWeb.setOnClickListener {
            val url = "https://covid19.go.id/daftar-rumah-sakit-rujukan"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        return binding.root
    }
}