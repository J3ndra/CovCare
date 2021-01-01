package com.junianto.covcare.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Province(
    @SerializedName("data")
    @Expose
    val data: List<ProvinceData>? = null
): Parcelable