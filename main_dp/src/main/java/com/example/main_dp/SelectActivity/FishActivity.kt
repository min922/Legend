package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fish.*

class FishActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        MylchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Mylchi",
                "menuname" to "멸치",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        SquidButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Squid",
                "menuname" to "오징어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("마른오징어", "오징어채")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Squid",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BukuhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Bukuh",
                "menuname" to "북어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("통북어", "생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Bukuh",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SangtaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Sangtae",
                "menuname" to "생태",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Sangtae",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SalmonButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Salmon",
                "menuname" to "연어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "연어살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Salmon",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        BoiledoctoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Boiledocto",
                "menuname" to "삶은 문어살",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        GapsquidButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gapsquid",
                "menuname" to "갑오징어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        GgolddugiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Ggolddugi",
                "menuname" to "꼴뚜기",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        JjukumiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Jjukumi",
                "menuname" to "쭈꾸미",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        DomiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Domi",
                "menuname" to "도미",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Domi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JanmylchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Janmylchi",
                "menuname" to "잔멸치",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        GalchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Galchi",
                "menuname" to "갈치",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Galchi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DaeguButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Daegu",
                "menuname" to "대구",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("대구살", "생선살", "흰살생선", "흰살 생선", "생대구")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Daegu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DongtaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Dongtae",
                "menuname" to "동태",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "흰살생선", "흰살 생선", "동태살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Dongtae",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JunuhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Junuh",
                "menuname" to "전어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Junuh",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        MaegiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Maegi",
                "menuname" to "메기",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Maegi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        InguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Inguh",
                "menuname" to "잉어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Inguh",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        SonguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Songuh",
                "menuname" to "송어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Songuh",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        AguButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Agu",
                "menuname" to "아구",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("아귀", "생선살", "흰살생선", "흰살 생선")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Agu",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JogiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Jogi",
                "menuname" to "조기",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Jogi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        NakjiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Nakji",
                "menuname" to "낙지",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("낙지다리")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Nakji",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        DriedsquidButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Driedsquid",
                "menuname" to "말린 오징어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        ChamchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Chamchi",
                "menuname" to "참치",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Chamchi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        OctopusButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Octopus",
                "menuname" to "문어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        GgongchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Ggongchi",
                "menuname" to "꽁치",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Ggongchi",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GodungButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Godung",
                "menuname" to "고등어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Godung",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        HunjaesalmonButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Hunjaesalmon",
                "menuname" to "훈제연어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
        }
        CodariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Codari",
                "menuname" to "코다리",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Codari",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        GwanguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gwanguh",
                "menuname" to "광어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Gwanguh",
                    "menuname" to data_overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect").add(data_over)
            }

        }
        JanguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Janguh",
                "menuname" to "장어",
                "display" to "1"
            )
            SaveDate().AddDate(data["id"].toString(), this)
            db.collection("UserSelect")
                .add(data)

                .addOnFailureListener { exception ->
                    // 실패할 경우
                    Log.w("MainActivity", "Error getting documents: $exception")
                }
            val data_overlap = listOf("생선살", "장어대리", "장어뼈")
            for (i in data_overlap.indices){
                val data_over = hashMapOf(
                    "photo" to "fish",
                    "id" to "Janguh",
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