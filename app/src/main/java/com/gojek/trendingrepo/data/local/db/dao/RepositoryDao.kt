package com.gojek.trendingrepo.data.local.db.dao

import androidx.room.*
import com.gojek.trendingrepo.data.models.db.Repository

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repository: Repository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repositories: List<Repository>)

    @Query("DELETE FROM repositories")
    fun clearRepos()

    @Query("SELECT * FROM repositories")
    fun loadAll(): List<Repository>

}