package com.example.main_dp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fish_mid.*
import kotlinx.android.synthetic.main.activity_meat_mid.*

class FishMidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_mid)

        FishmidButton.setOnClickListener {
            val intent = Intent(this, FishActivity::class.java)
            startActivity(intent)
        }
        ClammidButton.setOnClickListener {
            val intent = Intent(this, ClamActivity::class.java)
            startActivity(intent)
        }
        CrapmidButton.setOnClickListener {
            val intent = Intent(this, CrapActivity::class.java)
            startActivity(intent)
        }
        HaejoryuButton.setOnClickListener {
            val intent = Intent(this, HaejoActivity::class.java)
            startActivity(intent)
        }
        FishetcButton.setOnClickListener {
            val intent = Intent(this, FishEtcActivity::class.java)
            startActivity(intent)
        }
    }
}