package ru.malis.feature_company_list.api

interface CompanyListNavigation {

    fun navigateToCompanyDetails(companyListFragment: CompanyListFragment, companyId: Int)
}