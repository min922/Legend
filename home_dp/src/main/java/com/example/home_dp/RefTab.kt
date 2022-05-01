package com.example.home_dp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_bookmark_tab.view.*

class RefTab : Fragment() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    val MenuList = arrayListOf<Item>()
    val mAdapter = getContext()?.let { MyAdapter(it, MenuList) }
    lateinit var recyclerViewref: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val MenuList = arrayListOf<Item>(
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과"),
            Item("1", "apple", "fruit", "사과")
        )

        var rootView = inflater.inflate(R.layout.fragment_ref_tab, container, false)
//        addData()
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
                    if (document.data["display"] as String == "1"){
                        val itemtmp = Item(
                            document.data["display"] as String,
                            document.data["id"] as String,
                            document.data["photo"] as String,
                            document.data["menuname"] as String)
                        MenuList.add(itemtmp)
                    }
                }
//                context?.let { MyAdapter(it, MenuList).notifyDataSetChanged() }
//                mAdapter?.notifyDataSetChanged()  // 리사이클러 뷰 갱신
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("Why", "Error getting documents: $exception")
            }
    }
}