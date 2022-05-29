package com.example.bookmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val FoodList = arrayListOf<Food>(
        Food("tteokbokki", "떡볶이", "30min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        addData()
//
////        /star버튼 클릭이벤트
//        aAdapter.setItemClickListener(object :Adapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                //                getContext()?.let { EditDate().editDate(MenuList[position].id, it) }
//                Toast.makeText(
//                    this@MainActivity, "${[position].id}", Toast.LENGTH_SHORT
//                ).show()
//            }
//        })


        val aAdapter = Adapter(this, FoodList)
        recyclerView.adapter = aAdapter

        val gm = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gm
        recyclerView.setHasFixedSize(true)
        
        
//        파이어스토어 북마크 id, img_url 받기
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언
        val db_sqlite = DataBaseHelper(this).readableDatabase
        var receiveId :String

        db_firestore.collection("UserBookmark")
            .get()
            .addOnSuccessListener { result ->
                for (id in result){
                    receiveId = id.data["RECIPE_ID"].toString()
                    println("id : ${receiveId}")

                    val sql = "SELECT info.RECIPE_NM_KO, info.IMG_URL\n"+
                            "FROM recipe_information info\n"+
                            "WHERE info.RECIPE_ID ="
                }
            }


    }


}
