package com.example.foodapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>,private val CartItemPrice: MutableList<String>,private val CartImage: MutableList<Int>):
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuatities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CartViewHolder(private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply{
                val quatity=itemQuatities[position]
                cartFoodName.text=cartItems[position]
                cartItemPrice.text=CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuatity.text=quatity.toString()

                minusbutton.setOnClickListener {
                    deceaseQuatity(position)
                }
                plusebutton.setOnClickListener {
                    increaseQuatity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(position)
                    }
                }
            }
        }
        private fun deceaseQuatity(position:Int){
            if(itemQuatities[position]>1){
                itemQuatities[position]--
                binding.cartItemQuatity.text=itemQuatities[position].toString()
            }
        }
        private fun increaseQuatity(position:Int){
            if(itemQuatities[position]<10){
                itemQuatities[position]++
                binding.cartItemQuatity.text=itemQuatities[position].toString()
            }
        }
        private fun deleteItem(position:Int){
            cartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItems.size)

        }
    }
}