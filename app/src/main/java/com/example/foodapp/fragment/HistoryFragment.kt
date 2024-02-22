package com.example.foodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.Adapter.BuyAgainAdapter
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter:BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView(){
        val buyAgainFoodName = arrayListOf("foodName1","foodName2","foodName3")
        val buyAgainFoodPrice = arrayListOf("$5","$18","$30")
        val buyAgainFoodImage = arrayListOf(R.drawable.food1,R.drawable.food2,R.drawable.food3)

        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.buyAgianRecyclerView.adapter= buyAgainAdapter
        binding.buyAgianRecyclerView.layoutManager=LinearLayoutManager(requireContext())
    }

    companion object {
    }
}