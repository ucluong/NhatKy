package com.example.nhatki.data.nhatky.entiry

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "nhat_ky")
class NhatKy(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0 ,
    val tenNhatKy: String,
    val noiDung: String, val ngayViet: String) :
    java.io.Serializable {
}