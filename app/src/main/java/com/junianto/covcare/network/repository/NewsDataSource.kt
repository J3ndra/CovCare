package com.junianto.covcare.network.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.junianto.covcare.model.news.NewsData
import com.junianto.covcare.network.api.NetworkState
import com.junianto.covcare.network.api.apiInterface.NewsApiInterface
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class NewsDataSource (private val newsApiService: NewsApiInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _covidNewsResponse = MutableLiveData<List<NewsData>>()
    val covidNewsResponse: LiveData<List<NewsData>>
        get() = _covidNewsResponse

    fun fetchNewsCovid() {

        _networkState.postValue(NetworkState.LOADING)
        try {
            compositeDisposable.add(
                newsApiService.getCovidNews()
                    .map { it.data?.toList() }
                    .delay(10, TimeUnit.SECONDS)
                    .repeat()
                    .retry()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        _covidNewsResponse.postValue(it)
                        _networkState.postValue(NetworkState.LOADED)
                    }, {
                        _networkState.postValue(NetworkState.ERROR)
                        Log.e("DataSource", it.message!!)
                    })
            )
        }

        catch (e: Exception) {
            Log.e("DataSource", e.message!!)
        }
    }
}