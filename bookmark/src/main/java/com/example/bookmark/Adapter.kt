package com.example.bookmark

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, val foodList: ArrayList<Food>):
    RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_main, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(foodList[position], context)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val foodPhoto = itemView?.findViewById<ImageView>(R.id.foodPhotoImg)
        val foodName = itemView?.findViewById<TextView>(R.id.foodName)
        val foodTime = itemView?.findViewById<TextView>(R.id.foodTime)
//        val starButton = itemView?.findViewById<ImageButton>(R.id.starbutton)

        fun bind(food: Food, context: Context){
            if (food.photo != "") {
                val resourceId = context.resources.getIdentifier(food.photo, "drawable", context.packageName)
                foodPhoto?.setImageResource(resourceId)
//                val resourceId2 = context.resources.getIdentifier(food.bookmark, "drawable", context.packageName)
//                starButton?.setImageResource(resourceId2)
            } else {
                foodPhoto?.setImageResource(R.mipmap.ic_launcher)
//                starButton?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            foodName?.text = food.name
            foodTime?.text = food.time
        }
    }
}