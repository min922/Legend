package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_pig.*

class PigActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pig)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        PigmeatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Pigmeat",
                "menuname" to "돼지고기",
                "display" to "1"
            )
            data_overlap = listOf("돼기고기", "돼지 볼살")
            exist_indata().existdata(data, data_overlap, this)
        }
        PigbackButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Pigback",
                "menuname" to "돼지등갈비",
                "display" to "1"
            )
            data_overlap = listOf("갈비", "돼기고기")
            exist_indata().existdata(data, data_overlap, this)
        }
        PiganshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Piganshim",
                "menuname" to "돼지고기안심",
                "display" to "1"
            )
            data_overlap = listOf("안심", "돼기고기")
            exist_indata().existdata(data, data_overlap, this)
        }
        PigcutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Pigcut",
                "menuname" to "다진돼지고기",
                "display" to "1"
            )
            data_overlap = listOf("돼기고기", "다짐육", "다짐육(돼지고기)")
            exist_indata().existdata(data, data_overlap, this)
        }
        PiggalbiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Piggalbi",
                "menuname" to "돼지갈비",
                "display" to "1"
            )
            data_overlap = listOf("갈비", "돼기고기")
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