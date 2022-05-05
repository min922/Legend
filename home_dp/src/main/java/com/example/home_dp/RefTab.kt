package com.example.home_dp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_bookmark_tab.view.*
import kotlinx.android.synthetic.main.fragment_ref_tab.*

class RefTab : Fragment() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    val MenuList = arrayListOf<Item>()
    val mAdapter = getContext()?.let { MyAdapter(it, MenuList) }
    lateinit var recyclerViewref: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val MenuList = arrayListOf<Item>(
//            Item("1", "apple", "fruit", "사과","-","-","-"),
//            Item("1", "apple", "fruit", "사과","-","-","-"),
//            Item("1", "apple", "fruit", "사과","-","-","-"),
//            Item("1", "apple", "fruit", "사과","-","-","-")
//        )

        addData()
        for (i in MenuList){Log.w("sfqrfed", "${i}아")}
        val rootView = inflater.inflate(R.layout.fragment_ref_tab, container, false)
//        updateRecyclerData(MenuList)
        recyclerViewref = rootView.findViewById(R.id.recyclerView_ref) as RecyclerView
        recyclerViewref.layoutManager = GridLayoutManager(context, 3)
        recyclerViewref.adapter = context?.let { MyAdapter(it, MenuList) }
        return rootView
    }

    fun addData(){
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
                                val year_data = document_sub.data["year"] as String
                                val month_data = document_sub.data["month"] as String
                                val day_data = document_sub.data["day"] as String
                                val itemtmp = Item(display_data, id_data, photo_data,
                                    menuname_data, year_data, month_data, day_data)
                                MenuList.add(itemtmp)
                            }
                        }
                    }
                }
//                recyclerViewref.adapter = mAdapter
                mAdapter?.notifyDataSetChanged()  // 리사이클러 뷰 갱신
                for (i in MenuList){Log.w("sfqrfed", "${i.id}")}
//                updateRecyclerData(MenuList)
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("Why", "Error getting documents: $exception")
            }
    }
//    fun updateRecyclerData(itemList: ArrayList<Item>){
//        mAdapter?.setData(itemList)
//        mAdapter?.notifyDataSetChanged()
//    }
}