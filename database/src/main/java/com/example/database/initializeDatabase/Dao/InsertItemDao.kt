package com.example.database.initializeDatabase.Dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.database.ItemModel

@Dao
interface InsertItemDao {

    @Insert
    suspend fun insertItem(item: ItemModel)

}