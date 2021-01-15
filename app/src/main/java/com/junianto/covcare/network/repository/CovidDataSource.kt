package com.junianto.covcare.network.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.junianto.covcare.model.covid.ProvinceData
import com.junianto.covcare.model.covid.IndonesiaCases
import com.junianto.covcare.network.api.apiInterface.CovidApiInterface
import com.junianto.covcare.network.api.NetworkState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CovidDataSource (private val covidApiService: CovidApiInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _indonesiaCasesResponse = MutableLiveData<IndonesiaCases>()
    val indonesiaCasesResponse: LiveData<IndonesiaCases>
        get() = _indonesiaCasesResponse

    private val _provinceDetailsResponse = MutableLiveData<List<ProvinceData>>()
    val provinceDetailsResponse: LiveData<List<ProvinceData>>
        get() = _provinceDetailsResponse

    fun fetchIndonesiaDetails() {

        _networkState.postValue(NetworkState.LOADING)
        try {
            compositeDisposable.add(
                covidApiService.getIndonesiaDetails()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _indonesiaCasesResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("DataSource", it.message!!)
                        }
                    )
            )

        }

        catch (e: Exception){
            Log.e("DataSource", e.message!!)
        }
    }

    fun fetchProvinceDetails() {

        _networkState.postValue(NetworkState.LOADING)
        try {
            compositeDisposable.add(
                    covidApiService.getProvinceDetails()
                            .map { it.data?.toList() }
//                            .delay(10, TimeUnit.SECONDS)
//                            .repeat()
//                            .retry()
                            .subscribeOn(Schedulers.io())
                            .subscribe({
                                _provinceDetailsResponse.postValue(it)
                                _networkState.postValue(NetworkState.LOADED)
                            }, {
                                _networkState.postValue(NetworkState.ERROR)
                                Log.e("DataSource", it.message!!)
                            })
            )
        }

        catch (e: Exception){
            Log.e("DataSource", e.message!!)
        }
    }
}