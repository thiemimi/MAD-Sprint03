package com.example.sprint03.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FeedbackDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFeedback(feedback: Feedback)
    @Update
    suspend fun updtadeFeeback(feedback: Feedback)
    @Delete
    suspend fun deleteFeedback(feedback: Feedback)
    @Query("SELECT * FROM feedback ORDER BY id ASC")
    fun readAllFeedback(): LiveData<List<Feedback>>
}