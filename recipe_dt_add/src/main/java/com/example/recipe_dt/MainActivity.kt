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

    val ExplainList = arrayListOf<Explain>(
        Explain ("tteokbokki", "떡을불리고 고추장 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("briased_chicken", "찜닭 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("tteokbokki", "떡을불리고 고추장 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("briased_chicken", "찜닭 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("tteokbokki", "떡을불리고 고추장 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("briased_chicken", "찜닭 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("tteokbokki", "떡을불리고 고추장 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("briased_chicken", "찜닭 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("tteokbokki", "떡을불리고 고추장 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("briased_chicken", "찜닭 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("tteokbokki", "떡을불리고 고추장 어저구저쩌구우우우우우우ㅜ우우우우우우우우"),
        Explain ("briased_chicken", "찜닭 어저구저쩌구우우우우우우ㅜ우우우우우우우우")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aAdapter = Adapter(this, RecipeIngreList, ExplainList)
        recyclerView.adapter = aAdapter

        val gm = GridLayoutManager(this, 3)
        recyclerView.layoutManager = gm
        recyclerView.setHasFixedSize(true)

    }

//    override fun onCreate(savedInstanceState: Bundle) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val aAdapter = Adapter(this, ExplainList)
//        recyclerView.adapter = aAdapter
//
//        val gm = GridLayoutManager(this, 3)
//        recyclerView.layoutManager = gm
//        recyclerView.setHasFixedSize(true)
}



