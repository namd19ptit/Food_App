package com.example.foodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodapp.Adapter.OutData
import com.example.foodapp.Adapter.RvAdapter
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)

        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog= MenuBootomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        val ds = mutableListOf<OutData>()
        ds.add(OutData(R.drawable.food1,"Herbal Pancake","$ 5"))
        ds.add(OutData(R.drawable.food2,"Fruit Salad","$ 8"))
        ds.add(OutData(R.drawable.food3,"Green Noddle","$ 15"))
        ds.add(OutData(R.drawable.food4,"Spacy fresh crab","$ 35"))
        ds.add(OutData(R.drawable.food5,"Cream","$ 7"))
        ds.add(OutData(R.drawable.food6,"Soup","$ 18"))

        val adapter = RvAdapter(ds)
        binding.rvFood.adapter=adapter

        binding.rvFood.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

    }

    companion object{

    }
}