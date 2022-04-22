package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_haejo.*
import kotlinx.android.synthetic.main.activity_pro.*

class HaejoActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haejo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DashimaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Dashima",
                "menuname" to "다시마",
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
            val data_overlap = listOf("다시물", "다시마국물", "쌈다시마", "다시마 우린 물", "국물용 다시마")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Dashima",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SeaweedButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Seaweed",
                "menuname" to "미역",
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
            val data_overlap = listOf("불린미역")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Seaweed",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gim",
                "menuname" to "김",
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
            val data_overlap = listOf("김밥용김", "구운김")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Gim",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ParaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Parae",
                "menuname" to "파래",
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
        HaechoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Haecho",
                "menuname" to "해초",
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
        UmukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Umuk",
                "menuname" to "우묵",
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