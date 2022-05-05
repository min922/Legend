package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_chick_activiy.*

class ChickActiviy : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chick_activiy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        ChickmeatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickmeat",
                "menuname" to "닭고기",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
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
            val data_overlap = listOf("닭", "닭살", "닭가슴살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Chickmeat",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }
        }
        ChicklegButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickleg",
                "menuname" to "닭다리",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
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
            val data_overlap = listOf("닭", "닭살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Chickleg",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ChickanshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickanshim",
                "menuname" to "닭안심",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
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
            val data_overlap = listOf("안심", "닭살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Chickanshim",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ChickbongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickbong",
                "menuname" to "닭봉",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
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
            val data_overlap = listOf("닭")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Chickbong",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ChickfeetButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Chickfeet",
                "menuname" to "닭발",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
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
            val data_overlap = listOf("닭")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Chickfeet",
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