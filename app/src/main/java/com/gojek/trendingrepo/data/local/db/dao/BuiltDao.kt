package com.gojek.trendingrepo.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gojek.trendingrepo.data.models.db.Built


@Dao
interface BuiltDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(built: Built )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(builts: List<Built>)

    @Query("SELECT * FROM builders")
    fun loadAll(): List<Built>

}