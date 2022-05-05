package com.example.myref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    val MenuList = arrayListOf<Item>()
    val mAdapter = MyAdapter(this, MenuList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addData()

        val gm = GridLayoutManager(this, 3)
        recyclerView_ref.layoutManager = gm
        recyclerView_ref.setHasFixedSize(true)
        recyclerView_ref.adapter = mAdapter
    }

    private fun addData(){
        db.collection("UserSelect")
            .get()
            .addOnSuccessListener { result ->
                //성공할 경우
                MenuList.clear()
                for (document in result) {
                        if ("display" in document && document.data["display"] as String == "1"){
                            val display_data = document.data["display"] as String
                            val id_data = document.data["id"] as String
                            val photo_data = document.data["photo"] as String
                            val menuname_data = document.data["menuname"] as String
                            for (document_sub in result){
                                if("year" in document_sub && "month" in document_sub
                                    && "day" in document_sub && document_sub.data["id"] == document.data["id"]){
                                    var year_data = document_sub.data["year"] as String
                                    val month_data = document_sub.data["month"] as String
                                    val day_data = document_sub.data["day"] as String
                                    val itemtmp = Item(display_data, id_data, photo_data,
                                        menuname_data, year_data, month_data, day_data)
                                    MenuList.add(itemtmp)
                                }
                            }
                        }
                    }
//                mAdapter.notifyDataSetChanged()  // 리사이클러 뷰 갱신
                updateRecyclerData()
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("Why", "Error getting documents: $exception")
            }
    }
    fun updateRecyclerData(){
        mAdapter?.setData(MenuList)
        mAdapter?.notifyDataSetChanged()
    }
}
