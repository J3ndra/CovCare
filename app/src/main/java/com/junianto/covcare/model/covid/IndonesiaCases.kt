package com.junianto.covcare.model.covid

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IndonesiaCases(

	@SerializedName("jumlahKasus")
	val jumlahKasus: String? = null,

	@SerializedName("meninggal")
	val meninggal: String? = null,

	@SerializedName("sembuh")
	val sembuh: String? = null,

	@SerializedName("lastUpdate")
	val lastUpdate: Long? = null,

	@SerializedName("perawatan")
	val perawatan: String? = null
) : Parcelable
