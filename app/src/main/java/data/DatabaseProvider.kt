package com.example.workouttracker.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    @Volatile
    private var INSTANCE: WorkoutDatabase? = null

    fun getDatabase(context: Context): WorkoutDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                WorkoutDatabase::class.java,
                "workout_db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
