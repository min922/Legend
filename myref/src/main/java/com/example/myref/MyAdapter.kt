package com.example.myref

import android.content.Context
import android.graphics.Color
import android.graphics.Color.rgb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myref.databinding.ItemMainBinding


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
    interface OnItemClickListener{
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : OnItemClickListener

            override fun getItemCount(): Int {
                return itemList.size
            }
            fun setData(newitemList:ArrayList<Item>){
                itemList = newitemList
            }

            inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
                val menuPhoto = itemView?.findViewById<ImageButton>(R.id.menuPhotoImg)
                val menuName = itemView?.findViewById<TextView>(R.id.menuText)
                val itemDate = itemView?.findViewById<TextView>(R.id.dateText)

                fun bind(item:Item, context: Context){
                    if (item.photo != "") {
                        val resourceId = context.resources.getIdentifier(item.photo, "drawable", context.packageName)
                        menuPhoto?.setImageResource(resourceId)
                    } else {
                        menuPhoto?.setImageResource(R.mipmap.ic_launcher)
                    }
                    /* 나머지 TextView와 String 데이터를 연결한다. */
                    menuName?.text = item.menuname
//                    itemDate?.text = item.year
                    itemDate?.text = "${item.year}년 ${item.month}월 ${item.day}일 까지"
//                    if (item.id == "Apple") {
//                        menuPhoto?.setBackgroundColor(Color.rgb(178, 204, 255))
//                    }
                }
            }
}