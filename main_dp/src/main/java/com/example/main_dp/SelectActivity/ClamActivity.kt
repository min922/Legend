package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_clam.*

class ClamActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clam)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        HonghapButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Honghap",
                "menuname" to "홍합",
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
            val data_overlap = listOf("검은껍질홍합")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Honghap",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MoshiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Moshi",
                "menuname" to "모시조개",
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
        ChamsoraButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Chamsora",
                "menuname" to "참소라살",
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
        GaribiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Garibi",
                "menuname" to "가리비",
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
        JaechupButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Jaechup",
                "menuname" to "재첩",
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
        GulButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gul",
                "menuname" to "굴",
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
            val data_overlap = listOf("생굴")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Gul",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BajirakButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Bajirak",
                "menuname" to "바지락",
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
            val data_overlap = listOf("조개살", "조갯살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Bajirak",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GolbangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Golbang",
                "menuname" to "골뱅이",
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
        MatclamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Matclam",
                "menuname" to "맛조개",
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
            val data_overlap = listOf("맛살조개")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Matclam",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ClamsalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Clamsal",
                "menuname" to "조갯살",
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
            val data_overlap = listOf("조개살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Clamsal",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PiclamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Piclam",
                "menuname" to "피조개",
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
            val data_overlap = listOf("조개살", "조갯살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Piclam",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JunbokButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Junbok",
                "menuname" to "전복",
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
        MatsalclamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Matsalclam",
                "menuname" to "맛살조개",
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
            val data_overlap = listOf("조개살", "조갯살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Matsalclam",
                    "menuname" to data_overlap[i],
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