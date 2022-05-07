package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_crap.*

class CrapActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crap)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        ShirimpButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Shirimp",
                "menuname" to "새우",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("중새우살", "가재새우", "생새우", "새우살", "중새우", "잔새우")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Shirimp",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        FlowercrapButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Flowercarp",
                "menuname" to "꽃게",
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
        CrapButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Crap",
                "menuname" to "게",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("게살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Crap",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DaehaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Daeha",
                "menuname" to "대하",
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
        CocktailshirimpButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Cocktailshirimp",
                "menuname" to "칵테일새우",
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