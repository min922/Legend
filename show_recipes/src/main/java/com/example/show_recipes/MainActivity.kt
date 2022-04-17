package com.example.show_recipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val recipes_List = arrayListOf<menu>(
        menu("bibimbap", "비빔밥","1시간"),
        menu("bulgogi", "불고기","1시간"),
        menu("gopchang", "곱창","30분"),
        menu("japchae", "잡채","1시간 반")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipes_list_Adatper = RecipesListAdapter(this,recipes_List )
        recyclerView_recipes_list.adapter = recipes_list_Adatper

        val recipes_linear_manager = LinearLayoutManager(this)
        recyclerView_recipes_list.layoutManager = recipes_linear_manager
        recyclerView_recipes_list.setHasFixedSize(true)
    }
}