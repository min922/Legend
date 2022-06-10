package com.example.main_dp

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.collections.HashMap

class exist_indata {
    fun existdata(data: HashMap<String, String>, overlap:List<String>, context: Context) {
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
        var const = 0
        db.collection("UserSelect")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    if (document.data["id"] == data["id"] && "menuname" in document.data
                        && document.data["menuname"] == data["menuname"]){
                        Toast.makeText(context,
                            "이미 ${data["menuname"]}(이/가) 내 냉장고에 있습니다.",
                            Toast.LENGTH_SHORT).show()
                        const = 1
                    }
                }
                if (const == 0){
                    addData().addData(data, overlap, context)
                }
            }
    }
}