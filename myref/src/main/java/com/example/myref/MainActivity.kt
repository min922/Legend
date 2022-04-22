package com.example.myref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    val MenuList = arrayListOf<Item>()
//  val MenuList = arrayListOf<Item>(Item(1, "d", "meat", "menu"))
    val mAdapter = MyAdapter(this, MenuList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener {
            db.collection("UserSelect")
                .get()
                .addOnSuccessListener { result ->
                    //성공할 경우
//                    MenuList.clear()
                    for (document in result) {
//                        Log.w("아이템", "${document.data}")
                        val itemtmp = Item(document.data["display"] as Int, document.data["id"] as String, document.data["photo"] as String, document.data["menuname"] as String)
                        Log.w("아이템1", "${itemtmp}")
//                        MenuList.add(itemtmp)
                    }
//                    mAdapter.notifyDataSetChanged()  // 리사이클러 뷰 갱신
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("Why", "Error getting documents: $exception")
                }
        }

        val gm = GridLayoutManager(this, 3)
        recyclerView_ref.layoutManager = gm
        recyclerView_ref.setHasFixedSize(true)

        recyclerView_ref.adapter = mAdapter
    }
}
