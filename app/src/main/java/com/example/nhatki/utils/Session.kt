package com.example.nhatki.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.nhatki.data.AppDatabase

object Session {
    //SharedPreferences
    private val sharedPreferences: SharedPreferences =
        MyApplication.applicationContext().getSharedPreferences(
            MyApplication.applicationContext().packageName + "_session",
            Context.MODE_PRIVATE
        )

    var accessToken: String?
        get() = sharedPreferences.getString(PREF_ACCESS_TOKEN, null)
        set(value) = sharedPreferences.edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String?
        get() = sharedPreferences.getString(PREF_REFRESH_TOKEN, null)
        set(value) = sharedPreferences.edit().putString(PREF_REFRESH_TOKEN, value).apply()

    const val PREF_ACCESS_TOKEN = "access_token"
    const val PREF_REFRESH_TOKEN = "refresh_token"
}