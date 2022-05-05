package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_vege.*

class VegeActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vege)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        KongnamulButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Kongnamul",
                "menuname" to "콩나물",
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
        SukjuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Sukju",
                "menuname" to "숙주",
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
            val data_overlap = listOf("숙주나물")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Sukju",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MinariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Minari",
                "menuname" to "미나리",
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
        GreenonionButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Greenonion",
                "menuname" to "파",
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
            val data_overlap = listOf("다진파", "실파", "대파", "가는파", "굵은파", "[쇠고기양념] 다진파", "다진식파", "파뿌리", "다진쪽파", "다진대파", "쪽파", "통파", "[양념장] 다진파", "대파 대", "육수용 대파")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Greenonion",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DorajiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Doraji",
                "menuname" to "도라지",
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
            val data_overlap = listOf("통도라지", "도라지나물")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Doraji",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GosariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Gosari",
                "menuname" to "고사리",
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
            val data_overlap = listOf("고사리나물")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Gosari",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ShigumchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Shigumchi",
                "menuname" to "시금치",
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
            val data_overlap = listOf("시금치즙", "시금치나물")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Shigumchi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PyogoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Pyogo",
                "menuname" to "표고",
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
            val data_overlap = listOf("말린표고버섯", "말린 표고버섯", "표고", "버섯")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Pyogo",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        YangsongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Yangsong",
                "menuname" to "양송이버섯",
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
            val data_overlap = listOf("송이버섯", "버섯")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Yangsong",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        NutariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Nutari",
                "menuname" to "느타리버섯",
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
            val data_overlap = listOf("버섯")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Nutari",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MokiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Moki",
                "menuname" to "목이버섯",
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
            val data_overlap = listOf("버섯")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Moki",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }
        }
        SaesongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Saesong",
                "menuname" to "새송이버섯",
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
            val data_overlap = listOf("송이버섯", "미니새송이버섯", "버섯")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Saesong",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PangeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Pange",
                "menuname" to "팽이버섯",
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
            val data_overlap = listOf("버섯")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Pange",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        AehobakButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Aehobak",
                "menuname" to "애호박",
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
            val data_overlap = listOf("애호박(속살)")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Aehobak",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        HobakButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Hobak",
                "menuname" to "호박",
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
            val data_overlap = listOf("청동호박", "호박잎", "둥근호박")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Hobak",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        CarrotButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Carrot",
                "menuname" to "당근",
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
            val data_overlap = listOf("당근즙", "당근잎", "당근채")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Carrot",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BuchuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Buchu",
                "menuname" to "부추",
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
            val data_overlap = listOf("영양부추")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Buchu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GochuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Gochu",
                "menuname" to "고추",
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
            val data_overlap = listOf("다진고추", "마른고추", "붉은 고추", "다진풋고추", "청양고추", "다진청고추", "다진홍고추",  "삭힌고추", "이태리고추", "칠리", "무지개고추", "풋고추")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Gochu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GarlicButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Garlic",
                "menuname" to "마늘",
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
        DaechuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Daechu",
                "menuname" to "대추",
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
        PotatoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Potato",
                "menuname" to "감자",
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
        OnionButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Onion",
                "menuname" to "양파",
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
            val data_overlap = listOf("다진양파", "양파즙")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Onion",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PimangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Pimang",
                "menuname" to "피망",
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
            val data_overlap = listOf("빨강파프리카·노랑 파프리카·청피망", "녹색피망", "홍피망", "청피망 각각")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Pimang",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PapricaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Paprica",
                "menuname" to "파프리카",
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
            val data_overlap = listOf("적파프리카", "황파프리카", "노란 파프리카", "붉은 파프리카", "미니파프리카", "빨강파프리카·노랑 파프리카·청피망", "노랑/빨강 파프리카")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Paprica",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        CucumberButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Cucumber",
                "menuname" to "오이",
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
            val data_overlap = listOf("백오이")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Cucumber",
                    "menuname" to data_overlap[i],
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SangchuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Sangchu",
                "menuname" to "상추",
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
            val data_overlap = listOf("상추잎", "꽃상추")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Sangchu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GgatipButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Ggatip",
                "menuname" to "깻잎",
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
            val data_overlap = listOf("들깻잎")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Ggatip",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Mu",
                "menuname" to "무",
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
            val data_overlap = listOf("총각무", "무즙", "무채", "래디쉬", "육수용 무")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Mu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BrocoliButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Brocoli",
                "menuname" to "브로콜리",
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
            val data_overlap = listOf("브로코리")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Brocoli",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ChunggyungButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Chunggyung",
                "menuname" to "청경채",
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
        BangtoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Bangto",
                "menuname" to "방울토마토",
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
        TomatoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Tomato",
                "menuname" to "토마토",
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
            val data_overlap = listOf("홀토마토", "토마토소스")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Tomato",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BamButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Bam",
                "menuname" to "밤",
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
            val data_overlap = listOf("깐밤", "생밤")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Bam",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BaechuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Baechu",
                "menuname" to "배추",
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
            val data_overlap = listOf("배춧잎", "풋배추", "배추잎", "얼갈이배추", "절인 배추")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Baechu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        KimchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Kimchi",
                "menuname" to "김치",
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
            val data_overlap = listOf("배추김치", "김칫잎", "열무김치", "열무", "신김치")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Kimchi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        YungeunButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Yungeun",
                "menuname" to "연근",
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
        YangsangchuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Yangsangchu",
                "menuname" to "양상추",
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
        YangbaechuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Yangbaechu",
                "menuname" to "양배추",
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
            val data_overlap = listOf("적양배추잎", "양배추잎", "적양배추")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Yangbaechu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GogumaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Goguma",
                "menuname" to "고구마",
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
        OksusuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "cabbage",
                "id" to "Oksusu",
                "menuname" to "옥수수",
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
            val data_overlap = listOf("옥수수통조림", "스위트콘")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "cabbage",
                    "id" to "Oksusu",
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