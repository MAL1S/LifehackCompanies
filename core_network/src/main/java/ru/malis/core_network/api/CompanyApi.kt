package ru.malis.core_network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.malis.core_domain.models.Company
import ru.malis.core_domain.models.CompanyDetails

interface CompanyApi {

    @GET("test.php")
    suspend fun getCompanies(): List<Company>

    @GET("test.php")
    suspend fun getCompanyById(
        @Query("id") id: Int
    ): List<CompanyDetails>
}