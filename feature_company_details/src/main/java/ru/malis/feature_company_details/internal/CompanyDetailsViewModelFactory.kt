package ru.malis.feature_company_details.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.feature_company_details.api.CompanyDetailsNavigation
import javax.inject.Inject
import javax.inject.Provider

class CompanyDetailsViewModelFactory @Inject constructor(
    private val getCompanyDetailsUseCase: Provider<GetCompanyDetailsUseCase>,
    private val companyDetailsNavigation: Provider<CompanyDetailsNavigation>,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CompanyDetailsViewModel(
            getCompanyDetailsUseCase = getCompanyDetailsUseCase.get(),
            companyDetailsNavigation = companyDetailsNavigation.get()
        ) as T
    }
}