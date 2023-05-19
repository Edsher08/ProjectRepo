package com.example.project.products.repository

import android.content.Context
import com.example.project.products.model.Product
import com.example.project.SqlDBHelper

class MainRepository(context: Context) {
    private val db = SqlDBHelper(context).readableDatabase

    fun getProducts() : ArrayList<Product>{
        val cursor = db.query(
            SqlDBHelper.TABLE_NAME,
            arrayOf(SqlDBHelper.COLUMN_NAME, SqlDBHelper.COLUMN_CODE),
            null,
            null,
            null,
            null,
            null
        )
        val productList:ArrayList<Product> = ArrayList()
        with(cursor) {
            while (moveToNext()) {
                val productName = getString(getColumnIndexOrThrow(SqlDBHelper.COLUMN_NAME))
                val productCode = getString(getColumnIndexOrThrow(SqlDBHelper.COLUMN_CODE))
                productList.add(Product(productName, productCode))
            }
        }
        cursor.close()
        return productList
    }
}