package com.example.main_dp.SelectActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.main_dp.R
import kotlinx.android.synthetic.main.activity_fish_mid.*
import kotlinx.android.synthetic.main.activity_fish_mid.TorefButton
import kotlinx.android.synthetic.main.activity_main_select.*

class FishMidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_mid)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바뒤로가기

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
            val intent = Intent(this, HaejoryuActivity::class.java)
            startActivity(intent)
        }
        FishetcButton.setOnClickListener {
            val intent = Intent(this, FishEtcActivity::class.java)
            startActivity(intent)
        }
        TorefButton.setOnClickListener {
            finish() //선택 액티비티 종료해서 내 냉장고로 돌아갈 수 있도록 함
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