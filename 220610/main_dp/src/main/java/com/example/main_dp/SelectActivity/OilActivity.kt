package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_oil.*

class OilActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oil)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        OliveoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Oliveoil",
                "menuname" to "올리브유",
                "display" to "1"
            )
            data_overlap = listOf("올리브오일")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChamoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Chamoil",
                "menuname" to "참기름",
                "display" to "1"
            )
            data_overlap = listOf("식용유/소금/참기름/잣가루")
            exist_indata().existdata(data, data_overlap, this)
        }
        VegeoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Vegeoil",
                "menuname" to "식물성기름",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        GochuoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Gochuoil",
                "menuname" to "고추기름",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        FryoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Fryoil",
                "menuname" to "튀김기름",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        YutoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Yutoil",
                "menuname" to "엿기름",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        SikoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Sikoil",
                "menuname" to "식용유",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        SaladoilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Saladoil",
                "menuname" to "샐러드오일",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        PodossioilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Podossioil",
                "menuname" to "포도씨유",
                "display" to "1"
            )
            data_overlap = listOf("참빛고운포도씨유")
            exist_indata().existdata(data, data_overlap, this)
        }
        DuloilButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "oil",
                "id" to "Duloil",
                "menuname" to "들기름",
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