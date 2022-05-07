package com.example.home_dp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().add(R.id.tabContent, RefTab()).commit()
        //시작할때 내 냉장고탭을 기본으로 보여줌

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(R.id.tabContent, RefTab())
                    }
                    "북마크"->transaction.replace(R.id.tabContent, BookmarkTab())
                }
                transaction.commit()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(R.id.tabContent, RefTab())
                    }
                    "북마크"->transaction.replace(R.id.tabContent, BookmarkTab())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(R.id.tabContent, RefTab())
                    }
                    "북마크"->transaction.replace(R.id.tabContent, BookmarkTab())
                }
                transaction.commit()
            }
        })
    }
//    fun refresh_frag(fragment: Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.tabContent, fragment)
//        transaction.commit()
//        transaction.detach(fragment)
//            .attach(fragment)
//            .commit()
//    }
}