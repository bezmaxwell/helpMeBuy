package com.example.database.initializeDatabase.Dao

import androidx.room.Dao
import androidx.room.Update
import com.example.database.ItemModel

@Dao
interface UpdateItemDao {

    @Update
    suspend fun updateAllItems(vararg item: ItemModel)
}