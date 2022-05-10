package com.example.recipe_dt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(
//            Model(Model.REP_MENU, "대표메뉴사진", R.id.menuImage, null),
            Model(Model.REP_MENU, "대표메뉴사진", R.drawable.tteokbokki, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_ricecake, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_onion, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_carrot, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_cabbage, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_bacon, null),
//            Model(Model.REP_MENU, "설명", R.id.menuName, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_ricecake, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_onion, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_carrot, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_cabbage, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_bacon, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_ricecake, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_bacon, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_ricecake, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_onion, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_carrot, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_cabbage, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_bacon, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_ricecake, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_bacon, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.ricenoodle, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.portcutlet, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.jajangmyeon, null),

            )

        val adapter = MyAdapter(list)
        recyclerView_menu.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView_menu.adapter = adapter

        val gm = GridLayoutManager(this, 3)
        recyclerView_menu.layoutManager = gm
        recyclerView_menu.setHasFixedSize(false)
        recyclerView_menu.adapter = adapter


//        val iadapter = MyAdapter(list)
//        recyclerView_ingre.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView_ingre.adapter = iadapter
//
//        val gm2 = GridLayoutManager(this, 3)
//        recyclerView_ingre.layoutManager = gm2
//        recyclerView_ingre.setHasFixedSize(true)
//        recyclerView_ingre.adapter = adapter

//        val eadapter = MyAdapter(list)
//        recyclerView_explain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView_explain.adapter = eadapter

//        val gm3 = GridLayoutManager(this, 1)
//        recyclerView_explain.layoutManager = gm3
//        recyclerView_explain.setHasFixedSize(true)
//        recyclerView_explain.adapter = adapter


    }

}

