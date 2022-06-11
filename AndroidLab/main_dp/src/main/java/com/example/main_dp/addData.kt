package com.example.main_dp

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class addData {
    fun addData(data: HashMap<String, String>, overlap:List<String>, context: Context){
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
        SaveDate().AddDate(data["id"].toString(), context)
        db.collection("UserSelect")
            .add(data)
            .addOnFailureListener { exception ->
                // 실패할 경우
                Log.w("MainActivity", "Error getting documents: $exception")
            }
        if (overlap[0] != "0"){
            for (i in overlap.indices){
                val data_over = hashMapOf(
                    "photo" to data["photo"],
                    "id" to data["id"],
                    "menuname" to overlap[i],
                    "display" to "0"
                )
                db.collection("UserSelect")
                    .add(data_over)
                    .addOnFailureListener { exception ->
                        // 실패할 경우
                        Log.w("MainActivity", "Error getting documents: $exception")
                    }
            }
        }
    }
}