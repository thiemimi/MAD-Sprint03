package com.example.sprint03.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sprint03.model.Feedback
import com.example.sprint03.model.FeedbackDatabase
import com.example.sprint03.model.FeedbackRepository
import com.example.sprint03.model.Lead
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedbackViewModel(application: Application): AndroidViewModel(application) {

    val readAllFeedbacks: LiveData<List<Feedback>>
    private val repository: FeedbackRepository

    init{
        val feedbackDao = FeedbackDatabase.getDatabase(application).feedbackDao()
        repository = FeedbackRepository(feedbackDao)
        readAllFeedbacks = repository.readAllFeedbacks
    }

    fun addFeedback(feedback: Feedback){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFeedback(feedback)
        }
    }

    fun updateFeedback(feedback: Feedback){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFeedback(feedback)
        }
    }

    fun deleteFeedback(feedback: Feedback){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFeedback(feedback)
        }
    }

}