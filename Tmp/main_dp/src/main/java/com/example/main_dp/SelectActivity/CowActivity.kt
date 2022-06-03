package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_cow.*

class CowActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        CowmeatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowmeat",
                "menuname" to "소고기",
                "display" to "1"
            )
            data_overlap = listOf("쇠고기", "쇠고기(힘줄없는부위)", "쇠고기(안심 또는 등심)")
            exist_indata().existdata(data, data_overlap, this)
        }
        CowcutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowcut",
                "menuname" to "다진소고기",
                "display" to "1"
            )
            data_overlap = listOf("다진쇠고기", "다짐육", "다짐육(소고기)", "채썬쇠고기")
            exist_indata().existdata(data, data_overlap, this)
        }
        CowtailButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowtail",
                "menuname" to "소꼬리",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        CowanshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowanshim",
                "menuname" to "소고기안심",
                "display" to "1"
            )
            data_overlap = listOf("안심", "쇠고기(안심 또는 등심)")
            exist_indata().existdata(data, data_overlap, this)
        }
        CowdungshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowdungshim",
                "menuname" to "소고기등심",
                "display" to "1"
            )
            data_overlap = listOf("쇠고기(안심 또는 등심)")
            exist_indata().existdata(data, data_overlap, this)
        }
        CowheadButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowhead",
                "menuname" to "양지머리",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        CowbloodButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowblood",
                "menuname" to "선지",
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