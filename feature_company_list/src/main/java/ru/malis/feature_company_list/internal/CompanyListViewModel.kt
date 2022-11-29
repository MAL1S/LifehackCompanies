package ru.malis.feature_company_list.internal

import androidx.lifecycle.ViewModel
import ru.malis.core_domain.repository.CompanyRepository
import ru.malis.core_domain.usecase.company.GetCompaniesUseCase
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.feature_company_list.api.CompanyListNavigation
import javax.inject.Inject

class CompanyListViewModel @Inject constructor(
    private val getCompaniesUseCase: GetCompaniesUseCase,
    private val companyListNavigation: CompanyListNavigation
): ViewModel() {


}