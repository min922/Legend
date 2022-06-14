package com.example.main_dp.SelectActivity


import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.main_dp.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_bread.*
import kotlinx.android.synthetic.main.activity_bread.TorefButton
import kotlinx.android.synthetic.main.activity_main_select.*

class BreadActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bread)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        GareButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Gare",
                "menuname" to "가래떡",
                "display" to "1"
            )
            data_overlap = listOf("흰떡")
            exist_indata().existdata(data, data_overlap, this)
        }

        DduckgukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Dduckguk",
                "menuname" to "떡국떡",
                "display" to "1"
            )
            data_overlap = listOf("흰떡")
            exist_indata().existdata(data, data_overlap, this)
        }

        DduckbokkiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Dduckbokki",
                "menuname" to "떡볶이떡",
                "display" to "1"
            )
            data_overlap = listOf("흰떡")
            exist_indata().existdata(data, data_overlap, this)
        }

        BaguetteButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Baguette",
                "menuname" to "바게트",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        BaegleButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Baegle",
                "menuname" to "베이글",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        ShickbbangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Shickbbang",
                "menuname" to "식빵",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        TorefButton.setOnClickListener {
            finish() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //뒤로가기 액션
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