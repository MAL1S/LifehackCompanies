package ru.malis.feature_company_list.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.malis.core_domain.usecase.company.GetCompaniesUseCase
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.core_domain.usecase.company.LoadCompaniesUseCase
import ru.malis.feature_company_list.api.CompanyListNavigation
import javax.inject.Inject
import javax.inject.Provider

class CompanyListViewModelFactory @Inject constructor(
    private val getCompaniesUseCase: Provider<GetCompaniesUseCase>,
    private val loadCompaniesUseCase: Provider<LoadCompaniesUseCase>,
    private val companyListNavigation: Provider<CompanyListNavigation>,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CompanyListViewModel(
            getCompaniesUseCase = getCompaniesUseCase.get(),
            loadCompaniesUseCase = loadCompaniesUseCase.get(),
            companyListNavigation = companyListNavigation.get()
        ) as T
    }
}