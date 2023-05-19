package com.example.project.products.repository

import android.content.ContentValues
import android.content.Context
import androidx.databinding.ObservableField
import com.example.project.SqlDBHelper
import com.example.project.products.model.Product

class AddItemsRepository(private val context: Context) {

    private var saveProductCallback: SaveProductCallback? = null
    val productName = ObservableField<String>()
    val productCode = ObservableField<String>()
    fun save(){
        val databaseHelper = SqlDBHelper(context).writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SqlDBHelper.COLUMN_NAME, productName.get())
        contentValues.put(SqlDBHelper.COLUMN_CODE, productCode.get())

        val rowId = databaseHelper.insert(SqlDBHelper.TABLE_NAME, null, contentValues)
        databaseHelper.close()

        if (rowId != -1L) {
            saveProductCallback?.onSaveSuccess()
        } else {
            saveProductCallback?.onSaveFailure()
        }
        return TODO("Provide the return value")
    }
    interface SaveProductCallback {
        fun onSaveSuccess()
        fun onSaveFailure()
    }
}