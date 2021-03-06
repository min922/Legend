package com.example.bookmark

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

class BookmarkAdapter(val context: Context, var foodList: ArrayList<BookmarkFood>):
    RecyclerView.Adapter<BookmarkAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_main_bookmark, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(foodList[position], context)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun setData(newitemList:ArrayList<BookmarkFood>){
        foodList = newitemList
    }

    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val foodPhoto = itemView?.findViewById<ImageView>(R.id.foodPhotoImg)
        val foodName = itemView?.findViewById<TextView>(R.id.foodName)
        val foodTime = itemView?.findViewById<TextView>(R.id.foodTime)
        val defaultImage = R.drawable.icon_carrot
        val errorImage = R.drawable.icon_bacon
        val fallimage = R.drawable.icon_cabbage
        val starButton = itemView?.findViewById<ImageButton>(R.id.starbutton)
        val db_firestore = FirebaseFirestore.getInstance()
        val foodId = itemView?.findViewById<TextView>(R.id.foodId)





        fun bind(food: BookmarkFood, context: Context){
//            if (food.photo != null) {
//                if (foodPhoto != null) {
//                    Glide.with(itemView)
//                        .load(food.photo)
//                        .placeholder(defaultImage)  //이미지 로딩 시작하기 전 표시할 이미지
//                        .error(errorImage)     // 로딩 에러 발생 시 보여줄 이미지
//                        .fallback(fallimage)   //로드할 url(이미지)이 비어있으면 나오는 이미지
//                        .into(foodPhoto)
//                }
//            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            foodName?.text = food.name
            foodTime?.text = food.time
            foodId?.text = food.id

            try {
                Glide.with(itemView).load(food.photo).into(foodPhoto!!)
            } catch (e: NullPointerException) {
                foodPhoto?.setImageResource(R.mipmap.ic_launcher)
            }

        }

//        스타버튼
        init{
            //북마크 기능(별 클릭시 별 UI가 바뀌면서 파이어스토어로 RECIPE_ID가 올라감)
            starButton!!.setOnClickListener{
            starButton?.isSelected = starButton?.isSelected != true //북마크 별 클릭시 모양 변환

                if (starButton?.isSelected == false){
                    //북마크 클릭 시 파이어스토어 "UserBookmark" 컬렉션에 레시피 id 올라감
                    val recipes_id_star = foodId?.text.toString()//파이어스토어에 올릴 값
                    val star_menu_id = hashMapOf("RECIPE_ID" to recipes_id_star) //파이어스토어에 올리기

                    db_firestore.collection("UserBookmark")
                        .add(star_menu_id)
                        .addOnSuccessListener { Toast.makeText(context, "북마크에 추가되었습니다:)", Toast.LENGTH_SHORT).show() }
                        .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show() }
                }
                else{//북마크 해제 시 파이어스토어 "UserBookmark" 컬렉션에 레시피 id 삭제함
                    val recipes_id_star = foodId?.text.toString()
                    db_firestore.collection("UserBookmark")
                        .get()
                        .addOnSuccessListener { bookmark_id ->
                            for (document_id in bookmark_id){
                                if(document_id.data["RECIPE_ID"] == recipes_id_star){
                                    var edit_bookmark = document_id.id //파이어스토어 문서 ID명
                                    db_firestore.collection("UserBookmark").document(edit_bookmark).delete()
                                }
                            }
                            Toast.makeText(context, "북마크에서 해제되었습니다:)", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show()}
                }

            }
        }
    }
}