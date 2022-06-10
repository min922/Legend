package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_chick_activiy.*

class ChickActiviy : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chick_activiy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        ChickmeatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickmeat",
                "menuname" to "닭고기",
                "display" to "1"
            )
            data_overlap = listOf("닭", "닭살", "닭가슴살")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChicklegButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickleg",
                "menuname" to "닭다리",
                "display" to "1"
            )
            data_overlap = listOf("닭", "닭살")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChickanshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickanshim",
                "menuname" to "닭안심",
                "display" to "1"
            )
            data_overlap = listOf("안심", "닭살")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChickbongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickbong",
                "menuname" to "닭봉",
                "display" to "1"
            )
            data_overlap = listOf("닭")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChickfeetButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickfeet",
                "menuname" to "닭발",
                "display" to "1"
            )
            data_overlap = listOf("닭")
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