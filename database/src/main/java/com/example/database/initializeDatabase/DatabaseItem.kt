package com.example.database.initializeDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.ItemModel
import com.example.database.initializeDatabase.Dao.*

@Database(entities = [ItemModel::class], version = 1)
abstract class DatabaseItem : RoomDatabase() {

        abstract fun getItemDao(): GetItemDao
        abstract fun findItemDao(): FindItemDao
        abstract fun updateItemDao(): UpdateItemDao
        abstract fun insertItemDao(): InsertItemDao
        abstract fun deleteItemDao(): DeleteItemDao

        companion object {

                @Volatile
                private var instance: DatabaseItem? = null
                private val LOCK = Any()

                operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
                        instance ?: buildDatabase(context).also { instance = it}
                }

                private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                        DatabaseItem::class.java, "item.db")
                        .build()


        }
}


