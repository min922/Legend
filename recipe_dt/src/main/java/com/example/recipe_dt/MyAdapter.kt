package com.example.recipe_dt

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

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
        val ingreName = itemView?.findViewById<TextView>(R.id.ingreName)
        val ingreId = itemView?.findViewById<TextView>(R.id.ingreId)
        val starButton = itemView?.findViewById<ImageButton>(R.id.starbutton)
        val db_firestore = FirebaseFirestore.getInstance()
        val foodId = itemView?.findViewById<TextView>(R.id.foodId)

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


            /////////////////////////////// 재료 유무에 따른 UI 구분하기 ///////////////////////////////
            var user_ing_list = arrayListOf<String>()
            val ing_list = arrayListOf<String>()     ///IngPhoto 에서 받은 ing 이름들 리스트



            ///////////////////////// SQLite 데이터 받기
            val db_sqlite = DataBaseHelper(context = context).readableDatabase //sql 인스턴스 선언

            // RECIPE_ID예시로 선택한다음 레시피에 들어가는 재료 받기
            val choiceingre =
                "select RECIPE_ID, IRDNT_NM from recipe_ingredient where RECIPE_ID in ('97');"

            //////////////////////////////////////// 재료받기 ////////////////////////////////////////////////////////
            val carrot = R.drawable.icon_carrot
            val cursor = db_sqlite.rawQuery(choiceingre, null)

            /// UserSelect

            db_firestore.collection("UserSelect")
                .get()
                .addOnSuccessListener { result_UserSelect ->
                    Log.d("들어왔니.....?", "Pass")
                    //들어왔니 찍힘
                    for (document_user in result_UserSelect) {

                        var user_ing_name = document_user.data["menuname"].toString()
                        user_ing_list.add(user_ing_name)


                    }

                    println("for")
                    println(user_ing_list)

                    cursor.run {
                        while (moveToNext()) {
                            val RECIPE_ID = cursor.getString(0)
                            val IRDNT_NM = cursor.getString(1)

                            Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                            Log.w("레시피_IRDNT_NM : ", IRDNT_NM)

                            println(user_ing_list)

                        }
                    }

                    if (ingrePhoto != null) {
                        println("name")
                        println(ingre.name)
                        println(user_ing_list)
                        if (ingre.name in user_ing_list) {



                            println("아아아아아아아 나오니")
                        }
                        else {
                            ingrePhoto.setBackgroundColor(Color.parseColor("#959595"))
                            println("안나오니")


                        }
                    }
                }

            }
        }
    }

