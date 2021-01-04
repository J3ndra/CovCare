package com.junianto.covcare.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.junianto.covcare.model.covid.ProvinceData
import com.junianto.covcare.model.covid.IndonesiaCases
import com.junianto.covcare.network.api.NetworkState
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel (private val homeRepository: HomeRepository): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val indonesiaData: LiveData<IndonesiaCases> by lazy {
        homeRepository.fetchIndonesiaDetails(compositeDisposable)
    }

    val provinceProvinceData: LiveData<List<ProvinceData>> by lazy {
        homeRepository.fetchProvinceDetails(compositeDisposable)
    }

    val networkState: LiveData<NetworkState> by lazy {
        homeRepository.getIndonesiaDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}