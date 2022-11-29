package ru.malis.feature_company_list.internal.di

import dagger.Component
import ru.malis.feature_company_list.api.CompanyListDeps
import ru.malis.feature_company_list.api.CompanyListFragment
import javax.inject.Scope

@Scope
annotation class CompanyListScope

@[CompanyListScope Component(
    dependencies = [CompanyListDeps::class]
)]
internal interface CompanyListComponent {

    @Component.Factory
    interface Factory {

        fun create(
            companyListDeps: CompanyListDeps
        ): CompanyListComponent
    }

    fun inject(companyListFragment: CompanyListFragment)
}