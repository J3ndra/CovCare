package com.junianto.covcare.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.junianto.covcare.model.news.NewsData
import com.junianto.covcare.network.api.NetworkState
import io.reactivex.disposables.CompositeDisposable

class NewsViewModel (private val newsRepository: NewsRepository): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val newsData: LiveData<List<NewsData>> by lazy {
        newsRepository.fetchNewsCovid(compositeDisposable)
    }

    val networkState: LiveData<NetworkState> by lazy {
        newsRepository.getNewsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}