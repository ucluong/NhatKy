package com.example.nhatki.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NhatKyDao {
    @Query("SELECT * FROM nhat_ky")
    suspend fun getAll(): List<NhatKy>

    @Insert
    fun insertAll(vararg item: NhatKy)

    @Delete
    fun delete(item: NhatKy)
}