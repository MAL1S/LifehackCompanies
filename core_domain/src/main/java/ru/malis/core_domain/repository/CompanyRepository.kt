package ru.malis.core_domain.repository

import kotlinx.coroutines.flow.Flow
import ru.malis.core_domain.models.Company

interface CompanyRepository {

    fun getCompanies(): Flow<List<Company>>

    suspend fun getCompanyById(id: Int): Company
}