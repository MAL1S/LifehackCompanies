package ru.malis.feature_company_list.internal.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.malis.feature_company_list.api.companyListDepsProvider

internal class CompanyListComponentViewModel(
    application: Application
): AndroidViewModel(application) {

    val companyListComponent: CompanyListComponent by lazy {
        DaggerCompanyListComponent.factory().create(
            companyListDeps = application.companyListDepsProvider.companyListDeps
        )
    }
}