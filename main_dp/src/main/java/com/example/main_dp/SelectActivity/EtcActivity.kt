package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_etc.*

class EtcActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etc)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        DubuButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Dubu",
                "menuname" to "두부",
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
        SundubuButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Sundubu",
                "menuname" to "순두부",
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
        KongbijiButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Kongbiji",
                "menuname" to "콩비지",
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
        YubuButton.setOnClickListener {
            val data = hashMapOf(
                "id" to "Yubu",
                "menuname" to "유부",
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