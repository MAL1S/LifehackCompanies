package ru.malis.feature_company_list.internal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.models.base.BaseIdClass
import ru.malis.feature_company_list.R
import ru.malis.feature_company_list.databinding.ItemCompanyBinding
import ru.malis.core_style.R as style

const val BASE_URL = "https://lifehack.studio/test_task/"

internal class CompanyListAdapter(
    private val onCompanyItemClickedListener: OnCompanyItemClickedListener
) : RecyclerView.Adapter<CompanyListAdapter.CompanyListViewHolder>() {

    inner class CompanyListViewHolder(
        inflater: LayoutInflater,
        private val parent: ViewGroup,
        private val onCompanyItemClickedListener: OnCompanyItemClickedListener
    ) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_company, parent, false)) {

        private val binding by viewBinding(ItemCompanyBinding::bind)

        fun bind(company: Company) {
            binding.apply {
                company.img?.let {
                    uploadImage(it)
                }

                binding.itemCompanyTvName.text = company.name ?: ""

                itemView.setOnClickListener {
                    onCompanyItemClickedListener.onClicked(company.id)
                }
            }
        }

        private fun uploadImage(url: String) {
            Glide.with(parent.context)
                .load("$BASE_URL$url")
                .placeholder(style.drawable.ic_image_placeholder)
                .into(binding.itemCompanyIvImage)
        }
    }

    var companies = mutableListOf<Company>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CompanyListViewHolder(inflater, parent, onCompanyItemClickedListener)
    }

    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        val company = companies[position]
        holder.bind(company)
    }

    override fun getItemCount(): Int = companies.size
}

internal fun interface OnCompanyItemClickedListener {

    fun onClicked(companyId: Int)
}