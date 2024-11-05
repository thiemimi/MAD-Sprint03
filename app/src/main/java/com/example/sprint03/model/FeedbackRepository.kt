package com.example.sprint03.model

import androidx.lifecycle.LiveData

class FeedbackRepository(private val feedbackDao: FeedbackDao) {

    val readAllFeedbacks: LiveData<List<Feedback>> = feedbackDao.readAllFeedback()

    suspend fun addFeedback(feedback: Feedback){
        feedbackDao.addFeedback(feedback)
    }

    suspend fun updateFeedback(feedback: Feedback) {
        feedbackDao.updtadeFeeback(feedback)
    }

    suspend fun deleteFeedback(feedback: Feedback){
        feedbackDao.deleteFeedback(feedback)
    }
}