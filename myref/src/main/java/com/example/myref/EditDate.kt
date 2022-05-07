package com.example.myref

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class EditDate {
    fun editDate(id: String, context:Context) {
        Log.w("djflanrf", "${id}")
//        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
//
//        var calendar = Calendar.getInstance()
//        var year = calendar.get(Calendar.YEAR)
//        var month = calendar.get(Calendar.MONTH)
//        var day = calendar.get(Calendar.DAY_OF_MONTH)
//        var date_listener = object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
//                var yearedit = year.toString()
//                var monthedit = (month + 1).toString()
//                var dayedit = dayOfmonth.toString()
//                db.collection("UserSelect")
//                    .get()
//                    .addOnSuccessListener { result ->
//                        for (document in result) {
//                            if (document.data["id"] == id && "year" in document && "month" in document
//                                && "day" in document
//                            ) {
//                                var editid = document.id
//                                db.collection("UserSelect").document(editid).update(mapOf("year" to yearedit,
//                                    "month" to monthedit, "day" to dayedit))
//                            }
//                        }
//                    }
//                    .addOnFailureListener { exception ->
//                        // 실패할 경우
//                        Log.w("Date", "Error getting documents: $exception")
//                    }
//            }
//        }
////        DatePickerDialog.BUTTON_NEGATIVE
//        val builder = DatePickerDialog(context, date_listener, year, month, day)
////        builder.setTitle("선택한 식품의 유통기한을 입력해주세요.")
//        builder.setButton(DatePickerDialog.BUTTON_NEGATIVE,
//            "재료 삭제하기",
//            DialogInterface.OnClickListener { DatePickerDialog, i -> BUTTON_NEGATIVE
//                db.collection("UserSelect")
//                    .get()
//                    .addOnSuccessListener { result ->
//                        for (document in result){
//                            if(document.data["id"] == id){
//                                var editid = document.id
//                                db.collection("UserSelect").document(editid).delete()
//                            }
//                        }
//                    }
//                    .addOnFailureListener { exception ->
//                        // 실패할 경우
//                        Log.w("Date", "Error getting documents: $exception")
//                    }
//            }
//        )
//        builder.show() //달력 다이얼로그 띄우기
    }
}