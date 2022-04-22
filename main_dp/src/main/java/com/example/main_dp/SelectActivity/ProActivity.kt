package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_pro.*

class ProActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        CrapmatsalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Crapmatsal",
                "menuname" to "게맛살",
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
            val data_overlap = listOf("맛살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "sausage",
                    "id" to "Crapmatsal",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        UmukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Umuk",
                "menuname" to "장식용어묵",
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
        HamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Ham",
                "menuname" to "햄",
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
            val data_overlap = listOf("슬라이스햄", "네모난햄")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "sausage",
                    "id" to "Ham",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BaconButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Bacon",
                "menuname" to "베이컨",
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
        FranksausageButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Franksausage",
                "menuname" to "프랑크소세지",
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
        ViennasausageButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Viennasiusage",
                "menuname" to "비엔나소세지",
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
        GolbangcanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Golbangcan",
                "menuname" to "골뱅이통조림",
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
        GgongchicanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Ggongchican",
                "menuname" to "꽁치통조림",
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
        ChamchicanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Chamchican",
                "menuname" to "참치통조림",
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
            val data_overlap = listOf("참치캔")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "sausage",
                    "id" to "Chamchican",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        FruitcanButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "sausage",
                "id" to "Fruitcan",
                "menuname" to "과일통조림",
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
            val data_overlap = listOf("후루츠칵테일")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "sausage",
                    "id" to "Fruitcan",
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