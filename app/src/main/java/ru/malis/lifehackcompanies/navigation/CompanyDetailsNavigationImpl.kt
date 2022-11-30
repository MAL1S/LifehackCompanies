package ru.malis.lifehackcompanies.navigation

import ru.malis.feature_company_details.api.CompanyDetailsFragment
import ru.malis.feature_company_details.api.CompanyDetailsNavigation
import ru.malis.lifehackcompanies.navigation.Routes.popBackStack
import javax.inject.Inject

class CompanyDetailsNavigationImpl @Inject constructor(): CompanyDetailsNavigation {

    override fun navigateBackToCompanyList(companyDetailsFragment: CompanyDetailsFragment) {
        companyDetailsFragment.popBackStack()
    }
}