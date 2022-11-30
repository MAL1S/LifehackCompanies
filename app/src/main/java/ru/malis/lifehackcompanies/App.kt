package ru.malis.lifehackcompanies

import android.app.Application
import ru.malis.feature_company_details.api.CompanyDetailsDeps
import ru.malis.feature_company_details.api.CompanyDetailsDepsProvider
import ru.malis.feature_company_list.api.CompanyListDeps
import ru.malis.feature_company_list.api.CompanyListDepsProvider
import ru.malis.lifehackcompanies.di.AppComponent
import ru.malis.lifehackcompanies.di.DaggerAppComponent

class App : Application(), CompanyListDepsProvider, CompanyDetailsDepsProvider {

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
            .create(
                context = this
            )
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    override val companyListDeps: CompanyListDeps = appComponent
    override val companyDetailsDeps: CompanyDetailsDeps = appComponent
}