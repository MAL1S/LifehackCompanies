package ru.malis.feature_company_details.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.malis.core_domain.models.CompanyDetails
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.feature_company_details.api.CompanyDetailsFragment
import ru.malis.feature_company_details.api.CompanyDetailsNavigation
import javax.inject.Inject

internal class CompanyDetailsViewModel @Inject constructor(
    private val getCompanyDetailsUseCase: GetCompanyDetailsUseCase,
    private val companyDetailsNavigation: CompanyDetailsNavigation,
) : ViewModel() {

    private val _companyDetailsSharedFlow = MutableSharedFlow<CompanyDetails>()
    val companyDetailsSharedFlow = _companyDetailsSharedFlow.asSharedFlow()

    private val _errorSharedFlow = MutableSharedFlow<Boolean>()
    val errorSharedFlow = _errorSharedFlow.asSharedFlow()

    fun getCompanyDetails(companyId: Int) {
        viewModelScope.launch {
            val companyDetails = try {
                getCompanyDetailsUseCase(companyId)
            } catch (e: Exception) {
                _errorSharedFlow.emit(true)
                null
            }

            if (companyDetails != null) {
                _companyDetailsSharedFlow.emit(companyDetails)
            }
        }
    }

    fun navigateBackToCompanyList(companyDetailsFragment: CompanyDetailsFragment) {
        companyDetailsNavigation.navigateBackToCompanyList(companyDetailsFragment)
    }
}