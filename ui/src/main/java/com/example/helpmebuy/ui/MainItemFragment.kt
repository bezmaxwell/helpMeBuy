package com.example.helpmebuy.ui
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.businessrule.MainBusinessRule
import com.example.helpmebuy.R
import com.example.helpmebuy.viewModel.GetItemViewModel
import com.example.helpmebuy.viewModel.SetItemViewModel
import kotlinx.coroutines.runBlocking

class MainItemFragment: Fragment() {

    private val getModel: GetItemViewModel by viewModels()
    private val setModel: SetItemViewModel by viewModels()

    private lateinit var btnAction:Button

    private lateinit var nameValue:TextView
    private lateinit var descriptionValue:TextView
    private lateinit var categoryValue:TextView
    private lateinit var quantityValue:TextView
    private lateinit var priceValue:TextView

    private lateinit var checkboxItem:CheckBox


    companion object{
        fun newInstance():MainItemFragment {
            return MainItemFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
       val root =   inflater.inflate(R.layout.base_main_fragment,container,false)

       btnAction = root.findViewById(R.id.btnAddItem)

       nameValue = root.findViewById(R.id.nameItem)
       categoryValue = root.findViewById(R.id.category_value)
       quantityValue = root.findViewById(R.id.quantity_value)
       descriptionValue = root.findViewById(R.id.descriptionItem)

       checkboxItem = root.findViewById(R.id.checkBoxItem)

       actionSendItem(root.context)

       return root
    }

    // separate in two parts one with setItem and other With getItem

    val getNameText = nameValue.text.toString()
    private var setName = setModel.setNameMutableData.postValue(getNameText)

    val getCategoryValue = categoryValue.text.toString()
    private var setCategory = setModel.setCategoryMutableLiveData.postValue(getCategoryValue)

    val getDescriptionText = descriptionValue.text.toString()
    private var setDescription = setModel.setDescriptionMutableLiveData.postValue(getDescriptionText)

    val getPriceText = priceValue.text.toString().toInt()
    private var setPrice = setModel.setPriceMutableData.postValue(getPriceText)

    val getQuantityText = quantityValue.text.toString().toInt()
    private var setQuantityLiveData = setModel.setQuantityMutableData.postValue(getQuantityText)


    private fun actionSendItem(context: Context) {
        btnAction.setOnClickListener {
            passDataToDatabase(context)
        }
    }

    private  fun passDataToDatabase(context: Context){

            MainBusinessRule(context).receiveItemFromUI(setName.toString(),
                setDescription.toString(),setPrice.toString(), setQuantityLiveData.toString().toInt(),setCategory.toString()
            )
    }

    private fun priceChangeColor(textView: TextView,price:Int) {
        if(price < 0 || price == 0 )  textView.setTextColor(Color.RED) else  textView.setTextColor(Color.BLACK)
    }


    //    private fun getAllItemDataBase(){
//
//            getModel.getPrice.observe(viewLifecycleOwner) { items ->
//                categoryValue.text = items.toString()
//
//                // Create the observer which updates the UI.
//                getModel.getPrice.observe(viewLifecycleOwner, Observer { price ->
//                })
////            priceChangeColor(textview,price)
////            priceValue.text = price.toString()
//        }
//    }

}