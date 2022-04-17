package com.example.show_recipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*아직 안 해쏘 성미야*/
    val recipes_List = arrayListOf<menu>(
        menu("", "",""),
        menu("", "",""),
        menu("", "","")
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