package com.example.workouttracker

import android.app.Application
import com.example.workouttracker.data.database.WorkoutDatabase
import com.example.workouttracker.data.repository.WorkoutRepository

class WorkoutApplication : Application() {
    val database by lazy { WorkoutDatabase.getDatabase(this) }
    val repository by lazy { WorkoutRepository(database.workoutDao()) }
}
