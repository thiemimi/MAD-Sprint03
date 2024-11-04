package com.example.sprint03.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sprint03.model.Lead
import com.example.sprint03.model.LeadDatabase
import com.example.sprint03.model.LeadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LeadViewModel(application: Application): AndroidViewModel(application) {

    val readAllLead: LiveData<List<Lead>>
    private val repository: LeadRepository
    init {
        val leadDao = LeadDatabase.getDatabase(application).leadDao()
        repository = LeadRepository(leadDao)
        readAllLead = repository.readAllLeads
    }

    fun addLead(lead: Lead){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLead(lead)
        }
    }

    fun updateLead(lead: Lead){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLead(lead)
        }
    }
}