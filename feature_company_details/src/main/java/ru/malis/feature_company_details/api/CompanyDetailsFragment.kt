package ru.malis.feature_company_details.api

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.runtime.image.ImageProvider
import dagger.Lazy
import ru.malis.feature_company_details.R
import ru.malis.feature_company_details.databinding.FragmentCompanyDetailsBinding
import ru.malis.feature_company_details.internal.CompanyDetailsViewModel
import ru.malis.feature_company_details.internal.CompanyDetailsViewModelFactory
import ru.malis.feature_company_details.internal.di.CompanyDetailsComponentViewModel
import javax.inject.Inject
import ru.malis.core_style.R as style


const val BASE_URL = "https://lifehack.studio/test_task/"

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

    var companyId: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        companyDetailsComponentViewModel.companyDetailsComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        companyId = arguments?.getInt(COMPANY_ID)
        binding.companyDetailsContent.visibility = View.GONE
        init()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.companyDetailsMap.onStart()
    }

    override fun onStop() {
        binding.companyDetailsMap.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    private fun init() {
        initDetails()
        initErrorHandling()

        binding.companyDetailsBtnBack.setOnClickListener {
            companyDetailsViewModel.navigateBackToCompanyList(this)
        }
    }

    private fun initDetails() {
        lifecycleScope.launchWhenStarted {
            companyDetailsViewModel.companyDetailsSharedFlow.collect {
                updateContentVisibility()

                if (it.lat != null && it.lon != null) {
                    initMap(it.lat!!, it.lon!!)
                }

                if (it.img != null) {
                    uploadCompanyImage(it.img!!)
                }

                binding.apply {
                    companyDetailsTvName.text = it.name ?: ""
                    companyDetailsTvDescription.text = it.description ?: ""

                    if (it.phone == "") {
                        companyDetailsTvPhone.visibility = View.GONE
                        companyDetailsFabPhone.visibility = View.GONE
                    } else {
                        companyDetailsTvPhone.text = it.phone
                    }

                    if (it.siteUrl == "") {
                        companyDetailsTvSite.visibility = View.GONE
                        companyDetailsFabSite.visibility = View.GONE
                    } else {
                        companyDetailsTvSite.text = it.siteUrl
                    }
                }
            }
        }
        if (companyId != null) {
            companyDetailsViewModel.getCompanyDetails(companyId!!)
        }
    }

    private fun initErrorHandling() {
        lifecycleScope.launchWhenStarted {
            companyDetailsViewModel.errorSharedFlow.collect {
                updateContentVisibility(false)
            }
        }
    }

    private fun uploadCompanyImage(url: String) {
        Glide.with(requireContext())
            .load("$BASE_URL$url")
            .placeholder(style.drawable.ic_image_placeholder)
            .into(binding.companyDetailsIvImage)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initMap(lat: Double, lon: Double) {
        MapKitFactory.initialize(requireContext())

        val point = Point(lat, lon)

        binding.companyDetailsMap.map.move(
            CameraPosition(point, 14f, 0f, 0f),
            Animation(Animation.Type.SMOOTH, 1f),
            null
        )
        setPointOnMap(point)

        binding.companyDetailsMap.setOnTouchListener { v, event ->
            Log.d("testing", "$event")
            when (event.action) {
                MotionEvent.ACTION_DOWN ->
                    binding.companyDetailsMap.parent.requestDisallowInterceptTouchEvent(true)
                MotionEvent.ACTION_UP ->
                    binding.companyDetailsMap.parent.requestDisallowInterceptTouchEvent(false)
            }
            true
        }
    }

    private fun setPointOnMap(point1: Point) {
        val mapObjects = binding.companyDetailsMap.map.mapObjects

        val a = mapObjects.addPlacemark(point1)
        a.setIcon(ImageProvider.fromResource(requireContext(), style.drawable.img_point))
    }

    private fun updateContentVisibility(isSuccess: Boolean = true) {
        binding.apply {
            companyDetailsErrorContent.visibility = if (isSuccess) View.GONE else View.VISIBLE
            companyDetailsContent.visibility = if (isSuccess) View.VISIBLE else View.GONE
            companyDetailsProgressBar.visibility = View.GONE
        }
    }
}