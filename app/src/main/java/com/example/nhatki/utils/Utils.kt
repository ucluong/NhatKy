package com.example.nhatki.utils

import java.util.*

object Utils {

    fun currentDate(): Date {
        val calendar = Calendar.getInstance()
        return calendar.time
    }
}