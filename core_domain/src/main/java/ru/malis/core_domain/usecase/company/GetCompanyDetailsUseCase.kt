package ru.malis.core_domain.usecase.company

import ru.malis.core_domain.models.CompanyDetails
import ru.malis.core_domain.repository.CompanyRepository
import javax.inject.Inject

class GetCompanyDetailsUseCase @Inject constructor(
    private val companyRepository: CompanyRepository
) {

    suspend operator fun invoke(companyId: Int): CompanyDetails {
        return companyRepository.getCompanyById(companyId)
    }
}