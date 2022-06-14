package com.example.home_dp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class RefTab : Fragment() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    val MenuList = arrayListOf<Item>()
    private lateinit var recyclerViewref: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addData()

        val mAdapter = context?.let { RefAdapter(it, MenuList) }
//        mAdapter?.setMyItemClickListener(object :MyAdapter.MyItemClickListener{
//            override fun onItemClick(position: Int) {
//                EditDate().editDate(MenuList[position].id, requireContext())
//            }
//        })

        val rootView = inflater.inflate(R.layout.fragment_ref_tab, container, false)
        recyclerViewref = rootView.findViewById(R.id.recyclerView_ref) as RecyclerView
        recyclerViewref.layoutManager = GridLayoutManager(context, 3)
        recyclerViewref.adapter = mAdapter

        return rootView
    }

    fun addData(){
        var ing_date : String
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

                                ing_date = LeftDate().Cal_Date_len1(document_sub.data["year"].toString()) +
                                        LeftDate().Cal_Date_len1(document_sub.data["month"].toString()) +
                                        LeftDate().Cal_Date_len1(document_sub.data["day"].toString())

                                if (ing_date != "nullnullnull") {
                                    ing_date = LeftDate().Cat_ing_editdate(LeftDate().Cal_Date(ing_date)) //유통기한 계산 함수, 카테고리화
                                }

                                val itemtmp = Item(display_data, id_data, photo_data,
                                    menuname_data, year_data, month_data, day_data, ing_date)
                                MenuList.add(itemtmp)
                            }
                        }
                    }
                }
                updateRecyclerData()
            }
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("Why", "Error getting documents: $exception")
            }
    }
    fun updateRecyclerData(){
        val mAdapter = context?.let { RefAdapter(it, MenuList) }
        recyclerViewref.adapter = mAdapter
        mAdapter?.setData(MenuList)
        mAdapter?.setContact_ref(mAdapter.itemList)
    }

//    fun Refresh(){
//        val mAdapter = context?.let { MyAdapter(it, MenuList) }
////        val inflater = LayoutInflater.from(activity)
//        val fm: FragmentManager = requireActivity().supportFragmentManager
//        fm.beginTransaction()
//        val rootView = getLayoutInflater().inflate(R.layout.fragment_ref_tab, recyclerView_ref)
////        val rootView = inflater.inflate(R.layout.fragment_ref_tab, recyclerView_ref, false)
//        recyclerViewref = rootView.findViewById(R.id.recyclerView_ref)
//        recyclerViewref.adapter = mAdapter
//        mAdapter?.setData(MenuList)
//        if (mAdapter != null) {
//            mAdapter.setContact(mAdapter.itemList)
//        }
//        val mAdapter = context?.let { MyAdapter(it, MenuList) }
//        mAdapter?.setData(MenuList)
//        mAdapter?.notifyDataSetChanged()
//        val mainActivityView = (activity as MainActivity)
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.tabContent, fragment)
//        transaction.commit()
//    }
}
