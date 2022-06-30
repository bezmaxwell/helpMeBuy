package com.example.helpmebuy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SetItemViewModel: ViewModel(),CoroutineScope {

    init {
        validatePrice()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + viewModelJob


    val setNameMutableData:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val setNameItemLiveData:LiveData<String> = setNameMutableData


    val setDescriptionMutableLiveData:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val descriptionLiveData:LiveData<String> = setDescriptionMutableLiveData


    var setPriceMutableData:MutableLiveData<Int> = MutableLiveData<Int>()

    private val setPriceLiveData:LiveData<Int> = setPriceMutableData


    val setQuantityMutableData:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    private val setQuantityLiveData:LiveData<Int> = setPriceMutableData


    val setCategoryMutableLiveData:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val setCategoryLiveData:LiveData<String> = setCategoryMutableLiveData


    private val viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    /** We have types like
     * name - String , description -  String, price - Double, category- String ,
        validate if is null, or empty ...
     * */

    private fun validateItemString(value:String):String {
        var valueString = value
        if(valueString != "" || valueString.isNotEmpty()) {
           return valueString
        }else{
            valueString = "No value"
            return valueString
        }
    }

    private fun validateItemInt(value:Int):Int {
        var valueItem = value
        if(valueItem != 0 || valueItem > 0 || valueItem != null) {
            return valueItem
        }else{
            valueItem = 0
            return valueItem
        }
    }

    private fun validateName(): String? {
        val nameItem = setNameMutableData
        return nameItem.value?.let { validateItemString(it) }
    }

    private fun validateDescription():String? {
        val descriptionItem = setDescriptionMutableLiveData
        return descriptionItem.value?.let { validateItemString(it) }
    }

    private fun validatePrice():Int? {
        val priceItem = setPriceMutableData
       return run {
             priceItem.value?.let { validateItemInt(it) }
        }
    }

    private fun validateQuantity():Int? {
        val quantity = setQuantityMutableData
        return quantity.value?.let { validateItemInt(it) }
    }

    private fun validateCategory():String? {
        val categoryItem = setCategoryMutableLiveData
        return categoryItem.value?.let { validateItemString(it) }
    }


}