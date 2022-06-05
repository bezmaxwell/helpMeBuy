package com.example.database.initializeDatabase.Dao

import androidx.room.Dao
import androidx.room.Query
import com.example.database.ItemModel

@Dao
interface FindItemDao {

    @Query("SELECT * FROM item_table WHERE name_item LIKE :item AND " +
            "category_item LIKE :category LIMIT 1")
    suspend fun findItemByCategory(item: String, category: String): ItemModel

}