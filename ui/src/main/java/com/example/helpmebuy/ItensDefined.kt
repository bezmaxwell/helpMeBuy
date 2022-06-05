package com.example.helpmebuy

import com.example.database.ItemModel

class ItensDefined {

    fun ItemDefined():ArrayList<ItemModel>{

        val listItems:ArrayList<ItemModel> = arrayListOf()
         listItems.add(ItemModel(1,"Beef","Beef need to be buy in the x Supermarket","36",3,"Meat"))
         listItems.add(ItemModel(2,"Broccoli","Broccoli is good for the blood,mind and health","0.30",1,"Vegetable"))
         listItems.add(ItemModel(3,"Soda","Soda is not so good for the health","2.3",3,"Drinks"))

        return  listItems
    }

    fun CategoryList():ArrayList<String> {

        val categoryList:ArrayList<String> = ArrayList()
        val list = arrayListOf<String>("Meat","Vegetable","Drinks","Cleaning")
        categoryList.addAll(list)

        return  categoryList
    }

    fun UnitOfMeasurementList():ArrayList<String> {

        val unitList:ArrayList<String> = ArrayList()
        val list = arrayListOf("KG","MG","Pound")
        unitList.addAll(list)

        return unitList
    }
}