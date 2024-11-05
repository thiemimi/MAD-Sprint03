package com.example.sprint03.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "feedback")
data class Feedback(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lead: String,
    val feedback: String
): Parcelable
