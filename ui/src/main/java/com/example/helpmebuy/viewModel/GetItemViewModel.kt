package com.example.helpmebuy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking

class GetItemViewModel(): ViewModel() {

    init {
        getAllItemDataBase()
    }

   // private var databaseItem: DatabaseItem = DatabaseItem(context)

    private val mutableNameItem:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val livedataNameItem: LiveData<String> = mutableNameItem


    private val getPriceMutableData:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val getPrice:LiveData<String> = getPriceMutableData

//
//    private val mutableDescriptionItem:MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//    val livedataDescriptionItem: LiveData<String> = mutableDescriptionItem
//
//
//    private val mutableCategoryItem:MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//    val liveDataCategoryItem:LiveData<String> = mutableCategoryItem

//    private fun nameItem(){
//        if(mutableNameItem.value != null || mutableNameItem.value != "") {
//            name.lowercase()
//            mutableNameItem.value = name
//
//        }else {
//            mutableNameItem.value = "No Name"
//        }
//    }
//    private fun descriptionItem() {
//
//        if(mutableDescriptionItem.value !=null || mutableDescriptionItem.value != "" || mutableDescriptionItem.value!!.isNotEmpty()){
//           mutableDescriptionItem.value = description
//
//        }else {
//            mutableCategoryItem.value = "No Description"
//
//        }
//    }
//
    private fun getAllItemDataBase(){

  //  val allitems = databaseItem.getItemDao()

    runBlocking {

        val position = 1
//        allitems.getAllItems().value?.let {value ->
//        val priceValue = value[position].price_item
//        getPriceMutableData.value = priceValue

    }


    }
}


//    private fun changePrice() {
//       if(mutablePrice.value != 0 || mutablePrice.value != null) {
//           mutablePrice.value = price
//       }else {
//           mutablePrice.value = 0
//       }
//    }


//
//    private fun verifyCategory() {
//
//    if(!(mutableCategoryItem.value.isNullOrEmpty())) {
//        mutableCategoryItem.value = category
//
//    }else{
//        mutableCategoryItem.value = "No category"
//    }
//
//    }
//}