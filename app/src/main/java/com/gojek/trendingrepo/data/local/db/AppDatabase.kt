package com.gojek.trendingrepo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gojek.trendingrepo.data.local.db.dao.RepositoryDao
import com.gojek.trendingrepo.data.models.db.Repository

@Database(entities = [Repository::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao

}
