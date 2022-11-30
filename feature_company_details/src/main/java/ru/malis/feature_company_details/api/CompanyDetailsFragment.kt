package ru.malis.feature_company_details.api

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.Lazy
import ru.malis.feature_company_details.R
import ru.malis.feature_company_details.databinding.FragmentCompanyDetailsBinding
import ru.malis.feature_company_details.internal.CompanyDetailsViewModel
import ru.malis.feature_company_details.internal.CompanyDetailsViewModelFactory
import ru.malis.feature_company_details.internal.di.CompanyDetailsComponentViewModel
import javax.inject.Inject

class CompanyDetailsFragment : Fragment(R.layout.fragment_company_details) {

    companion object {

        private const val COMPANY_ID = "company_id"

        fun newInstance(companyId: Int): CompanyDetailsFragment {
            val args = Bundle().apply {
                putInt(COMPANY_ID, companyId)
            }
            val fragment = CompanyDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    internal lateinit var companyDetailsViewModelFactory: Lazy<CompanyDetailsViewModelFactory>

    private val binding by viewBinding(FragmentCompanyDetailsBinding::bind)
    private val companyDetailsViewModel: CompanyDetailsViewModel by viewModels {
        companyDetailsViewModelFactory.get()
    }
    private val companyDetailsComponentViewModel: CompanyDetailsComponentViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        companyDetailsComponentViewModel.companyDetailsComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun init() {

    }


}