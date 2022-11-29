package ru.malis.core_database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.malis.core_database.dao.CompanyDao
import ru.malis.core_domain.models.Company

@Database(
    entities = [
        Company::class
    ],
    version = 1
)
abstract class CompanyDB : RoomDatabase() {

    abstract fun getCompanyDao(): CompanyDao
}