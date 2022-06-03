package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.main_dp.R
import com.example.main_dp.SaveDate
import com.example.main_dp.exist_indata
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_grain.*

class GrainActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
    var data_overlap = listOf<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

        SsalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Ssal",
                "menuname" to "쌀",
                "display" to "1"
            )
            data_overlap = listOf("밥", "쌀뜰물", "찬밥", "불린쌀", "불린 쌀", "진밥", "참쌀")
            exist_indata().existdata(data, data_overlap, this)
        }
        ChapssalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Chapssal",
                "menuname" to "찹쌀",
                "display" to "1"
            )
            data_overlap = listOf("불린 찹쌀", "진밥(멥쌀+찹쌀)", "진밥")
            exist_indata().existdata(data, data_overlap, this)
        }
        SusuButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Susu",
                "menuname" to "수수",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        ChajoButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Chajo",
                "menuname" to "차조",
            )
            data_overlap = listOf("조")
            exist_indata().existdata(data, data_overlap, this)
        }
        JunbunButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Junbun",
                "menuname" to "전분",
                "display" to "1"
            )
            data_overlap = listOf("감자전분")
            exist_indata().existdata(data, data_overlap, this)
        }
        MilgaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Milgaru",
                "menuname" to "밀가루",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        ChapsslagaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Chapssalgaru",
                "menuname" to "찹쌀가루",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        NokmalButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Nokmal",
                "menuname" to "녹말",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        DelggaegaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Delggaegaru",
                "menuname" to "들깨가루",
                "display" to "1"
            )
            data_overlap = listOf("들깻가루")
            exist_indata().existdata(data, data_overlap, this)
        }
        NokmalgaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Nokmalgaru",
                "menuname" to "녹말가루",
                "display" to "1"
            )
            data_overlap = listOf("녹말물")
            exist_indata().existdata(data, data_overlap, this)
        }
        GangryuckButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Gangryuck",
                "menuname" to "강력분",
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        JatgaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Jatgaru",
                "menuname" to "잣가루",
                "display" to "1"
            )
            data_overlap = listOf("잣", "식용유/소금/참기름/잣가루")
            exist_indata().existdata(data, data_overlap, this)
        }
        FrygaruButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Frygaru",
                "menuname" to "튀김가루",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        KongButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Kong",
                "menuname" to "콩",
                "display" to "1"
            )
            data_overlap = listOf("날콩가루", "흰콩", "풋콩", "껍질콩", "서리태콩", "콩가루")
            exist_indata().existdata(data, data_overlap, this)
        }
        PatButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Pat",
                "menuname" to "팥",
                "display" to "1"
            )
            data_overlap = listOf("삶은팥", "팥삶은물")
            exist_indata().existdata(data, data_overlap, this)
        }
        HukimjaButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Hukimja",
                "menuname" to "흑임자",
                "display" to "1"
            )
            data_overlap = listOf("볶은 흑임자(검은깨)")
            exist_indata().existdata(data, data_overlap, this)
        }
        WanduButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Wandu",
                "menuname" to "완두콩",
                "display" to "1"
            )
            exist_indata().existdata(data, data_overlap, this)
        }
        PeanutButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Peanut",
                "menuname" to "땅콩",
                "display" to "1"
            )
            data_overlap = listOf("땅콩가루")
            exist_indata().existdata(data, data_overlap, this)
        }
        GgaeButton.setOnClickListener {
            val data = hashMapOf(
                "photo" to "rice",
                "id" to "Ggae",
                "menuname" to "깨",
                "display" to "1"
            )
            data_overlap = listOf("참깨", "깨소금", "들깨", "검은깨", "통깨")
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