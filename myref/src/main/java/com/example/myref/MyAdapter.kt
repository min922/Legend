package com.example.myref

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myref.databinding.ItemMainBinding

class MyAdapter(val context: Context, val itemList: ArrayList<Item>):
        RecyclerView.Adapter<MyAdapter.Holder>(){

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
                val view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
                return Holder(view)
            }

            override fun onBindViewHolder(holder: Holder, position: Int) {
                holder?.bind(itemList[position], context)
            }

            override fun getItemCount(): Int {
                return itemList.size
            }

            inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
                val menuPhoto = itemView?.findViewById<ImageButton>(R.id.menuPhotoImg)
                val menuName = itemView?.findViewById<TextView>(R.id.menuText)

                fun bind(item:Item, context: Context){
                    if (item.photo != "") {
                        val resourceId = context.resources.getIdentifier(item.photo, "drawable", context.packageName)
                        menuPhoto?.setImageResource(resourceId)
                    } else {
                        menuPhoto?.setImageResource(R.mipmap.ic_launcher)
                    }
                    /* 나머지 TextView와 String 데이터를 연결한다. */
                    menuName?.text = item.menuname
                }
            }
}