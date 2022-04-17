package com.example.myref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myref.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val MenuList = arrayListOf<Item>(
        Item("cabbage", "vege"),
        Item("cabbage", "vege1"),
        Item("cabbage", "vege2"),
        Item("milk", "milk"),
        Item("milk", "milk1")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = MyAdapter(this, MenuList)
        recyclerView_ref.adapter = mAdapter

        val gm = GridLayoutManager(this, 3)
        recyclerView_ref.layoutManager = gm
        recyclerView_ref.setHasFixedSize(true)
    }
}
