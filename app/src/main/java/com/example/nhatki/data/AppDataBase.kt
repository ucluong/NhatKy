package com.example.nhatki.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nhatki.data.nhatky.entiry.NhatKy
import com.example.nhatki.data.nhatky.dao.NhatKyDao
import com.example.nhatki.utils.MyApplication

@Database(entities = [NhatKy::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nhatKyDao(): NhatKyDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(MyApplication.applicationContext(),AppDatabase::class.java, "app_data_base")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}