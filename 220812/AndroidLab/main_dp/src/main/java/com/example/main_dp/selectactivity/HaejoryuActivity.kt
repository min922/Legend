package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_haejoryu.*

class HaejoryuActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haejoryu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DashimaButton.setOnClickListener {
            Datafun().Dashimafun(this)
        }
        SeaweedButton.setOnClickListener {
            Datafun().Seaweedfun(this)
        }
        GimButton.setOnClickListener {
            Datafun().Gimfun(this)
        }
        ParaeButton.setOnClickListener {
            Datafun().Paraefun(this)
        }
        HaechoButton.setOnClickListener {
            Datafun().Haechofun(this)
        }
        womukButton.setOnClickListener {
            Datafun().womukfun(this)
        }

        TorefButton.setOnClickListener {
            this@HaejoryuActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}