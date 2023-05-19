package com.example.project.products.view_model

import android.app.Application
import android.content.ContentValues
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.project.SqlDBHelper

class MyViewModel(application: Application) : AndroidViewModel(application) {
    val productName = ObservableField<String>()
    val productCode = ObservableField<String>()
    var saveProductCallback: MutableLiveData<Boolean> = MutableLiveData()

    fun saveProduct() {
        val name = productName.get()
        val code = productCode.get()




        saveProductCallback.value = rowId != -1L
    }



}