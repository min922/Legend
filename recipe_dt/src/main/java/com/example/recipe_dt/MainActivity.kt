package com.example.recipe_dt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val RecipeIngreList = arrayListOf<RecipeIngre>(
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파"),
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파"),
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파"),
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파"),
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파"),
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파"),
        RecipeIngre ("icon_ricecake", "가래떡"),
        RecipeIngre ("icon_onion", "양파")


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aAdapter = Adapter(this, RecipeIngreList)
        recyclerView.adapter = aAdapter

        val gm = GridLayoutManager(this, 3)
        recyclerView.layoutManager = gm
        recyclerView.setHasFixedSize(true)

    }
}



