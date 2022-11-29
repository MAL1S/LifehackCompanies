package ru.malis.lifehackcompanies.di

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.malis.core_database.dao.CompanyDao
import ru.malis.core_database.db.CompanyDB
import ru.malis.lifehackcompanies.App

@Module
interface DatabaseModule {

    companion object {

        @AppScope
        @Provides
        fun provideCompanyDB(): CompanyDB {
            return Room.databaseBuilder(
                App.INSTANCE.applicationContext,
                CompanyDB::class.java,
                "company_database"
            ).build()
        }

        @AppScope
        @Provides
        fun provideCompanyDao(companyDB: CompanyDB): CompanyDao {
            return companyDB.getCompanyDao()
        }
    }
}