package com.example.testmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testmodule.R.layout.activity_test as test
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(test)

        butn.setOnClickListener{
            val value1 = intent.getStringExtra("key1")
            testmodule.text = value1
        }
    }
}