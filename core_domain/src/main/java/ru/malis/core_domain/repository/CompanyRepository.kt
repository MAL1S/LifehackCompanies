package ru.malis.core_domain.repository

import kotlinx.coroutines.flow.Flow
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.models.CompanyDetails

interface CompanyRepository {

    suspend fun loadCompanies()

    fun getCompanies(): Flow<List<Company>>

    suspend fun getCompanyById(id: Int): CompanyDetails
}