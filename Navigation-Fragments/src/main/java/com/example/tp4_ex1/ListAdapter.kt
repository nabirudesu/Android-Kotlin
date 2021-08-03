package com.example.tp4_ex1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3.R

class ListAdapter (val context:Context,var data:List<Element>):
        RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.elements_list, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.details.text = data[position].details
        holder.num.text = data[position].num.toString()
        holder.imageView.setImageResource(data[position].image)
        holder.add.setOnClickListener { view ->
            if (data[position].num == 0) {
                data[position].num += 1
                notifyDataSetChanged()
            } else if (data[position].num == 1) {
                data[position].image = R.drawable.pack
                data[position].num += 1
                notifyDataSetChanged()
            } else {
                data[position].num += 1
                notifyDataSetChanged()
            }

        }
        holder.min.setOnClickListener { view ->
            if (data[position].num > 2) {
                data[position].num -= 1
                notifyDataSetChanged()
            } else if (data[position].num == 2) {
                data[position].image = R.drawable.phone
                data[position].num -= 1
                notifyDataSetChanged()
            } else {
                notifyDataSetChanged()
            }

        }
        holder.itemView.setOnClickListener { view ->
            val element = data[position]
            var Bundle = bundleOf("element" to element)
            view.findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, Bundle)

        }

    }
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val details=view.findViewById<TextView>(R.id.details) as TextView
    val num=view.findViewById<TextView>(R.id.num) as TextView
    val imageView=view.findViewById<ImageView>(R.id.imageView) as ImageView
    val add=view.findViewById<ImageView>(R.id.add) as ImageView
    val min=view.findViewById<ImageView>(R.id.min) as ImageView
}


