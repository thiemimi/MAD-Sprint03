import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sprint03.model.Lead

@Dao
interface LeadDao {
    @Insert
    suspend fun insertLead(lead: Lead)
    @Update
    suspend fun updateLead(lead: Lead)
    @Query("SELECT * FROM leads")
    fun getAllLeads(): LiveData<List<Lead>>
}
