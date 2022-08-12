package com.example.home_dp.MyRef

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.DatePicker
import com.example.home_dp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.calendar_activity.*
import java.util.*

class CustomDialog(context: Context) {
    val db = FirebaseFirestore.getInstance()  // Firestore 인스턴스 선언
    val user = FirebaseAuth.getInstance().currentUser
    val uid = user?.uid

    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog(id: String, context: Context, menuname: String)
    {
        dialog.setContentView(R.layout.calendar_activity)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        dialog.caledit.setOnClickListener {
            val datePicker = dialog.datePicker
            datePicker.init(year, month, day, object : DatePickerDialog.OnDateSetListener,
                DatePicker.OnDateChangedListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                    onClickListener.onClicked(id, context, menuname, 0)
                    dialog.dismiss()
                }

                override fun onDateChanged(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                    onClickListener.onClicked(id, context, menuname, 0)
                    dialog.dismiss()
                }
            })
        }

        dialog.caldel.setOnClickListener {
            val datePicker = dialog.datePicker
            datePicker.init(year, month, day, object : DatePickerDialog.OnDateSetListener,
                DatePicker.OnDateChangedListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                    onClickListener.onClicked(id, context, menuname, 1)
                    dialog.dismiss()
                }

                override fun onDateChanged(view: DatePicker?, year: Int, month: Int, dayOfmonth: Int) {
                    onClickListener.onClicked(id, context, menuname, 1)
                    dialog.dismiss()
                }
            })
        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(id: String, context: Context, menuname: String, const: Int)
    }

}