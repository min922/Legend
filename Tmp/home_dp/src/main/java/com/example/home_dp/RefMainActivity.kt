package com.example.home_dp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.home_dp.R.layout.activity_main
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import kotlinx.android.synthetic.main.activity_main.*
import com.example.home_dp.R.id.tabContent as refTabcontent
import kotlinx.android.synthetic.main.activity_main.tabs


class RefMainActivity : AppCompatActivity() {
    private lateinit var refTab: RefTab
    private lateinit var bookmarkTab: BookmarkTab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        refTab = RefTab()
        bookmarkTab = BookmarkTab()

        supportFragmentManager.beginTransaction().add(refTabcontent, refTab).commit()
        //시작할때 내 냉장고탭을 기본으로 보여줌

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(refTabcontent, refTab)
                    }
                    "북마크"->transaction.replace(refTabcontent, bookmarkTab)
                }
                transaction.commit()
            }

            override fun onTabReselected(tab: Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(refTabcontent, refTab)
                    }
                    "북마크"->transaction.replace(refTabcontent, bookmarkTab)
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(refTabcontent, refTab)
                    }
                    "북마크"->transaction.replace(refTabcontent, bookmarkTab)
                }
                transaction.commit()
            }
        })

        plus.setOnClickListener {
//            val intent = Intent(this, TestActivity::class.java)
//            intent.putExtra("key1", "intent")
//            startActivity(intent)
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }
    fun refresh_frag(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.tabContent, fragment)
//        transaction.commit()
        transaction.detach(fragment)
            .attach(fragment)
            .commit()
    }
}