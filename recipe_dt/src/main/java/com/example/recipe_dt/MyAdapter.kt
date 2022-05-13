package com.example.recipe_dt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context, val list: ArrayList<Ingre>):
    RecyclerView.Adapter<MyAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recip_ingre, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(list[position], context)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val ingrePhoto = itemView?.findViewById<ImageView>(R.id.ingreImg)

        fun bind(ingre: Ingre, context: Context){
            if (ingre.photo != "") {
                val resourceId = context.resources.getIdentifier(ingre.photo, "drawable", context.packageName)
                ingrePhoto?.setImageResource(resourceId)
//                val resourceId2 = context.resources.getIdentifier(food.bookmark, "drawable", context.packageName)
//                starButton?.setImageResource(resourceId2)
            } else {
                ingrePhoto?.setImageResource(R.mipmap.ic_launcher)
//                starButton?.setImageResource(R.mipmap.ic_launcher)
            }
        }
    }
}