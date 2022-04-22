package com.example.bookmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val FoodList = arrayListOf<Food>(
        Food("tteokbokki", "떡볶이", "30min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min"),
        Food("braised", "찜닭", "60min")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aAdapter = Adapter(this, FoodList)
        recyclerView.adapter = aAdapter

        val gm = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gm
        recyclerView.setHasFixedSize(true)

    }
}
