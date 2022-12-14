package ru.malis.lifehackcompanies.di

import dagger.Binds
import dagger.Module
import ru.malis.feature_company_details.api.CompanyDetailsNavigation
import ru.malis.feature_company_list.api.CompanyListNavigation
import ru.malis.lifehackcompanies.navigation.CompanyDetailsNavigationImpl
import ru.malis.lifehackcompanies.navigation.CompanyListNavigationImpl

@Module
interface NavigationModule {

    @AppScope
    @Binds
    fun bindCompanyListNavigation(companyListNavigationImpl: CompanyListNavigationImpl): CompanyListNavigation

    @AppScope
    @Binds
    fun bindCompanyDetailsNavigation(companyDetailsNavigationImpl: CompanyDetailsNavigationImpl): CompanyDetailsNavigation
}