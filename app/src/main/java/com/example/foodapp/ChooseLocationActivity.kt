package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.foodapp.databinding.ActivityChosseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChosseLocationBinding by lazy{
        ActivityChosseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listOfLocation = resources.getStringArray(R.array.listOfLocation)

        val adapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,listOfLocation)
        val autoCompleteTextView: AutoCompleteTextView =binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

    }
}