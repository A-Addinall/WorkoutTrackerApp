package com.example.workouttracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_session")
data class WorkoutSession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val exerciseId: Int,
    val date: Long,
    val sets: Int,
    val reps: Int,
    val weight: Double? = null,
    val time: Long? = null, // for metcon exercises in seconds
    val notes: String? = null
)
