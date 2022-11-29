package ru.malis.core_domain.usecase.company

import ru.malis.core_domain.repository.CompanyRepository
import javax.inject.Inject

class LoadCompaniesUseCase @Inject constructor(
    private val companyRepository: CompanyRepository
) {

    suspend operator fun invoke() {
        companyRepository.loadCompanies()
    }
}