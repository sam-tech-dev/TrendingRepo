package com.gojek.trendingrepo.ui.main

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gojek.trendingrepo.data.models.db.Repository
import com.google.gson.Gson

class RepositoryItemViewModel : ViewModel() {

    /*var localityName = MutableLiveData<String>()
    var localityAddress = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var mobileNumber = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var profileUrl = MutableLiveData<String>()*/

    var repositoryData = MutableLiveData<Repository>()


    fun bind(repository: Repository) {
        repositoryData.value= repository

       /* localityName.value = ambassador.localityKey
        localityAddress.value = ambassador.tahsil + ", " + ambassador.district
        name.value = ambassador.name
        mobileNumber.value = ambassador.mobileNo
        email.value = ambassador.email
        profileUrl.value=ambassador.profilePic*/
    }

}