package ru.malis.feature_company_details.internal.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.malis.feature_company_details.api.companyDetailsDepsProvider

internal class CompanyDetailsComponentViewModel(
    application: Application
): AndroidViewModel(application) {

    val companyDetailsComponent: CompanyDetailsComponent by lazy {
        DaggerCompanyDetailsComponent.factory().create(
            companyDetailsDeps = application.companyDetailsDepsProvider.companyDetailsDeps
        )
    }
}