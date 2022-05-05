package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sauce.*

class SauceActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sauce)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        SoysauceButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Soysauce",
                "menuname" to "간장",
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
            val data_overlap = listOf("진간장 ", "국간장", "햇살담은간장", "양념간장", "[쇠고기양념] 간장", "[불고기양념] 간장", "조림간장", "[절임간장] 진간장", "[비빔양념] 간장", "맛간장")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Soysauce",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GochujangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Gochujang",
                "menuname" to "고추장",
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
            val data_overlap = listOf("[초고추장] 고추장")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Gochujang",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GochugaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Gochugaru",
                "menuname" to "고추가루",
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
            val data_overlap = listOf("고춧가루", "굵은고춧가루", "고운고춧가루", "[양념장] 고춧가루")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Gochugaru",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SaltButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Salt",
                "menuname" to "소금",
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
            val data_overlap = listOf("[절임용 소금물] 소금", "[국물용 소금물] 소금", "식용유/소금/참기름/잣가루", "맛소금", "굵은소금", "꽃소금", "고운소금", "[배합초] 소금", "소금약간", "굵은소금·후춧가루", "볶은소금", "소급", "'소금, 후추'")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Salt",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        HoneyButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Honey",
                "menuname" to "꿀",
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
            val data_overlap = listOf("조청")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Honey",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DajingarlicButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Dajingarlic",
                "menuname" to "다진마늘",
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
            val data_overlap = listOf("풋마늘", "채썬마늘", "간마늘", "저민마늘")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Dajingarlic",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DoanjangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Daonjang",
                "menuname" to "된장",
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
            val data_overlap = listOf("왜된장", "일본된장", "순창콩된장", "미소된장", "미소", "아기된장소스")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Daonjang",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MayonnaiseButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Mayonnaise",
                "menuname" to "마요네즈",
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
            val data_overlap = listOf("오렌지마요네즈", "마요네스")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Mayonnaise",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MustardButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Mustard",
                "menuname" to "머스타드",
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
            val data_overlap = listOf("머스터드", "허니머스타드", "머스타드", "허니머스터드")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "Mustard",
                    "id" to "Soysauce",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MulyotButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Mulyot",
                "menuname" to "물엿",
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
        ButterButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Butter",
                "menuname" to "버터",
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
        SugerButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Suger",
                "menuname" to "설탕",
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
            val data_overlap = listOf("흰설탕", "흑설탕", "황설탕")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Suger",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MiwonButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Miwon",
                "menuname" to "미원",
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
        SsamjangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Ssamjang",
                "menuname" to "쌈장",
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
            val data_overlap = listOf("청정원순창쌈장")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Ssamjang",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DashidaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Dashida",
                "menuname" to "쇠고기 다시다",
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
            val data_overlap = listOf("청정원맛선생", "쇠고기스톡")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Dashida",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        VinegerButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Vineger",
                "menuname" to "식초",
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
        OligodangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Oligodang",
                "menuname" to "올리고당",
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
        ChungukjangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Chungukjang",
                "menuname" to "청국장",
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
        ChojangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Chojang",
                "menuname" to "초고추장",
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
            val data_overlap = listOf("[초고추장] 고추장")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Chojang",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        ChunjangButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Chunjang",
                "menuname" to "춘장",
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
        ChilisauceButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Chilisauce",
                "menuname" to "칠리소스",
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
        KetchupButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Ketchup",
                "menuname" to "케첩",
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
            val data_overlap = listOf("토마토케첩", "토마토케찹")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Ketchup",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        PepperButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Pepper",
                "menuname" to "후추",
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
            val data_overlap = listOf("통후추", "후춧가루", "흰후춧가루", "흰후추", "굵은소금·후춧가루")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Pepper",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JutgukButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Jutguk",
                "menuname" to "젓국",
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
        LemonjuiceButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Lemonjuice",
                "menuname" to "레몬즙",
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
        ShirimpjutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Shirimpjut",
                "menuname" to "새우젓",
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
            val data_overlap = listOf("새우젓국")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Shirimpjut",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DriedshirimpgaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Driedshirimpgaru",
                "menuname" to "건새우가루",
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
        YuksumulchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Yusumulchi",
                "menuname" to "육수용멸치",
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
            val data_overlap = listOf("멸칫국물", "멸치다시물", "[멸치장국] 국멸치", "국멸치", "국물용멸치")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Yusumulchi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        KatsuobushiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Katsuobushi",
                "menuname" to "가쓰오브시",
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
            val data_overlap = listOf("가쓰오브시국물", "가쯔오브시")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Katsuobushi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        Driedshirimp.setOnClickListener {
            val data = hashMapOf(
                "photo" to "salt",
                "id" to "Driedshirimp",
                "menuname" to "건새우",
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
            val data_overlap = listOf("말린 새우", "잔새우")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "salt",
                    "id" to "Driedshirimp",
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