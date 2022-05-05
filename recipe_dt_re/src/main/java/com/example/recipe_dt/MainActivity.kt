package com.example.recipe_dt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_ricecake, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_onion, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_carrot, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_cabbage, null),
            Model(Model.RECIP_INGRE, "식재료", R.drawable.icon_bacon, null),
            Model(Model.REP_MENU, "대표메뉴사진", R.drawable.tteokbokki, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.braised_chicken, null),
            Model(Model.RECIP_INGRE, "레시피1번", 0, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.ricenoodle, null),
            Model(Model.RECIP_INGRE, "레시피2번", 0, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.portcutlet, null),
            Model(Model.RECIP_INGRE, "레시피3번", 0, null),
            Model(Model.EXPLAIN_RECIPE, "레시피상세", R.drawable.jajangmyeon, null),
            Model(Model.RECIP_INGRE, "레시피4번", 0, null),


        )

        val adapter = Adapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

        }

}





