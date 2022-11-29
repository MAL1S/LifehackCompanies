package ru.malis.lifehackcompanies.navigation

import ru.malis.feature_company_list.api.CompanyListFragment
import ru.malis.feature_company_list.api.CompanyListNavigation
import ru.malis.lifehackcompanies.navigation.Routes.navigateToCompanyDetails
import javax.inject.Inject

class CompanyListNavigationImpl @Inject constructor(): CompanyListNavigation {

    override fun navigateToCompanyDetails(companyListFragment: CompanyListFragment, companyId: Int) {
        companyListFragment.navigateToCompanyDetails(companyId)
    }
}