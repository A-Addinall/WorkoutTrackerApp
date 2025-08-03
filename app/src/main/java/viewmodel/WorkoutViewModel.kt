package com.example.workouttracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.workouttracker.data.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = WorkoutDatabase.getDatabase(application).workoutDao()

    val allWorkouts: Flow<List<WorkoutEntry>> = dao.getAllWorkouts()

    fun addEntry(entry: WorkoutEntry) {
        viewModelScope.launch {
            dao.insertWorkout(entry)
        }
    }
}
