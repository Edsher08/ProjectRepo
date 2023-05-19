package com.example.project.products.repository

import android.content.ContentValues
import com.example.project.SqlDBHelper

class AddItemsRepository {

    fun save(){
        val databaseHelper = SqlDBHelper(getApplication())
        val db = databaseHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(SqlDBHelper.COLUMN_NAME, name)
        contentValues.put(SqlDBHelper.COLUMN_CODE, code)

        val rowId = db.insert(SqlDBHelper.TABLE_NAME, null, contentValues)
        db.close()
    }
}