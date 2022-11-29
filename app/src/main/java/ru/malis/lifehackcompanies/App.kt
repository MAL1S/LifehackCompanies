package ru.malis.lifehackcompanies

import android.app.Application
import ru.malis.feature_company_list.api.CompanyListDeps
import ru.malis.feature_company_list.api.CompanyListDepsProvider
import ru.malis.lifehackcompanies.di.AppComponent
import ru.malis.lifehackcompanies.di.DaggerAppComponent

class App : Application(), CompanyListDepsProvider {

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
}