package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fruit.*
import kotlinx.android.synthetic.main.activity_fruit.TorefButton
import kotlinx.android.synthetic.main.activity_main_select.*

class FruitActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        AppleButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Apple",
                "menuname" to "사과",
                "display" to "1"
            )
            data_overlap = listOf("사과즙")
            exist_indata().existdata(data, data_overlap, this)
        }
        GrapefruitButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Grapefruit",
                "menuname" to "자몽",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        StrawberryButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Strawberry",
                "menuname" to "딸기",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        DriedgrapeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Driedgrapefruit",
                "menuname" to "건포도",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        LemonButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Lemon",
                "menuname" to "레몬",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        GrapeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Grape",
                "menuname" to "포도",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        CherryButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Cherry",
                "menuname" to "체리",
                "display" to "1"
            )
            data_overlap = listOf("체리알")
            exist_indata().existdata(data, data_overlap, this)
        }
        AvocadoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Avocado",
                "menuname" to "아보카도",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        BananaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Banana",
                "menuname" to "바나나",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        OrangeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Orange",
                "menuname" to "오렌지",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        LimeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Lime",
                "menuname" to "라임",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        BlueberryButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fruit",
                "id" to "Blueberry",
                "menuname" to "건블루베리",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        TorefButton.setOnClickListener {
            finish() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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