package com.example.show_recipes

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipesListAdapter (val context: Context, val recipes_list: ArrayList<menu>): RecyclerView.Adapter<RecipesListAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_recipes_add_menu, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return recipes_list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(recipes_list[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val recipes_photo = itemView?.findViewById<ImageButton>(R.id.menu_image)
        val recipes_name = itemView?.findViewById<TextView>(R.id.menu_name)
        val recipes_time = itemView?.findViewById<TextView>(R.id.menu_time)

        fun bind(menu : menu, context: Context){
            if (menu.menu_image != ""){
                val resourceId = context.resources.getIdentifier(menu.menu_image, "drawable", context.packageName)
                recipes_photo?.setImageResource(resourceId)
            } else {
                recipes_photo?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            recipes_name?.text = menu.menu_name
            recipes_time?.text = menu.menu_time
            }
        }
    }
}