package com.example.main_dp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_meat_mid.*

class MeatMidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meat_mid)
        PigButton.setOnClickListener {
            val intent = Intent(this, PigActivity::class.java)
            startActivity(intent)
        }
        CowButton.setOnClickListener {
            val intent = Intent(this, CowActivity::class.java)
            startActivity(intent)
        }
        ChickButton.setOnClickListener {
            val intent = Intent(this, ChickActiviy::class.java)
            startActivity(intent)
        }
        MeatetcButton.setOnClickListener {
            val intent = Intent(this, MeatEtcActivity::class.java)
            startActivity(intent)
        }
    }
}