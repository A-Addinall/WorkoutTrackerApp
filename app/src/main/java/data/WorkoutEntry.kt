package com.example.workouttracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_entries")
data class WorkoutEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val category: String,
    val exercise: String,
    val score: String
)
