package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_clam.*

class ClamActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clam)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        HonghapButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Honghap",
                "menuname" to "홍합",
                "display" to "1"
            )
            data_overlap = listOf("검은껍질홍합")
            exist_indata().existdata(data, data_overlap, this)
        }
        MoshiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Moshi",
                "menuname" to "모시조개",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        ChamsoraButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Chamsora",
                "menuname" to "참소라살",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        GaribiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Garibi",
                "menuname" to "가리비",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        JaechupButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Jaechup",
                "menuname" to "재첩",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        GulButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gul",
                "menuname" to "굴",
                "display" to "1"
            )
            data_overlap = listOf("생굴")
            exist_indata().existdata(data, data_overlap, this)
        }
        BajirakButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Bajirak",
                "menuname" to "바지락",
                "display" to "1"
            )
            data_overlap = listOf("조개살", "조갯살")
            exist_indata().existdata(data, data_overlap, this)
        }
        GolbangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Golbang",
                "menuname" to "골뱅이",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        MatclamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Matclam",
                "menuname" to "맛조개",
                "display" to "1"
            )
            data_overlap = listOf("맛살조개")
            exist_indata().existdata(data, data_overlap, this)
        }
        ClamsalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Clamsal",
                "menuname" to "조갯살",
                "display" to "1"
            )
            data_overlap = listOf("조개살")
            exist_indata().existdata(data, data_overlap, this)
        }
        PiclamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Piclam",
                "menuname" to "피조개",
                "display" to "1"
            )
            data_overlap = listOf("조개살", "조갯살")
            exist_indata().existdata(data, data_overlap, this)
        }
        JunbokButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Junbok",
                "menuname" to "전복",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        MatsalclamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Matsalclam",
                "menuname" to "맛살조개",
                "display" to "1"
            )
            data_overlap = listOf("조개살", "조갯살")
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