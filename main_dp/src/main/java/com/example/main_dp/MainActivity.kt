package com.example.main_dp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.main_dp.SelectActivity.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                meatButton.setOnClickListener {
                        val intent = Intent(this, MeatMidActivity::class.java)
                        startActivity(intent)
                }
                vegeButton.setOnClickListener {
                        val intent = Intent(this, VegeActivity::class.java)
                        startActivity(intent)
                }
                fruitButton.setOnClickListener {
                        val intent = Intent(this, FruitActivity::class.java)
                        startActivity(intent)
                }
                dairyButton.setOnClickListener {
                        val intent = Intent(this, DairyActivity::class.java)
                        startActivity(intent)
                }
                breadButton.setOnClickListener {
                        val intent = Intent(this, BreadActivity::class.java)
                        startActivity(intent)
                }
                grainButton.setOnClickListener {
                        val intent = Intent(this, GrainActivity::class.java)
                        startActivity(intent)
                }
                fishButton.setOnClickListener {
                        val intent = Intent(this, FishMidActivity::class.java)
                        startActivity(intent)
                }
                proButton.setOnClickListener{
                        val intent = Intent(this, ProActivity::class.java)
                        startActivity(intent)
                }
                sauceButton.setOnClickListener {
                        val intent = Intent(this, SauceActivity::class.java)
                        startActivity(intent)
                }
                oilButton.setOnClickListener {
                        val intent = Intent(this, OilActivity::class.java)
                        startActivity(intent)
                }
                noodleButton.setOnClickListener {
                        val intent = Intent(this, NoodleActivity::class.java)
                        startActivity(intent)
                }
                etcButton.setOnClickListener {
                        val intent = Intent(this, EtcActivity::class.java)
                        startActivity(intent)
                }
        }

}