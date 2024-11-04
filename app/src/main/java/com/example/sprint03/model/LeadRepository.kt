package com.example.sprint03.model

import LeadDao
import androidx.lifecycle.LiveData

class LeadRepository(private val leadDao: LeadDao) {

    val readAllLeads: LiveData<List<Lead>> = leadDao.getAllLeads()

    suspend fun addLead(lead: Lead) {
        leadDao.insertLead(lead)
    }

    suspend fun updateLead(lead: Lead) {
        leadDao.updateLead(lead)
    }

    suspend fun deleteLead(lead: Lead){
        leadDao.deleteLead(lead)
    }
}
