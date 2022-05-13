package com.example.recipe_dt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.recipe_main.*

class RecipeActivity : AppCompatActivity() {
    val explainlist = arrayListOf<Recipe>(
        Recipe("braised", "ㅇ아아아아아아 첫번째"),
        Recipe("tteokbokki", "ㅇ아아아아아아 두번째"),
        Recipe("jajangmyeon", "ㅇ아아아아아아 세번째"),
        Recipe("null", "ㅇ아아아아아아 네번째"),

        )




    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_main)

        val backBtn = findViewById<Button>(R.id.moveBack)
        //버튼 클릭시 상세페이지에서 다시 원래 화면으로 돌아감
        backBtn.setOnClickListener {
            finish()
        }


        val rAdapter = RecipeAdapter(this, explainlist)
        recyclerView_explain.adapter = rAdapter

        val gm = GridLayoutManager(this, 1)
        recyclerView_explain.layoutManager = gm
        recyclerView_explain.setHasFixedSize(true)

    }
}