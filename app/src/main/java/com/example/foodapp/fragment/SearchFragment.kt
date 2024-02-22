package com.example.foodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Adapter.MenuAdapter
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentSearchBinding
//import com.google.android.material.search.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import android.widget.SearchView



class SearchFragment : Fragment() {
    private lateinit var adapter: MenuAdapter
    private lateinit var binding:FragmentSearchBinding
    private val originalMenuFoodName = listOf("Burger","Sandwich","momo","item","noodle")
    private val originalMenuItemPrice= listOf("$5","$8","$15","$35","$28")
    private val originalMenuImage= listOf(
        R.drawable.food1,
        R.drawable.food2,
        R.drawable.food3,
        R.drawable.food4,
        R.drawable.food5,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    private val filtereMenuFoodName = mutableListOf<String>()
    private val filtereMenuItemPrice = mutableListOf<String>()
    private val filtereMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter= MenuAdapter(filtereMenuFoodName,filtereMenuItemPrice,filtereMenuImage,requireContext())
        binding.menuRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter

        setupSearchView()
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filtereMenuFoodName.clear()
        filtereMenuItemPrice.clear()
        filtereMenuImage.clear()

        filtereMenuFoodName.addAll(originalMenuFoodName)
        filtereMenuItemPrice.addAll(originalMenuItemPrice)
        filtereMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun  filterMenuItems(query:String?){
        filtereMenuFoodName.clear()
        filtereMenuItemPrice.clear()
        filtereMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodname ->
            if(foodname.contains(query.toString(), ignoreCase = true)){
                filtereMenuFoodName.add(foodname)
                filtereMenuItemPrice.add(originalMenuItemPrice[index])
                filtereMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {
        
    }
}