package com.example.main_dp.SelectActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.main_dp.R
import com.google.firebase.firestore.FirebaseFirestore

class HaejoActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haejo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기
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