package com.example.home_dp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookmarkTab : Fragment() {
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
    lateinit var recyclerViewbm: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_bookmark_tab, container, false)
        recyclerViewbm = rootView.findViewById(R.id.recyclerView) as RecyclerView
        recyclerViewbm.layoutManager = GridLayoutManager(getContext(), 1)
        recyclerViewbm.adapter = getContext()?.let { Adapter(it, FoodList) }
        return rootView
    }
}