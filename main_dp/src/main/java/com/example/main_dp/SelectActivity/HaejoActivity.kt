package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_haejo.*
import kotlinx.android.synthetic.main.activity_pro.*

class HaejoActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haejo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DashimaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Dashima",
                "menuname" to "다시마",
                "display" to "1"
            )
            data_overlap = listOf("다시물", "다시마국물", "쌈다시마", "다시마 우린 물", "국물용 다시마")
            exist_indata().existdata(data, data_overlap, this)
        }
        SeaweedButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Seaweed",
                "menuname" to "미역",
                "display" to "1"
            )
            data_overlap = listOf("불린미역")
            exist_indata().existdata(data, data_overlap, this)
        }
        GimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gim",
                "menuname" to "김",
                "display" to "1"
            )
            data_overlap = listOf("김밥용김", "구운김")
            exist_indata().existdata(data, data_overlap, this)
        }
        ParaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Parae",
                "menuname" to "파래",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        HaechoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Haecho",
                "menuname" to "해초",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        UmukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Umuk",
                "menuname" to "우묵",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId){
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