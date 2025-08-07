package com.example.workouttracker.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise",
    indices = [Index(value = ["workoutTypeId"])],  // Add this line
    foreignKeys = [ForeignKey(
        entity = WorkoutType::class,
        parentColumns = ["id"],
        childColumns = ["workoutTypeId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val workoutTypeId: Int,
    val name: String,
    val category: String, // "Strength" or "Metcon"
    val repRange: String,
    val description: String? = null
)
