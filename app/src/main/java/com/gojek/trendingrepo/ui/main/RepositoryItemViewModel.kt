package com.gojek.trendingrepo.ui.main

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gojek.trendingrepo.data.models.db.Repository
import com.google.gson.Gson

class RepositoryItemViewModel : ViewModel() {

    var repositoryData = MutableLiveData<Repository>()

    fun bind(repository: Repository) {
        repositoryData.value= repository
    }
}