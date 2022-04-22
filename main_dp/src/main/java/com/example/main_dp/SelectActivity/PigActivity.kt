package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_pig.*

class PigActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pig)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        PigmeatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Pigmeat",
                "menuname" to "돼지고기",
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
            val data_overlap = listOf("돼기고기", "돼지 볼살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Pigmeat",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }
        }
        PigbackButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Pigback",
                "menuname" to "돼지등갈비",
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
            val data_overlap = listOf("갈비", "돼기고기")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Pigback",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PiganshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Piganshim",
                "menuname" to "돼지고기안심",
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
            val data_overlap = listOf("안심", "돼기고기")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Piganshim",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PigcutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Pigcut",
                "menuname" to "다진돼지고기",
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
            val data_overlap = listOf("돼기고기", "다짐육", "다짐육(돼지고기)")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Pigcut",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PiggalbiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Piggalbi",
                "menuname" to "돼지갈비",
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
            val data_overlap = listOf("갈비", "돼기고기")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Piggalbi",
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