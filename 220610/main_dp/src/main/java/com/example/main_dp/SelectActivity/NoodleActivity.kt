package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_noodle.*

class NoodleActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noodle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Dang",
                "menuname" to "당면",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        NaengButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Naeng",
                "menuname" to "냉면",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        KalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Kal",
                "menuname" to "칼국수",
                "display" to "1"
            )
            data_overlap = listOf("칼국수면")
            exist_indata().existdata(data, data_overlap, this)
        }
        JjolButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Jjol",
                "menuname" to "쫄면",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        SsalguksuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Ssalguksu",
                "menuname" to "쌀국수",
                "display" to "1"
            )
            data_overlap = listOf("쌀국수면")
            exist_indata().existdata(data, data_overlap, this)
        }
        UdongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Udong",
                "menuname" to "우동",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        SpaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Spa",
                "menuname" to "스파게티",
                "display" to "1"
            )
            data_overlap = listOf("스파게티", "페투치네")
            exist_indata().existdata(data, data_overlap, this)
        }
        RamenButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Ramen",
                "menuname" to "라면",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        GuksuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Guksu",
                "menuname" to "국수",
                "display" to "1"
            )
            data_overlap = listOf("녹차국수", "밀국수", "소면")
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