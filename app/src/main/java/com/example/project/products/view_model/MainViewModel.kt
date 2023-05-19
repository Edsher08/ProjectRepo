package com.example.project.products.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project.products.model.Product
import com.example.project.products.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MainRepository(application)
    private val productLiveData = MutableLiveData<List<Product>>()

    fun loadProduct(){
        productLiveData.value = repository.getProducts()
    }

    fun getProducts(): LiveData<List<Product>>{
        return  productLiveData
    }
}