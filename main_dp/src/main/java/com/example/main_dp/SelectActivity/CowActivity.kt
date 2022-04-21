package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_cow.*

class CowActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        CowmeatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowmeat",
                "menuname" to "소고기",
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
            val data_overlap = listOf("쇠고기", "쇠고기(힘줄없는부위)", "쇠고기(안심 또는 등심)")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Cowmeat",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        CowcutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowcut",
                "menuname" to "다진소고기",
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
            val data_overlap = listOf("다진쇠고기", "다짐육", "다짐육(소고기)", "채썬쇠고기")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Cowcut",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }
        }
        CowtailButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowtail",
                "menuname" to "소꼬리",
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
        CowanshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowanshim",
                "menuname" to "소고기안심",
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
            val data_overlap = listOf("안심", "쇠고기(안심 또는 등심)")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Cowanshim",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        CowdungshimButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowdungshim",
                "menuname" to "소고기등심",
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
            val data_overlap = listOf("쇠고기(안심 또는 등심)")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "meat",
                    "id" to "Cowdungshim",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        CowheadButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowhead",
                "menuname" to "양지머리",
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
        CowbloodButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "meat",
                "id" to "Cowblood",
                "menuname" to "선지",
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