package ru.malis.lifehackcompanies

import android.app.Application
import com.yandex.mapkit.MapKitFactory
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
        MapKitFactory.setApiKey("47293adf-d377-4145-8282-36cbaa6bfa56")
    }

    override val companyListDeps: CompanyListDeps = appComponent
    override val companyDetailsDeps: CompanyDetailsDeps = appComponent
}