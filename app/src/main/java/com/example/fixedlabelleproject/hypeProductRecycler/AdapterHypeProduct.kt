package com.example.fixedlabelleproject.hypeProductRecycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fixedlabelleproject.DetailActivity
import com.example.fixedlabelleproject.Model
import com.example.fixedlabelleproject.R

class AdapterHypeProduct (private val newlist : ArrayList<Model>)
    : RecyclerView.Adapter<AdapterHypeProduct.hypeviewholder>(){

    class hypeviewholder(view : View) : RecyclerView.ViewHolder(view){
        val imgrc : ImageView = view.findViewById(R.id.gambar_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hypeviewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return hypeviewholder(view)
    }
    override fun onBindViewHolder(
        holder: hypeviewholder,
        position: Int
    ) {
        val data = newlist[position]
        Glide.with(holder.imgrc.context).load(data.Imgrc).into(holder.imgrc )

        holder.imgrc.setOnClickListener{
            val intent = Intent(holder.imgrc.context , DetailActivity::class.java)
            intent.putExtra("logo", data.Logo)
            intent.putExtra("brand", data.Brand)
            intent.putExtra("product_name", data.Product_name)
            intent.putExtra("info", data.Info)
            intent.putExtra("how_to_use", data.How_to_use)
            intent.putExtra("ingredients", data.Ingredients)
            holder.imgrc.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return newlist.size
    }
}