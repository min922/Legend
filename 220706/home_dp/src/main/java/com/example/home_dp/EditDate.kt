package com.example.home_dp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class EditDate {
    fun editDate(id: String, context: Context, menuname: String) {
        val db = FirebaseFirestore.getInstance()  // Firestore 인스턴스 선언
        val builder_first = AlertDialog.Builder(context)
        val sel = arrayOf("유통기한 수정 및 삭제", "재료 삭제")
        builder_first.setItems(sel,
            DialogInterface.OnClickListener { dialog, which ->
                if (which == 0) { //유통기한
                    val calendar = Calendar.getInstance()
                    val year = calendar.get(Calendar.YEAR)
                    val month = calendar.get(Calendar.MONTH)
                    val day = calendar.get(Calendar.DAY_OF_MONTH)
                    val date_listener = object : DatePickerDialog.OnDateSetListener {
                        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                            val yearedit = year.toString()
                            val monthedit = (month + 1).toString()
                            val dayedit = dayOfmonth.toString()
                            db.collection("UserSelect")
                                .get()
                                .addOnSuccessListener { result ->
                                    for (document in result) {
                                        if (document.data["id"] == id && "year" in document && "month" in document
                                            && "day" in document
                                        ) {
                                            val editid = document.id
                                            db.collection("UserSelect")
                                                .document(editid)
                                                .update(mapOf("year" to yearedit,
                                                    "month" to monthedit,
                                                    "day" to dayedit))
                                        }
                                    }
                                    Toast.makeText(context, "${menuname}의 유통기한이 수정되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { exception ->
                                    // 실패할 경우
                                    Log.w("Date", "Error getting documents: $exception")
                                }
                        }
                    }
                    val builder = DatePickerDialog(context, date_listener, year, month, day)
                    builder.setTitle("${menuname}의 유통기한을 입력해주세요.")

                    builder.setButton(DatePickerDialog.BUTTON_NEGATIVE,
                        "유통기한 삭제",
                        DialogInterface.OnClickListener { DatePickerDialog, i -> BUTTON_NEGATIVE
                            db.collection("UserSelect")
                                .get()
                                .addOnSuccessListener { result ->
                                    for (document in result){
                                        if(document.data["id"] == id && "year" in document && "month" in document
                                            && "day" in document){
                                            val editid = document.id
                                            db.collection("UserSelect").document(editid).update(mapOf("year" to "-",
                                                "month" to "-", "day" to "-"))
                                        }
                                    }
                                    Toast.makeText(context, "${menuname}의 유통기한이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { exception ->
                                    // 실패할 경우
                                    Log.w("Date", "Error getting documents: $exception")
                                }
//                            RefTab().Refresh()
//                            MainActivity().refresh_frag(RefTab())
//                            RefTab().updateRecyclerData()
//                            val transaction = supportFragmentManager().beginTransaction()
//                            transaction().beginTransaction().detach(RefTab()).attach(RefTab()).commit()
                        }
                    )
                    builder.show() //달력 다이얼로그 띄우기
                }
                else if(which == 1){ //재료 삭제
                    db.collection("UserSelect")
                        .get()
                        .addOnSuccessListener { result ->
                            for (document in result){
                                if(document.data["id"] == id){
                                    val editid = document.id
                                    db.collection("UserSelect").document(editid).delete()
                                }
                            }
                            Toast.makeText(context, "${menuname}(이/가) 내 냉장고에서 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { exception ->
                            // 실패할 경우
                            Log.w("Date", "Error getting documents: $exception")
                        }
                }
            })
        builder_first.show()
    }
}