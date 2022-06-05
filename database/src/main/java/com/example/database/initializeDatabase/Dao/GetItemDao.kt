package com.example.database.initializeDatabase.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.database.ItemModel

@Dao
interface GetItemDao {

    @Query("SELECT * FROM item_table")
    fun getAllItems(): LiveData<List<ItemModel>>
}