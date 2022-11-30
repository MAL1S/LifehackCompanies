package ru.malis.feature_company_details.internal.di

import dagger.Component
import ru.malis.feature_company_details.api.CompanyDetailsDeps
import ru.malis.feature_company_details.api.CompanyDetailsFragment
import javax.inject.Scope

@Scope
annotation class CompanyDetailsScope

@[CompanyDetailsScope Component(
    dependencies = [CompanyDetailsDeps::class]
)]
internal interface CompanyDetailsComponent {

    @Component.Factory
    interface Factory {

        fun create(
            companyDetailsDeps: CompanyDetailsDeps
        ): CompanyDetailsComponent
    }

    fun inject(companyDetailsFragment: CompanyDetailsFragment)
}