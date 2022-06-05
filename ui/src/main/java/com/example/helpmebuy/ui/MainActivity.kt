package com.example.helpmebuy.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.helpmebuy.viewModel.GetItemViewModel
import com.example.helpmebuy.R
import com.example.helpmebuy.viewModel.SetItemViewModel
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.base_first_fragment,
                    MainItemFragment.newInstance(), "mainItemFragment").commit()
        }

    }

}
