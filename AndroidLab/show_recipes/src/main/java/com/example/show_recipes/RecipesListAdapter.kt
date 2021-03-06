package com.example.show_recipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe_dt.MainActivity
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

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, MainActivity::class.java)
            val id = holder.itemView.findViewById<TextView>(R.id.menu_id).text.toString()
//            val id = recipes_id?.text.toString()
            intent.putExtra("recipeId", id)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    fun setData(newitemList:ArrayList<menu>){
        recipes_list = newitemList
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        private val recipes_photo = itemView?.findViewById<ImageView>(R.id.menu_image)
        private val recipes_name = itemView?.findViewById<TextView>(R.id.menu_name)
        private val recipes_country = itemView?.findViewById<TextView>(R.id.menu_country)
        private val recipes_level = itemView?.findViewById<TextView>(R.id.menu_level)
        private val recipes_time = itemView?.findViewById<TextView>(R.id.menu_time)
        private val btn_selector = itemView?.findViewById<ImageButton>(R.id.btn_selector)
        private val recipes_id = itemView?.findViewById<TextView>(R.id.menu_id)

        private val DATE_RED = itemView?.findViewById<ImageView>(R.id.date_red)
        private val DATE_YELLOW = itemView?.findViewById<ImageView>(R.id.date_yellow)
        private val DATE_GREEN = itemView?.findViewById<ImageView>(R.id.date_green)

        private val db_firestore = FirebaseFirestore.getInstance()

        fun bind(menu : menu, context: Context){

            if (recipes_photo != null) {
                Glide.with(itemView)
                    .load(menu.menu_image)
                    .override(300,300)
                    .into(recipes_photo)
            }

            /* ????????? TextView??? String ???????????? ????????????. */
            recipes_name?.text = menu.menu_name
            recipes_country?.text = menu.menu_country
            recipes_level?.text = menu.menu_level
            recipes_time?.text = menu.menu_time
            recipes_id?.text = menu.menu_id


            if (DATE_RED != null) {
                DATE_RED.visibility = if (menu.hurry_cnt != 0){
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
            if (DATE_YELLOW != null) {
                DATE_YELLOW.visibility = if (menu.good_cnt != 0){
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }
            if (DATE_GREEN != null) {
                DATE_GREEN.visibility = if (menu.enough_cnt != 0){
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
            }

//


        }


        init{
            //????????? ??????(??? ????????? ??? UI??? ???????????? ????????????????????? RECIPE_ID??? ?????????)
            btn_selector!!.setOnClickListener{
                btn_selector?.isSelected = btn_selector?.isSelected != true //????????? ??? ????????? ?????? ??????

                if (btn_selector?.isSelected == true){
                    //????????? ?????? ??? ?????????????????? "UserBookmark" ???????????? ????????? id ?????????
                    val recipes_id_star = recipes_id?.text.toString()//????????????????????? ?????? ???
                    val star_menu_id = hashMapOf("RECIPE_ID" to recipes_id_star) //????????????????????? ?????????

                    db_firestore.collection("UserBookmark")
                        .add(star_menu_id)
                        .addOnSuccessListener { Toast.makeText(context, "???????????? ?????????????????????:)", Toast.LENGTH_SHORT).show() }
                        .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show() }
                }
                else{//????????? ?????? ??? ?????????????????? "UserBookmark" ???????????? ????????? id ?????????
                    val recipes_id_star = recipes_id?.text.toString()
                    db_firestore.collection("UserBookmark")
                        .get()
                        .addOnSuccessListener { bookmark_id ->
                            for (document_id in bookmark_id){
                                if(document_id.data["RECIPE_ID"] == recipes_id_star){
                                    var edit_bookmark = document_id.id //?????????????????? ?????? ID???
                                    db_firestore.collection("UserBookmark").document(edit_bookmark).delete()
                                }
                            }
                            Toast.makeText(context, "??????????????? ?????????????????????:)", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show()}
                }

            }

            val id = recipes_id?.text.toString()
            //?????????????????? ???????????? ?????????????????? ??????
            if (itemView != null) {
                itemView.setOnClickListener{
//                    val intent = Intent(context, MainActivity::class.java)
//                    intent.putExtra("recipeId", id)
//                    ContextCompat.startActivity(context, intent, null)
//                 //https://kumgo1d.tistory.com/44
                }
            }

        }





    }
}