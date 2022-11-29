package ru.malis.core_database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.malis.core_domain.models.Company

@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompanies(companies: List<Company>)

    @Query("SELECT * FROM company")
    fun getCompanies(): Flow<List<Company>>
}