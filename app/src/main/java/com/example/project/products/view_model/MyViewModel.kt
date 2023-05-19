package com.example.project.products.view_model

import android.app.Application
import android.content.ContentValues
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.project.SqlDBHelper
import com.example.project.products.model.Product
import com.example.project.products.repository.AddItemsRepository

class MyViewModel(application: Application) : AndroidViewModel(application) {
    val productName = ObservableField<String>()
    val productCode = ObservableField<String>()
    var saveProductCallback: MutableLiveData<Boolean> = MutableLiveData()

    var repository = AddItemsRepository(application)

    fun saveProduct() {
        repository.save()
    }



}