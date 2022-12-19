package com.example.nhatki.data.nhatky.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.nhatki.data.nhatky.entiry.NhatKy


@Dao
interface NhatKyDao {
    @Query("SELECT * FROM nhat_ky")
    fun getAll(): LiveData<List<NhatKy>>

    @Insert
    suspend fun insert(vararg item: NhatKy)

    @Delete
    suspend fun delete(item: NhatKy)
}