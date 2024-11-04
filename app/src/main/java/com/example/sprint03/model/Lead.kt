package com.example.sprint03.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
@Parcelize
@Entity(tableName = "leads")
data class Lead(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nome: String,
    val empresa: String,
    val titulo: String,
    val email: String,
    val telefone: String
): Parcelable