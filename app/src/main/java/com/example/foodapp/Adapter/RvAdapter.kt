package com.example.foodapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.DetailsActivity
import com.example.foodapp.R

class RvAdapter(val ds:List<OutData>):RecyclerView.Adapter<RvAdapter.foodViewHolder>() {
    // class viewHolder
    inner class foodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_item,parent,false)
        return foodViewHolder(view)
    }

    override fun onBindViewHolder(holder: foodViewHolder, position: Int) {
        holder.itemView.apply{
            val foodNamePopular = findViewById<TextView>(R.id.foodNamePopular)
            val pricePopular = findViewById<TextView>(R.id.pricePopular)
            val img = findViewById<ImageView>(R.id.imageView)

            foodNamePopular.text = ds[position].foodname
            pricePopular.text=ds[position].price
            img.setImageResource(ds[position].img)
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}