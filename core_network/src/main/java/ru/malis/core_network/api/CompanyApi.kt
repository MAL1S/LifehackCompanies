package ru.malis.core_network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.malis.core_domain.models.Company

interface CompanyApi {

    @GET("test.php")
    suspend fun getCompanies(
        //category: String
    ): List<Company>

    @GET("test.php")
    suspend fun getCompanyById(
        @Query("id") id: Int
    ): Company
}