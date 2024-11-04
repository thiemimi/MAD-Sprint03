package com.example.sprint03.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LeadDao {
    @Insert
    suspend fun insertLead(lead: Lead)
    @Update
    suspend fun updateLead(lead: Lead)
    @Delete
    suspend fun deleteLead(lead: Lead)
    @Query("SELECT * FROM leads")
    fun getAllLeads(): LiveData<List<Lead>>
}
