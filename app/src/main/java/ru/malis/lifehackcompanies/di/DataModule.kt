package ru.malis.lifehackcompanies.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.malis.core_data.repository.CompanyRepositoryImpl
import ru.malis.core_database.dao.CompanyDao
import ru.malis.core_domain.repository.CompanyRepository
import ru.malis.core_network.api.CompanyApi
import ru.malis.core_util.coroutinedispatchers.IoDispatcher


@Module
interface DataModule {

    companion object {

        @AppScope
        @Provides
        fun provideCompanyRepository(
            companyDao: CompanyDao,
            companyApi: CompanyApi,
            @IoDispatcher ioDispatcher: CoroutineDispatcher,
        ): CompanyRepository {
            return CompanyRepositoryImpl(companyDao, companyApi, ioDispatcher)
        }
    }
}