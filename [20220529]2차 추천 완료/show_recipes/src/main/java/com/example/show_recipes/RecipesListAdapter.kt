package com.example.show_recipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore


class RecipesListAdapter (val context: Context, var recipes_list: ArrayList<menu>): RecyclerView.Adapter<RecipesListAdapter.Holder>(){

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

    fun setData(newitemList:ArrayList<menu>){
        recipes_list = newitemList
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        private val recipes_photo = itemView?.findViewById<ImageView>(R.id.menu_image)
        private val recipes_name = itemView?.findViewById<TextView>(R.id.menu_name)
        private val recipes_time = itemView?.findViewById<TextView>(R.id.menu_time)
        private val btn_selector = itemView?.findViewById<ImageButton>(R.id.btn_selector)
        private val recipes_id = itemView?.findViewById<TextView>(R.id.menu_id)
        private val recipes_id_star = recipes_id?.getText().toString()
        private val db_firestore = FirebaseFirestore.getInstance()

        fun bind(menu : menu, context: Context){

            if (recipes_photo != null) {
                Glide.with(itemView)
                    .load(menu.menu_image)
                    .override(300,300)
                    .into(recipes_photo)
            }

            /* 나머지 TextView와 String 데이터를 연결한다. */
            recipes_name?.text = menu.menu_name
            recipes_time?.text = menu.menu_time
            recipes_id?.text = menu.menu_id
        }


        //북마크 기능(별 클릭시 별 UI가 바뀌면서 파이어스토어로 RECIPE_ID가 올라감)
        init{

            btn_selector!!.setOnClickListener{
                btn_selector?.isSelected = btn_selector?.isSelected != true

                val star_menu_id = hashMapOf("RECIPE_ID" to recipes_id_star)

                db_firestore.collection("UserBookmark")
                    .add(star_menu_id)
                    .addOnSuccessListener { Toast.makeText(context, "북마크에 추가되었습니다:)", Toast.LENGTH_SHORT).show() }
                    .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show() }

            }
        }

//        itemView.setOnClickListener{} //리사이클러뷰 클릭하면 상세페이지로 이동



    }
}