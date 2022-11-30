package ru.malis.core_domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.malis.core_domain.models.base.BaseIdClass

@Entity(tableName = "company")
data class Company(
    @PrimaryKey override val id: Int = 0,
    val name: String? = null,
    val img: String? = null,
): BaseIdClass()
