package ru.malis.core_domain.usecase.company

import kotlinx.coroutines.flow.Flow
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.repository.CompanyRepository
import javax.inject.Inject

class GetCompaniesUseCase @Inject constructor(
    private val companyRepository: CompanyRepository
) {

    operator fun invoke(): Flow<List<Company>> {
        return companyRepository.getCompanies()
    }
}