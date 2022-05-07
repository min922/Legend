package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_noodle.*

class NoodleActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noodle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Dang",
                "menuname" to "당면",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        NaengButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Naeng",
                "menuname" to "냉면",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        KalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Kal",
                "menuname" to "칼국수",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("칼국수면")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "noodle",
                    "id" to "Kal",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JjolButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Jjol",
                "menuname" to "쫄면",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        SsalguksuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Ssalguksu",
                "menuname" to "쌀국수",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("쌀국수면")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "noodle",
                    "id" to "Ssalguksu",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }
        }
        UdongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Udong",
                "menuname" to "우동",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        SpaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Spa",
                "menuname" to "스파게티",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("스파게티", "페투치네")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "noodle",
                    "id" to "Spa",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }
        }
        RamenButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Ramen",
                "menuname" to "라면",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        GuksuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "noodle",
                "id" to "Guksu",
                "menuname" to "국수",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("녹차국수", "밀국수", "소면")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "noodle",
                    "id" to "Guksu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
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