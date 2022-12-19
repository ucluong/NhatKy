package com.example.nhatki.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity (tableName = "nhat_ky")
class NhatKy(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0 ,
    val tenNhatKy: String, val noiDung: String, val ngayViet: String) :
    java.io.Serializable {
}