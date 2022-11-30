package ru.malis.lifehackcompanies.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.malis.feature_company_details.api.CompanyDetailsDeps
import ru.malis.feature_company_list.api.CompanyListDeps
import ru.malis.feature_company_list.api.CompanyListDepsProvider
import ru.malis.lifehackcompanies.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
annotation class AppScope

@[AppScope Component(
    modules = [
        CoroutineDispatcherModule::class,
        DatabaseModule::class,
        DataModule::class,
        NetworkModule::class,
        NavigationModule::class,
    ]
)]
interface AppComponent : CompanyListDeps, CompanyDetailsDeps {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @ApplicationContext context: Context
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}

@Qualifier
annotation class ApplicationContext