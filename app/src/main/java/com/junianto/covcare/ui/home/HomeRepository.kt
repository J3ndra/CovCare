package com.junianto.covcare.ui.home

import androidx.lifecycle.LiveData
import com.junianto.covcare.model.covid.ProvinceData
import com.junianto.covcare.model.covid.IndonesiaCases
import com.junianto.covcare.network.api.apiInterface.CovidApiInterface
import com.junianto.covcare.network.api.NetworkState
import com.junianto.covcare.network.repository.CovidDataSource
import io.reactivex.disposables.CompositeDisposable

class HomeRepository (private val apiService: CovidApiInterface) {

    lateinit var covidDataSource: CovidDataSource

    fun fetchIndonesiaDetails (compositeDisposable: CompositeDisposable): LiveData<IndonesiaCases> {

        covidDataSource = CovidDataSource(apiService, compositeDisposable)
        covidDataSource.fetchIndonesiaDetails()

        return covidDataSource.indonesiaCasesResponse
    }

    fun fetchProvinceDetails (compositeDisposable: CompositeDisposable): LiveData<List<ProvinceData>> {

        covidDataSource = CovidDataSource(apiService, compositeDisposable)
        covidDataSource.fetchProvinceDetails()

        return covidDataSource.provinceDetailsResponse
    }

    fun getIndonesiaDetailsNetworkState(): LiveData<NetworkState> {
        return covidDataSource.networkState
    }
}