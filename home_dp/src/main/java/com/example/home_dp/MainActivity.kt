package com.example.home_dp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.tabContent, RefTab()).commit()

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"->transaction.replace(R.id.tabContent, RefTab())
                    "북마크"->transaction.replace(R.id.tabContent, BookmarkTab())
                }
                transaction.commit()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.w("Resel", "Reselected")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.w("Unsel", "Unselected")
            }
        })
    }
}