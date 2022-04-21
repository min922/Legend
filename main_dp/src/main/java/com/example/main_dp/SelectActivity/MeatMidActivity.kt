package com.example.main_dp.SelectActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.main_dp.R
import kotlinx.android.synthetic.main.activity_meat_mid.*

class MeatMidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meat_mid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

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