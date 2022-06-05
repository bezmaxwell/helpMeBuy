package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
  * Image,
  *
  * Compare prices with others supermarket (business rule to implement the logic
  * Logic - we have three price, for example and we want to see best price between the markets,
  * We can update the other prices to ,we list separate the prices comparisons by category)
  * */

@Entity(tableName = "item_table")
data class ItemModel(
    @PrimaryKey(autoGenerate = false) var uid: Int? = null,
    var name_item: String,
    var description_item:String,
    var price_item:String,
    var quantity:Int,
    var category_item:String)
