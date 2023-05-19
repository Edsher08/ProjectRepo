package com.example.project

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.project.products.model.Product

@Dao
interface ProductDao{

    @Insert
    fun insert(product: Product)

    @Query("Select * FROM product")
    fun getAllProducts(): LiveData<List<Product>>
}