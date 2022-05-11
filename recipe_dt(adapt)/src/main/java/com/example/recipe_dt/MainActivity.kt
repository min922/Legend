package com.example.recipe_dt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    val list = mutableListOf<MultiData>()
//    val menulist = mutableListOf<MultiData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }
    private fun initRecycler() {

//        menulist.apply{
//            add(MultiData(photo = R.drawable.braised_chicken, name = "찜닭", "dd", 0))
//        }

        list.apply {
            add(MultiData(photo = R.drawable.icon_cabbage, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_onion, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_ricecake, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_carrot, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_bacon, name = "찜닭", "dd", 1))
//            add(MultiData(photo = R.drawable.tteokbokki, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_cabbage, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_onion, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_ricecake, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_carrot, name = "찜닭", "dd", 1))
            add(MultiData(photo = R.drawable.icon_bacon, name = "찜닭", "dd", 1))


        }

//        val madapter = MyAdapter(list)
//        recyclerView_menu.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView_menu.adapter = madapter
//
//        val gm2 = GridLayoutManager(this, 1)
//        recyclerView_menu.layoutManager = gm2
//        recyclerView_menu.setHasFixedSize(true)
//        recyclerView_menu.adapter = adapter

        val adapter = MyAdapter(list)
        recyclerView_ingre.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView_ingre.adapter = adapter

        val gm = GridLayoutManager(this, 3)
        recyclerView_ingre.layoutManager = gm
        recyclerView_ingre.setHasFixedSize(false)
        recyclerView_ingre.adapter = adapter

//        val eadapter = MyAdapter(list)
//        recyclerView_explain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView_explain.adapter = eadapter
//
//        val gm3 = GridLayoutManager(this, 1)
//        recyclerView_explain.layoutManager = gm3
//        recyclerView_explain.setHasFixedSize(true)
//        recyclerView_explain.adapter = adapter


//        val iadapter = MyAdapter(list)
//        recyclerView_ingre.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView_ingre.adapter = iadapter
//
//        val gm2 = GridLayoutManager(this, 3)
//        recyclerView_ingre.layoutManager = gm2
//        recyclerView_ingre.setHasFixedSize(true)
//        recyclerView_ingre.adapter = adapter



    }

}