package com.gojek.trendingrepo.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gojek.trendingrepo.data.models.api.BuiltBy
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositories")
data class Repository(

    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "currentPeriodStars")
    val currentPeriodStars: Int,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "forks")
    val forks: Int,

    @ColumnInfo(name = "language")
    val language: String,

    @ColumnInfo(name = "languageColor")
    val languageColor: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "stars")
    val stars: Int,

    @ColumnInfo(name = "url")
    val url: String
)