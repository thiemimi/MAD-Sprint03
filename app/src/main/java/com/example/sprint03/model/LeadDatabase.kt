package com.example.sprint03.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Lead::class], version = 1, exportSchema = false)
abstract class LeadDatabase: RoomDatabase() {

    abstract fun leadDao(): LeadDao

    companion object{
        @Volatile
        private var INSTANCE: LeadDatabase? = null

        fun getDatabase(context: Context): LeadDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LeadDatabase::class.java,
                    "lead-database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}