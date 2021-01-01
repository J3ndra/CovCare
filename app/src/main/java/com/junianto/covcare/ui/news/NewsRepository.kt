package com.junianto.covcare.ui.news

import androidx.lifecycle.LiveData
import com.junianto.covcare.model.NewsData
import com.junianto.covcare.network.api.NetworkState
import com.junianto.covcare.network.api.apiInterface.NewsApiInterface
import com.junianto.covcare.network.repository.NewsDataSource
import io.reactivex.disposables.CompositeDisposable

class NewsRepository (private val apiService: NewsApiInterface) {

    lateinit var newsDataSource: NewsDataSource

    fun fetchNewsCovid (compositeDisposable: CompositeDisposable): LiveData<List<NewsData>> {

        newsDataSource = NewsDataSource(apiService, compositeDisposable)
        newsDataSource.fetchNewsCovid()

        return newsDataSource.covidNewsResponse
    }

    fun getNewsNetworkState(): LiveData<NetworkState> {
        return newsDataSource.networkState
    }
}