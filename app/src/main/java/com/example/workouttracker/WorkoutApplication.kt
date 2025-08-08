package com.example.workouttracker

import android.app.Application
import com.example.workouttracker.data.database.WorkoutDatabase
import com.example.workouttracker.data.repository.WorkoutRepository
import com.example.workouttracker.data.database.DatabaseInitializer

class WorkoutApplication : Application() {
    val database by lazy { WorkoutDatabase.getDatabase(this) }
    val repository by lazy { WorkoutRepository(database.workoutDao()) }

    override fun onCreate() {
        super.onCreate()

        // Initialize database only once when app starts
        Thread {
            val databaseInitializer = DatabaseInitializer()
            databaseInitializer.initializeDatabase(database.workoutDao())
        }.start()
    }
}
