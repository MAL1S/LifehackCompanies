package ru.malis.feature_company_list.api

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.malis.feature_company_list.R

class CompanyListFragment: Fragment(R.layout.fragment_company_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {

    }
}