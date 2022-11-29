package ru.malis.core_domain.usecase.company

import ru.malis.core_domain.models.Company
import ru.malis.core_domain.repository.CompanyRepository
import javax.inject.Inject

class GetCompanyDetailsUseCase @Inject constructor(
    private val companyRepository: CompanyRepository
) {

    suspend fun invoke(companyId: Int): Company {
        return companyRepository.getCompanyById(companyId)
    }
}