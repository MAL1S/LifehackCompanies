package ru.malis.core_data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ru.malis.core_database.dao.CompanyDao
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.repository.CompanyRepository
import ru.malis.core_network.api.CompanyApi
import ru.malis.core_util.coroutinedispatchers.IoDispatcher
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(
    private val companyDao: CompanyDao,
    private val companyApi: CompanyApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : CompanyRepository {

    override suspend fun loadCompanies() {
        withContext(ioDispatcher) {
            val companies = async {
                companyApi.getCompanies()
            }
            companyDao.insertCompanies(companies.await())
        }
    }

    override fun getCompanies(): Flow<List<Company>> {
        return companyDao.getCompanies()
    }

    override suspend fun getCompanyById(id: Int): Company {
        return withContext(ioDispatcher) {
            companyApi.getCompanyById(id)
        }
    }
}