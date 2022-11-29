package ru.malis.feature_company_list.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.repository.CompanyRepository
import ru.malis.core_domain.usecase.company.GetCompaniesUseCase
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.core_domain.usecase.company.LoadCompaniesUseCase
import ru.malis.feature_company_list.api.CompanyListFragment
import ru.malis.feature_company_list.api.CompanyListNavigation
import javax.inject.Inject

class CompanyListViewModel @Inject constructor(
    private val getCompaniesUseCase: GetCompaniesUseCase,
    private val loadCompaniesUseCase: LoadCompaniesUseCase,
    private val companyListNavigation: CompanyListNavigation,
): ViewModel() {


    fun getCompanies(): Flow<List<Company>> {
        return getCompaniesUseCase()
    }

    fun loadCompanies() {
        viewModelScope.launch {
            loadCompaniesUseCase()
        }
    }

    fun navigateToCompanyDetails(companyListFragment: CompanyListFragment, companyId: Int) {
        companyListNavigation.navigateToCompanyDetails(companyListFragment, companyId)
    }
}