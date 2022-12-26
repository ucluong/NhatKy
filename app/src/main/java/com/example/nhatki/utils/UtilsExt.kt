package com.example.nhatki.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import com.example.nhatki.R
import java.text.SimpleDateFormat
import java.util.*

fun Activity.showToast(any: Any){
    Toast.makeText(this, any.toString(), Toast.LENGTH_SHORT).show()
}

fun Date.dayMonthYear(): String {
    return SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(this)
}


fun Activity.showAlertDialog(
    context: Context, title: Int = R.string.app_name, message: String,
    action: () -> Unit
) {
    AlertDialog.Builder(context)
        .setMessage(message)
        .setTitle(title)
        .setPositiveButton(R.string.ok) { _, _ -> action() }
        .setNegativeButton(R.string.camcel, null)
        .create()
        .show()
}
