package com.example.home_dp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class EditDate {
    fun editDate(id: String, context: Context) {
        val db = FirebaseFirestore.getInstance()   // Firestore 인스턴스 선언
        val builder_first = AlertDialog.Builder(context)
        val sel = arrayOf("유통기한 수정 및 삭제", "재료 삭제")
        builder_first.setItems(sel,
            DialogInterface.OnClickListener { dialog, which ->
                if (which == 0) {
                    var calendar = Calendar.getInstance()
                    var year = calendar.get(Calendar.YEAR)
                    var month = calendar.get(Calendar.MONTH)
                    var day = calendar.get(Calendar.DAY_OF_MONTH)
                    var date_listener = object : DatePickerDialog.OnDateSetListener {
                        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                            var yearedit = year.toString()
                            var monthedit = (month + 1).toString()
                            var dayedit = dayOfmonth.toString()
                            db.collection("UserSelect")
                                .get()
                                .addOnSuccessListener { result ->
                                    for (document in result) {
                                        if (document.data["id"] == id && "year" in document && "month" in document
                                            && "day" in document
                                        ) {
                                            var editid = document.id
                                            db.collection("UserSelect").document(editid).update(mapOf("year" to yearedit,
                                                "month" to monthedit, "day" to dayedit))
                                        }
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    // 실패할 경우
                                    Log.w("Date", "Error getting documents: $exception")
                                }
                        }
                    }
                    val builder = DatePickerDialog(context, date_listener, year, month, day)
                    builder.setTitle("유통기한을 입력해주세요.")
                    builder.setButton(DatePickerDialog.BUTTON_NEGATIVE,
                        "유통기한 삭제",
                        DialogInterface.OnClickListener { DatePickerDialog, i -> BUTTON_NEGATIVE
                            db.collection("UserSelect")
                                .get()
                                .addOnSuccessListener { result ->
                                    for (document in result){
                                        if(document.data["id"] == id && "year" in document && "month" in document
                                            && "day" in document){
                                            var editid = document.id
                                            db.collection("UserSelect").document(editid).update(mapOf("year" to "-",
                                                "month" to "-", "day" to "-"))
                                        }
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    // 실패할 경우
                                    Log.w("Date", "Error getting documents: $exception")
                                }
//                            RefTab().Refresh()
//                            MainActivity().refresh_frag(RefTab())
                            RefTab().updateRecyclerData()
//                            val transaction = supportFragmentManager().beginTransaction()
//                            transaction().beginTransaction().detach(RefTab()).attach(RefTab()).commit()
                            Toast.makeText(context, "유통기한이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                        }
                    )
                    builder.show() //달력 다이얼로그 띄우기
                }
                else if(which == 1){
                    db.collection("UserSelect")
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result){
                                if(document.data["id"] == id){
                                    var editid = document.id
                                    db.collection("UserSelect").document(editid).delete()
                                }
                            }
                        }
                        .addOnFailureListener { exception ->
                            // 실패할 경우
                            Log.w("Date", "Error getting documents: $exception")
                        }
                    Toast.makeText(context, "재료가 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                }
            })
        builder_first.show()
    }
}