package ru.malis.feature_company_details.api

import android.app.Application
import android.content.Context
import ru.malis.core_domain.usecase.company.GetCompanyDetailsUseCase

interface CompanyDetailsDeps {

    val getCompanyDetailsUseCase: GetCompanyDetailsUseCase
    val companyDetailsNavigation: CompanyDetailsNavigation
}

interface CompanyDetailsDepsProvider {

    val companyDetailsDeps: CompanyDetailsDeps
}

val Context.companyDetailsDepsProvider: CompanyDetailsDepsProvider
    get() = when (this) {
        is CompanyDetailsDepsProvider -> this
        is Application -> error("Application must implement CompanyDetailsDepsProvider")
        else -> applicationContext.companyDetailsDepsProvider
    }