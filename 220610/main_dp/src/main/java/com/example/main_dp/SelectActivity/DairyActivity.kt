package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_dairy.*

class DairyActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dairy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        EggButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Egg",
                "menuname" to "계란",
                "display" to "1"
            )
            data_overlap = listOf("계란흰자", "계란노른자", "달걀노른자", "달걀", "삶은계란", "계란후라이", "달걀")
            exist_indata().existdata(data, data_overlap, this)
        }
        CheeseButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Cheese",
                "menuname" to "치즈",
                "display" to "1"
            )
            data_overlap = listOf("슬라이스치즈", "파마산치즈치즈", "모짜렐라치즈", "치즈", "에멘탈 치즈가루", "피자치즈", "파마산치즈", "치즈가루", "크림치즈", "아가용치즈", "아가용 치즈", "슈레드 치즈(모짜렐라치즈)", "파마르산치즈")
            exist_indata().existdata(data, data_overlap, this)
        }
        YogartButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Yogart",
                "menuname" to "요거트",
                "display" to "1"
            )
            data_overlap = listOf("플레인요구르트")
            exist_indata().existdata(data, data_overlap, this)
        }
        MilkButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Milk",
                "menuname" to "우유",
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