package com.example.bookmark

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val FoodList = arrayListOf<Food>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val aAdapter = Adapter(this, FoodList)
        recyclerView.adapter = aAdapter

        val gm = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gm
        recyclerView.setHasFixedSize(true)


//        파이어스토어 북마크 id, img_url 받기
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언
        val db_sqlite = DataBaseHelper(this).readableDatabase
        var receiveId: String


        db_firestore.collection("UserBookmark")
            .get()
            .addOnSuccessListener { result ->
                for (id in result) {
                    if (id.data["RECIPE_ID"].toString() != ""){
                        receiveId = id.data["RECIPE_ID"].toString()
                        println("id : ${receiveId}")

                        // 아래 WHERE ~ = $receiveId 하면 위에 두개 출력
                        val sql = "SELECT info.RECIPE_ID, info.IMG_URL, info.RECIPE_NM_KO, info.COOKING_TIME\n" +
                                "FROM recipe_information info\n" +
                                "WHERE info.RECIPE_ID in (" + receiveId + ")"


                        val bookmarkImg = findViewById<ImageView>(R.id.foodPhotoImg)
                        val foodName = findViewById<TextView>(R.id.foodName)
                        val foodTime = findViewById<TextView>(R.id.foodTime)

                        val cursor = db_sqlite.rawQuery(sql, null)
                        cursor.run {
                            while (moveToNext()) {
                                val RECIPE_ID = cursor.getString(0)
                                val IMG_URL = cursor.getString(1)
                                val RECIPE_NM_KO = cursor.getString(2)
                                val COOKING_TIME = cursor.getString(3)


                                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                                Log.w("레시피_IMG_URL : ", IMG_URL)
                                Log.w("레시피_RECIPE_NM_KO : ", RECIPE_NM_KO)
                                Log.w("레시피_COOKING_TIME : ", COOKING_TIME)

                                val available_bookmark = Food(RECIPE_ID, IMG_URL, RECIPE_NM_KO, COOKING_TIME)
                                FoodList.add(available_bookmark)

                                val updatebtn : Button = findViewById(R.id.button2)

                                updatebtn.setOnClickListener{
                                    update_Adapter()
                                }

                                update_Adapter()
                                //aAdapter.notifyDataSetChanged() //리사이클러뷰 갱신
                            }
                        }
                    }
                }
            }
    }

    private fun update_Adapter() {
        val aAdapter = Adapter(this, FoodList)
        recyclerView.adapter = aAdapter
        aAdapter?.setData(FoodList)
        aAdapter.notifyDataSetChanged()
    }

}


