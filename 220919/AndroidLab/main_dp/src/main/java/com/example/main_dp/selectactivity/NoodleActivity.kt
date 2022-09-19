package com.example.main_dp.selectactivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.selectfcts.Datafun
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_noodle.*

class NoodleActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noodle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DangButton.setOnClickListener {
            Datafun().Dangfun(this)
        }
        NaengButton.setOnClickListener {
            Datafun().Naengfun(this)
        }
        KalButton.setOnClickListener {
            Datafun().Kalfun(this)
        }
        JjolButton.setOnClickListener {
            Datafun().Jjolfun(this)
        }
        SsalguksuButton.setOnClickListener {
            Datafun().Ssalguksufun(this)
        }
        UdongButton.setOnClickListener {
            Datafun().Udongfun(this)
        }
        SpaButton.setOnClickListener {
            Datafun().Spafun(this)
        }
        RamenButton.setOnClickListener {
            Datafun().Ramenfun(this)
        }
        GuksuButton.setOnClickListener {
            Datafun().Guksufun(this)
        }

        TorefButton.setOnClickListener {
            this@NoodleActivity.finishAffinity() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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