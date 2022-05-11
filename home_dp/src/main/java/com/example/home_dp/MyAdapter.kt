package com.example.home_dp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.rgb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessController.getContext


class MyAdapter(val context: Context, var itemList: ArrayList<Item>):
        RecyclerView.Adapter<MyAdapter.Holder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
                val view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
                return Holder(view)
            }

            override fun onBindViewHolder(holder: Holder, position: Int) {
                holder.bind(itemList[position], context)
                holder.itemView.setOnClickListener {
                    itemClickListener.onClick(it, position)
                }
            }
    interface onItemClickListener{
        fun onClick(itemView: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: onItemClickListener){
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener: onItemClickListener

            override fun getItemCount(): Int {
                return itemList.size
            }
            fun setData(newitemList:ArrayList<Item>){
                itemList = newitemList
            }

            fun setContact(contacts: ArrayList<Item>) {
                val diffResult = DiffUtil.calculateDiff(ContactDiffUtil(this.itemList, itemList), false)
                diffResult.dispatchUpdatesTo(this)
                this.itemList = itemList
            }


            class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
                val menuPhoto = itemView.findViewById<ImageView>(R.id.menuPhotoImg)
                val menuName = itemView.findViewById<TextView>(R.id.menuText)
                val itemDate = itemView.findViewById<TextView>(R.id.dateText)

                fun bind(item:Item, context: Context){
//                    itemView.setOnClickListener {
//                        RefTab().editDate(itemList[position].id, context)
//                    }

                    if (item.photo != "") {
                        val resourceId = context.resources.getIdentifier(item.photo, "drawable", context.packageName)
                        menuPhoto?.setImageResource(resourceId)
                    } else {
                        menuPhoto?.setImageResource(R.mipmap.ic_launcher)
                    }
                    /* 나머지 TextView와 String 데이터를 연결한다. */
                    menuName?.text = item.menuname
                    itemDate?.text = "${item.year}년 ${item.month}월 ${item.day}일 까지"
//                    if (item.id == "Apple") {
//                        menuPhoto?.setBackgroundColor(Color.rgb(178, 204, 255))
//                    }
                }
            }
}