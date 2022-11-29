package ru.malis.core_domain.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "company")
data class Company(
    val id: Int? = null,
    val name: String? = null,
    val img: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    @SerializedName("www") val siteUrl: String? = null,
    val phone: String? = null,
)
