package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_dairy.*

class DairyActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dairy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        EggButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Egg",
                "menuname" to "계란",
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
            val data_overlap = listOf("계란흰자", "계란노른자", "달걀노른자", "달걀", "삶은계란", "계란후라이", "달걀")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "milk",
                    "id" to "Egg",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        CheeseButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Cheese",
                "menuname" to "치즈",
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
            val data_overlap = listOf("슬라이스치즈", "파마산치즈치즈", "모짜렐라치즈", "치즈", "에멘탈 치즈가루", "피자치즈", "파마산치즈", "치즈가루", "크림치즈", "아가용치즈", "아가용 치즈", "슈레드 치즈(모짜렐라치즈)", "파마르산치즈")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "milk",
                    "id" to "Cheese",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        YogartButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Yogart",
                "menuname" to "요거트",
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
            val data_overlap = listOf("플레인요구르트")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "milk",
                    "id" to "Yogart",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MilkButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "milk",
                "id" to "Milk",
                "menuname" to "우유",
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