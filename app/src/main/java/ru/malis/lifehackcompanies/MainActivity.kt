package ru.malis.lifehackcompanies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.malis.feature_company_list.api.CompanyListFragment
import ru.malis.core_style.R as style

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(style.style.Theme_LifehackCompanies)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, CompanyListFragment())
            .commit()
    }
}