package ru.malis.feature_company_details.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.feature_company_details.api.CompanyDetailsFragment
import ru.malis.feature_company_details.api.CompanyDetailsNavigation
import javax.inject.Inject

internal class CompanyDetailsViewModel @Inject constructor(
    private val getCompanyDetailsUseCase: GetCompanyDetailsUseCase,
    private val companyDetailsNavigation: CompanyDetailsNavigation,
): ViewModel() {

    private val _companyDetailsSharedFlow = MutableSharedFlow<Company>()
    val companyDetailsSharedFlow = _companyDetailsSharedFlow.asSharedFlow()

    fun getCompanyDetails(companyId: Int) {
        viewModelScope.launch {
            getCompanyDetailsUseCase(companyId)
        }
    }

    fun navigateBackToCompanyList(companyDetailsFragment: CompanyDetailsFragment) {
        companyDetailsNavigation.navigateBackToCompanyList(companyDetailsFragment)
    }
}