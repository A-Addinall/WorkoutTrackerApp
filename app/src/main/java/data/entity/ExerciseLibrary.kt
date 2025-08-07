package com.example.workouttracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_library")
data class ExerciseLibrary(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String, // "Strength", "Metcon", "Accessory"
    val muscleGroups: String, // JSON array: ["chest", "shoulders"]
    val equipment: String, // "barbell", "dumbbell", "bodyweight", etc.
    val difficulty: Int, // 1-5
    val instructions: String? = null,
    val isActive: Boolean = true,
    val isDefault: Boolean = false // true for pre-populated exercises
)
