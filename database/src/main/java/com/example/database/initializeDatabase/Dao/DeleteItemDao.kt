package com.example.database.initializeDatabase.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.database.ItemModel

@Dao
interface DeleteItemDao {

    @Delete
    suspend fun deleteItem(item: ItemModel)

    @Query("DELETE FROM item_table")
    suspend fun deleteAllItems()

}