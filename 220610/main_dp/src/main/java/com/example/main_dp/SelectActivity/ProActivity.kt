package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_pro.*

class ProActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        CrapmatsalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Crapmatsal",
                "menuname" to "게맛살",
                "display" to "1"
            )
            data_overlap = listOf("맛살")
            exist_indata().existdata(data, data_overlap, this)
        }
        UmukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Umuk",
                "menuname" to "장식용어묵",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        HamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Ham",
                "menuname" to "햄",
                "display" to "1"
            )
            data_overlap = listOf("슬라이스햄", "네모난햄")
            exist_indata().existdata(data, data_overlap, this)
        }
        BaconButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Bacon",
                "menuname" to "베이컨",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        FranksausageButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Franksausage",
                "menuname" to "프랑크소세지",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        ViennasausageButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Viennasiusage",
                "menuname" to "비엔나소세지",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        GolbangcanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Golbangcan",
                "menuname" to "골뱅이통조림",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        GgongchicanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Ggongchican",
                "menuname" to "꽁치통조림",
                "display" to "1"
            )
            data_overlap = listOf("0")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChamchicanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Chamchican",
                "menuname" to "참치통조림",
                "display" to "1"
            )
            data_overlap = listOf("참치캔")
            exist_indata().existdata(data, data_overlap, this)
        }
        FruitcanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Fruitcan",
                "menuname" to "과일통조림",
                "display" to "1"
            )
            data_overlap = listOf("후루츠칵테일")
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