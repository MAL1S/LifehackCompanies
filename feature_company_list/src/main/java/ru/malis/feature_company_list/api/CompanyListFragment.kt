package ru.malis.feature_company_list.api

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.Lazy
import kotlinx.coroutines.launch
import ru.malis.core_base.BaseDiffUtilCallback
import ru.malis.core_base.VerticalSpaceItemDecorator
import ru.malis.core_domain.models.Company
import ru.malis.feature_company_list.R
import ru.malis.feature_company_list.databinding.FragmentCompanyListBinding
import ru.malis.feature_company_list.internal.CompanyListViewModel
import ru.malis.feature_company_list.internal.CompanyListViewModelFactory
import ru.malis.feature_company_list.internal.adapter.CompanyListAdapter
import ru.malis.feature_company_list.internal.di.CompanyListComponentViewModel
import javax.inject.Inject

class CompanyListFragment: Fragment(R.layout.fragment_company_list) {

    @Inject
    internal lateinit var companyListViewModelFactory: Lazy<CompanyListViewModelFactory>

    private val binding by viewBinding(FragmentCompanyListBinding::bind)
    private val companyListViewModel: CompanyListViewModel by viewModels {
        companyListViewModelFactory.get()
    }
    private val companyListComponentViewModel: CompanyListComponentViewModel by viewModels()

    private val companyListAdapter = CompanyListAdapter {
        companyListViewModel.navigateToCompanyDetails(this, it)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        companyListComponentViewModel.companyListComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        initCompanies()
    }

    private fun initCompanies() {
        binding.companyListRcvCompanies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = companyListAdapter
            addItemDecoration(VerticalSpaceItemDecorator())
        }

        lifecycleScope.launch {
            companyListViewModel.getCompanies().collect {
                triggerCompanyDiffUtil(it)
            }
        }

        companyListViewModel.loadCompanies()
    }

    private fun triggerCompanyDiffUtil(newCompanies: List<Company>) {
        val diffUtilCallback =
            BaseDiffUtilCallback(companyListAdapter.companies, newCompanies)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        companyListAdapter.companies = newCompanies.toMutableList()
        diffResult.dispatchUpdatesTo(companyListAdapter)
    }
}