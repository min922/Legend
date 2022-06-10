package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_etc.*

class EtcActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DubuButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Dubu",
                "photo" to "etc",
                "menuname" to "두부",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        SundubuButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Sundubu",
                "photo" to "etc",
                "menuname" to "순두부",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        KongbijiButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Kongbiji",
                "photo" to "etc",
                "menuname" to "콩비지",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        YubuButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Yubu",
                "photo" to "etc",
                "menuname" to "유부",
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