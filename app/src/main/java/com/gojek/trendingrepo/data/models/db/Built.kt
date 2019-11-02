package com.gojek.trendingrepo.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "builders", foreignKeys = arrayOf(ForeignKey(entity = Repository::class,
    parentColumns = arrayOf("uid"),
    childColumns = arrayOf("repositoryId"),
    onDelete = ForeignKey.CASCADE)))

data class Built(

    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "href")
    val href: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "repositoryId")
     val repositoryId: Int
)