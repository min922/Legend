package com.example.recipe_dt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val list = arrayListOf<Ingre>(
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),
        Ingre("icon_bacon"),
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),
        Ingre("icon_bacon"),
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intent 이용해서 레시피 상세페이지로 이동
        val intent = Intent(this, RecipeActivity::class.java)

        //버튼 지정
        val buttonView = findViewById<Button>(R.id.viewmove)
        //클릭리스너
        buttonView.setOnClickListener {
            //액티비티 이동
            startActivity(intent)
        }

        val mAdapter = MyAdapter(this, list)
        recyclerView_ingre.adapter = mAdapter

        val gm = GridLayoutManager(this, 3)
        recyclerView_ingre.layoutManager = gm
        recyclerView_ingre.setHasFixedSize(true)


    }


}