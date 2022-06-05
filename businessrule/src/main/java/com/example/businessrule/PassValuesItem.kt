package com.example.businessrule

abstract class PassValuesItem {

        abstract fun getValuesFromUI():ItemFromUI
        abstract fun getValuesFromDatabase():ItemFromDatabase

}