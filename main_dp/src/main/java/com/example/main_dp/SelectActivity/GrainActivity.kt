package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_grain.*

class GrainActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        SsalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Ssal",
                "menuname" to "쌀",
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
            val data_overlap = listOf("밥", "쌀뜰물", "찬밥", "불린쌀", "불린 쌀", "진밥", "참쌀")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Ssal",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ChapssalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Chapssal",
                "menuname" to "찹쌀",
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
            val data_overlap = listOf("불린 찹쌀", "진밥(멥쌀+찹쌀)", "진밥")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Chapssal",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SusuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Susu",
                "menuname" to "수수",
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
        ChajoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Chajo",
                "menuname" to "차조",
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
            val data_overlap = listOf("조")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Chajo",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JunbunButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Junbun",
                "menuname" to "전분",
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
            val data_overlap = listOf("감자전분")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Junbun",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MilgaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Milgaru",
                "menuname" to "밀가루",
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
        ChapsslagaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Chapssalgaru",
                "menuname" to "찹쌀가루",
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
        NokmalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Nokmal",
                "menuname" to "녹말",
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
        DelggaegaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Delggaegaru",
                "menuname" to "들깨가루",
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
            val data_overlap = listOf("들깻가루")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Delggaegaru",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        NokmalgaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Nokmalgaru",
                "menuname" to "녹말가루",
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
            val data_overlap = listOf("녹말물")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Nokmalgaru",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GangryuckButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Gangryuck",
                "menuname" to "강력분",
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
            JatgaruButton.setOnClickListener {
                val data = hashMapOf(
                    "photo" to "rice",
                    "id" to "Jatgaru",
                    "menuname" to "잣가루",
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
                val data_overlap = listOf("잣", "식용유/소금/참기름/잣가루")
                for (i in data_overlap.indices){
                    val data_over = hashMapOf(
                        "photo" to "rice",
                        "id" to "Jatgaru",
                        "menuname" to data_overlap[i],
                    )
                    db.collection("UserSelect").add(data_over)
                }

            }
        FrygaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Frygaru",
                "menuname" to "튀김가루",
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
        KongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Kong",
                "menuname" to "콩",
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
            val data_overlap = listOf("날콩가루", "흰콩", "풋콩", "껍질콩", "서리태콩", "콩가루")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Kong",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Pat",
                "menuname" to "팥",
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
            val data_overlap = listOf("삶은팥", "팥삶은물")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Pat",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        HukimjaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Hukimja",
                "menuname" to "흑임자",
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
            val data_overlap = listOf("볶은 흑임자(검은깨)")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Hukimja",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        WanduButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Wandu",
                "menuname" to "완두콩",
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
        PeanutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Peanut",
                "menuname" to "땅콩",
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
            val data_overlap = listOf("땅콩가루")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Peanut",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GgaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Ggae",
                "menuname" to "깨",
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
            val data_overlap = listOf("참깨", "깨소금", "들깨", "검은깨", "통깨")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "rice",
                    "id" to "Ggae",
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