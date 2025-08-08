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

        // Use the non-suspend version - no coroutines needed!
        Thread {
            val dao = database.workoutDao()
            val existingWorkoutTypes = dao.getWorkoutTypeCountSync()

            if (existingWorkoutTypes == 0) {
                println("DEBUG: Database empty, initializing...")
                val databaseInitializer = DatabaseInitializer()
                databaseInitializer.initializeDatabase(dao)
            } else {
                println("DEBUG: Database already has $existingWorkoutTypes workout types, skipping initialization")
            }
        }.start()
    }
}
