package com.example.recipe_dt

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.map_dp.MapsActivity
import com.google.firebase.firestore.FirebaseFirestore

class MyAdapter(val context: Context, val list: ArrayList<Ingre>):
    RecyclerView.Adapter<MyAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recip_ingre, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(list[position], context)

        holder.itemView.setOnClickListener {
            val itemname_list = listOf("조기", "오징어", "명태", "애호박",  "배",
                "닭고기", "동태", "고등어", "무",  "상추",  "배추", "쇠고기", "오이", "사과",
                "돼지고기", "달걀", "양파", "호박")
            val itemname = holder.itemView.findViewById<TextView>(R.id.ingreName).text.toString()
            if (itemname in itemname_list){
                val intent = Intent(holder.itemView.context, MapsActivity::class.java)
                intent.putExtra("ItemName", itemname)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            }
            else{
                Toast.makeText(context, "가격 정보 데이터를 업데이트 중입니다.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val ingrePhoto = itemView?.findViewById<ImageView>(R.id.ingreImg)
        val ingreName = itemView?.findViewById<TextView>(R.id.ingreName)
        val ingreId = itemView?.findViewById<TextView>(R.id.ingreId)

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
            /* 나머지 TextView와 String 데이터를 연결한다. */
            ingreName?.text = ingre.name
        }

        val starButton = itemView?.findViewById<ImageButton>(R.id.starbutton)
        val db_firestore = FirebaseFirestore.getInstance()
        val foodId = itemView?.findViewById<TextView>(R.id.foodId)


    }
}