package com.example.workouttracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_type")
data class WorkoutType(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String
)
