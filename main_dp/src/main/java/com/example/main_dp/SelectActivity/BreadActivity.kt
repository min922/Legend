package com.example.main_dp.SelectActivity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_bread.*

class BreadActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bread)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        GareButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Gare",
                "menuname" to "가래떡",
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
            val data_overlap = listOf("흰떡")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "bread",
                    "id" to "Gare",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }

        DduckgukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Dduckguk",
                "menuname" to "떡국떡",
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
            val data_overlap = listOf("흰떡")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "bread",
                    "id" to "Dduckguk",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }
        }

        DduckbokkiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Dduckbokki",
                "menuname" to "떡볶이떡",
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
            val data_overlap = listOf("흰떡")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "bread",
                    "id" to "Dduckbokki",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }
        }

        BaguetteButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Baguette",
                "menuname" to "바게트",
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
        BaegleButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Baegle",
                "menuname" to "베이글",
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
        ShickbbangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "bread",
                "id" to "Shickbbang",
                "menuname" to "식빵",
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //뒤로가기 액션
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