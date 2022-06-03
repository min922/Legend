package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_fish.*

class FishActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

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
            exist_indata().existdata(data, data_overlap, this)
        }
        SquidButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Squid",
                "menuname" to "오징어",
                "display" to "1"
            )
            data_overlap = listOf("마른오징어", "오징어채")
            exist_indata().existdata(data, data_overlap, this)
        }
        BukuhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Bukuh",
                "menuname" to "북어",
                "display" to "1"
            )
            data_overlap = listOf("통북어", "생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        SangtaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Sangtae",
                "menuname" to "생태",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            exist_indata().existdata(data, data_overlap, this)
        }
        SalmonButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Salmon",
                "menuname" to "연어",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "연어살")
            exist_indata().existdata(data, data_overlap, this)
        }
        BoiledoctoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Boiledocto",
                "menuname" to "삶은 문어살",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        GapsquidButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gapsquid",
                "menuname" to "갑오징어",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        GgolddugiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Ggolddugi",
                "menuname" to "꼴뚜기",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        JjukumiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Jjukumi",
                "menuname" to "쭈꾸미",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        DomiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Domi",
                "menuname" to "도미",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            exist_indata().existdata(data, data_overlap, this)
        }
        JanmylchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Janmylchi",
                "menuname" to "잔멸치",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        GalchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Galchi",
                "menuname" to "갈치",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        DaeguButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Daegu",
                "menuname" to "대구",
                "display" to "1"
            )
            data_overlap = listOf("대구살", "생선살", "흰살생선", "흰살 생선", "생대구")
            exist_indata().existdata(data, data_overlap, this)
        }
        DongtaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Dongtae",
                "menuname" to "동태",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "흰살생선", "흰살 생선", "동태살")
            exist_indata().existdata(data, data_overlap, this)
        }
        JunuhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Junuh",
                "menuname" to "전어",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        MaegiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Maegi",
                "menuname" to "메기",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            exist_indata().existdata(data, data_overlap, this)
        }
        InguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Inguh",
                "menuname" to "잉어",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        SonguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Songuh",
                "menuname" to "송어",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        AguButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Agu",
                "menuname" to "아구",
                "display" to "1"
            )
            data_overlap = listOf("아귀", "생선살", "흰살생선", "흰살 생선")
            exist_indata().existdata(data, data_overlap, this)
        }
        JogiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Jogi",
                "menuname" to "조기",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            exist_indata().existdata(data, data_overlap, this)
        }
        NakjiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Nakji",
                "menuname" to "낙지",
                "display" to "1"
            )
            data_overlap = listOf("낙지다리")
            exist_indata().existdata(data, data_overlap, this)
        }
        DriedsquidButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Driedsquid",
                "menuname" to "말린 오징어",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        ChamchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Chamchi",
                "menuname" to "참치",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        OctopusButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Octopus",
                "menuname" to "문어",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        GgongchiButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Ggongchi",
                "menuname" to "꽁치",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        GodungButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Godung",
                "menuname" to "고등어",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        HunjaesalmonButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Hunjaesalmon",
                "menuname" to "훈제연어",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        CodariButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Codari",
                "menuname" to "코다리",
                "display" to "1"
            )
            data_overlap = listOf("생선살")
            exist_indata().existdata(data, data_overlap, this)
        }
        GwanguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Gwanguh",
                "menuname" to "광어",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "흰살생선", "흰살 생선")
            exist_indata().existdata(data, data_overlap, this)
        }
        JanguhButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "fish",
                "id" to "Janguh",
                "menuname" to "장어",
                "display" to "1"
            )
            data_overlap = listOf("생선살", "장어대리", "장어뼈")
            exist_indata().existdata(data, data_overlap, this)
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