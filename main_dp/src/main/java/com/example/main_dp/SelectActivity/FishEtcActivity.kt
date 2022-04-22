package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fish_etc.*

class FishEtcActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_etc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        ChunguhalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Chunguhal",
                "menuname" to "청어알",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        SalmonalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Salmonal",
                "menuname" to "연어알",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        MyungranjutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Myungranjut",
                "menuname" to "명란젓",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        JunuhjutgalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Junuhjutgal",
                "menuname" to "전어젓갈",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        NalchialButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Nalchial",
                "menuname" to "날치알",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        HaepariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Haepari",
                "menuname" to "해파리",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        MidudukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Miduduk",
                "menuname" to "미더덕",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        MyungranButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Myungran",
                "menuname" to "명란",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        HaesamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Haesam",
                "menuname" to "해삼",
                "display" to "1"
            )
            db.collection("UserSelect")
                .add(data)
                .addOnSuccessListener {
                    // 성공할 경우
                    Toast.makeText(this, "데이터가 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
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