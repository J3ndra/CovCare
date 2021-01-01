package com.junianto.covcare.network.api.apiInterface

import com.junianto.covcare.model.IndonesiaCases
import com.junianto.covcare.model.Province
import io.reactivex.Single
import retrofit2.http.GET

interface CovidApiInterface {
    @GET("api/")
    fun getIndonesiaDetails(): Single<IndonesiaCases>

    @GET("api/provinsi/")
    fun getProvinceDetails(): Single<Province>
}