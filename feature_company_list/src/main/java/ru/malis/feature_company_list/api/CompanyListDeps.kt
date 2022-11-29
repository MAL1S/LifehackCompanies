package ru.malis.feature_company_list.api

import android.app.Application
import android.content.Context
import ru.malis.core_domain.usecase.company.GetCompaniesUseCase
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase
import ru.malis.core_domain.usecase.company.LoadCompaniesUseCase

interface CompanyListDeps {

    val getCompaniesUseCase: GetCompaniesUseCase
    val loadCompaniesUseCase: LoadCompaniesUseCase
    val companyListNavigation: CompanyListNavigation
}

interface CompanyListDepsProvider {

    val companyListDeps: CompanyListDeps
}

val Context.companyListDepsProvider: CompanyListDepsProvider
    get() = when (this) {
        is CompanyListDepsProvider -> this
        is Application -> error("Application must implement CompanyListDepsProvider")
        else -> applicationContext.companyListDepsProvider
    }