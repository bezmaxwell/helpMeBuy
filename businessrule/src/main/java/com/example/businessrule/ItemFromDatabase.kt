package com.example.businessrule

interface ItemFromDatabase {

    fun passItemFromDatabase(name:String,description: String,price: String,quantity: Int,categoryItem: String)
}