package com.junianto.covcare.network.api.apiInterface

import com.junianto.covcare.model.news.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {
    @GET("search/")
    fun getCovidNews(
        @Query("q") q:String = "covid"
    ): Single<News>
}