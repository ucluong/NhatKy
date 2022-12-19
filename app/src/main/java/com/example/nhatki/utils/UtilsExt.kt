package com.example.nhatki.utils

import android.app.Activity
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun Activity.showToast(any: Any){
    Toast.makeText(this, any.toString(), Toast.LENGTH_SHORT).show()
}

fun Date.dayMonthYear(): String {
    return SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(this)
}

