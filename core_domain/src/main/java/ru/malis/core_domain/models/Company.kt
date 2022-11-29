package ru.malis.core_domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "company")
data class Company(
    @PrimaryKey val id: Int? = null,
    val name: String? = null,
    val img: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    @SerializedName("www") val siteUrl: String? = null,
    val phone: String? = null,
)
