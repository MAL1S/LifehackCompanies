package ru.malis.lifehackcompanies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.malis.feature_company_list.api.CompanyListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, CompanyListFragment())
            .commit()
    }
}