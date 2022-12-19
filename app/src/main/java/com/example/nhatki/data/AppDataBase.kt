package com.example.nhatki.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nhatki.data.model.NhatKy
import com.example.nhatki.data.model.NhatKyDao

@Database(entities = [NhatKy::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nhatKyDao(): NhatKyDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,AppDatabase::class.java, "app_data_base")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}