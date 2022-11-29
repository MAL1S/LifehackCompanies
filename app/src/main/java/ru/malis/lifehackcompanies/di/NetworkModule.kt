package ru.malis.lifehackcompanies.di

import dagger.Module
import dagger.Provides
import ru.malis.core_network.api.CompanyApi
import ru.malis.core_network.clients.CompanyClient

@Module
interface NetworkModule {

    companion object {

        @AppScope
        @Provides
        fun provideCompanyApi(): CompanyApi {
            return CompanyClient.buildCompanyApi()
        }
    }
}