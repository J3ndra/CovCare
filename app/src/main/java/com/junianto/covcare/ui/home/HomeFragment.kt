package com.junianto.covcare.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentHomeBinding
import com.junianto.covcare.model.IndonesiaCases
import com.junianto.covcare.network.api.apiInterface.CovidApiInterface
import com.junianto.covcare.network.api.Network
import com.junianto.covcare.network.api.NetworkState

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeRepository: HomeRepository

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val apiService: CovidApiInterface = Network.getCovidClient()
        homeRepository = HomeRepository(apiService)

        homeViewModel = getViewModel()

        binding.rvProvince.layoutManager = LinearLayoutManager(context)

        homeViewModel.provinceProvinceData.observe(viewLifecycleOwner, Observer {
            binding.rvProvince.adapter = ProvinceAdapter(it)
            Log.d("list", it.size.toString())
        })

        homeViewModel.indonesiaData.observe(viewLifecycleOwner, Observer {
            bindUI(it)
        })
        homeViewModel.networkState.observe(viewLifecycleOwner, Observer {
            binding.indonesiaCases.text = if (it == NetworkState.LOADING) "Loading" else ""
            binding.indonesiaCases.text = if (it == NetworkState.ERROR) "Tidak dapat mengambil data" else ""
            binding.indonesiaCases.text = if (it == NetworkState.LOADED) "Total kasus di Indonesia" else ""
        })

        return binding.root
    }

    private fun bindUI(it: IndonesiaCases) {
        Log.d("data", it.jumlahKasus.toString())
        binding.indonesiaCovidDetails = it
    }

    private fun getViewModel(): HomeViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(homeRepository) as T
            }
        })[HomeViewModel::class.java]
    }
}