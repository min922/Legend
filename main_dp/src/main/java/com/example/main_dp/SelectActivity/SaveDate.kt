package com.example.main_dp.SelectActivity

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class SaveDate {
    fun AddDate(id: String, context:Context) {
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언

        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        val data_cal = hashMapOf(
            "id" to id
        )
        var date_listener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                data_cal["year"] = year.toString()
                data_cal["month"] = (month + 1).toString()
                data_cal["day"] = dayOfmonth.toString()
                db.collection("UserSelect")
                    .add(data_cal)
                    .addOnSuccessListener {
                        // 성공할 경우
                        Toast.makeText(context, "재료가 추가되었습니다", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { exception ->
                        // 실패할 경우
                        Log.w("Date", "Error getting documents: $exception")
                    }
            }
        }
//        DatePickerDialog.BUTTON_NEGATIVE
        val builder = DatePickerDialog(context, date_listener, year, month, day)
        builder.setTitle("유통기한을 입력해주세요.")
        builder.setButton(DatePickerDialog.BUTTON_NEGATIVE,
            "다음에 입력하기",
            DialogInterface.OnClickListener { DatePickerDialog, i -> BUTTON_NEGATIVE
                data_cal["year"] = "-"
                data_cal["month"] = "-"
                data_cal["day"] = "-"
                db.collection("UserSelect")
                    .add(data_cal)
                    .addOnFailureListener { exception ->
                        // 실패할 경우
                        Log.w("Date", "Error getting documents: $exception")
                    }
            }
        )
        builder.show() //달력 다이얼로그 띄우기
    }
}