package com.example.businessrule

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.room.Room
import com.example.database.ItemModel
import com.example.database.initializeDatabase.DatabaseItem
import kotlinx.coroutines.runBlocking

class MainBusinessRule(val context: Context):Application(),ItemFromUI  {

    lateinit var db:DatabaseItem

    override fun onCreate() {

        db = Room.databaseBuilder(context.applicationContext,
            DatabaseItem::class.java, "todo-list.db"
        ).build()

        super.onCreate()
    }

    //private val setModel: SetItemViewModel by viewModels()

    //receive the values from viewModel func
    override fun receiveItemFromUI(name:String,description: String,price: String,quantity: Int,categoryItem: String) {
        if (name != "" && description != "" && price != "" && quantity != 0 && categoryItem != "") {
            insertItemDataBase(name, description, price, quantity, categoryItem)
        } else {
            Toast.makeText(context, "Error not possible insert item", Toast.LENGTH_LONG)
        }

    }

    //insert the values onDatabase
    private fun insertItemDataBase(name:String,description: String, price:String, quantity:Int,categoryItem:String) {

            runBlocking {
                db.insertItemDao()
                    .insertItem(ItemModel(0, name, description,price,quantity,categoryItem))
            }
        }
    }

