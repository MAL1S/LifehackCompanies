package ru.malis.core_domain.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CompanyDetails(
    @PrimaryKey val id: Int = 0,
    val name: String? = null,
    val img: String? = null,
    val description: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    @SerializedName("www") val siteUrl: String? = null,
    val phone: String? = null,
)
