package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fish_etc.*

class FishEtcActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_etc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        ChunguhalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Chunguhal",
                "menuname" to "청어알",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        SalmonalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Salmonal",
                "menuname" to "연어알",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        MyungranjutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Myungranjut",
                "menuname" to "명란젓",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        JunuhjutgalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Junuhjutgal",
                "menuname" to "전어젓갈",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        NalchialButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Nalchial",
                "menuname" to "날치알",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        HaepariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Haepari",
                "menuname" to "해파리",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        MidudukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Miduduk",
                "menuname" to "미더덕",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        MyungranButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Myungran",
                "menuname" to "명란",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        HaesamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Haesam",
                "menuname" to "해삼",
                "display" to "1"
            )
            data_overlap = listOf("0")
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