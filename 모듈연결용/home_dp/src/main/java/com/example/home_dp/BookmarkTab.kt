package com.example.home_dp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_bookmark_tab.*
import kotlinx.android.synthetic.main.fragment_bookmark_tab.view.*

class BookmarkTab : Fragment() {
    val FoodList = arrayListOf<BookmarkFood>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val aBookmarkAdapter = context?.let { BookmarkAdapter(it, FoodList) }

        var rootView = inflater.inflate(R.layout.fragment_bookmark_tab, container, false)

        rootView.recyclerViewBookmark.adapter = aBookmarkAdapter

        val gm = GridLayoutManager(context, 1)
        rootView.recyclerViewBookmark.layoutManager = gm
        rootView.recyclerViewBookmark.setHasFixedSize(true)


//        파이어스토어 북마크 id, img_url 받기
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언
        val db_sqlite = context?.let { BookmarkDataBaseHelper(it).readableDatabase }
        var receiveId: String


        db_firestore.collection("UserBookmark")
            .get()
            .addOnSuccessListener { result ->
                FoodList.clear()
                for (id in result) {
                    if (id.data["RECIPE_ID"].toString() != ""){
                        receiveId = id.data["RECIPE_ID"].toString()
                        println("id : ${receiveId}")

                        // 아래 WHERE ~ = $receiveId 하면 위에 두개 출력
                        val sql = "SELECT info.RECIPE_ID, info.IMG_URL, info.RECIPE_NM_KO, info.COOKING_TIME\n" +
                                "FROM recipe_information info\n" +
                                "WHERE info.RECIPE_ID in (" + receiveId + ")"


                        val bookmarkImg = rootView.findViewById<ImageView>(R.id.foodPhotoImg)
                        val foodName = rootView.findViewById<TextView>(R.id.foodName)
                        val foodTime = rootView.findViewById<TextView>(R.id.foodTime)

                        val cursor = db_sqlite!!.rawQuery(sql, null)
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

                                val available_bookmark = BookmarkFood(RECIPE_ID, IMG_URL, RECIPE_NM_KO, COOKING_TIME)
                                FoodList.add(available_bookmark)

                                update_Adapter()
                            }

                        }
                    }

                }

            }

        return rootView
    }

    private fun update_Adapter() {
        val aBookmarkAdapter = context?.let { BookmarkAdapter(it, FoodList) }
        recyclerViewBookmark.adapter = aBookmarkAdapter
        aBookmarkAdapter?.setData(FoodList)
        aBookmarkAdapter?.setContact_bookmark(FoodList)
    }
}