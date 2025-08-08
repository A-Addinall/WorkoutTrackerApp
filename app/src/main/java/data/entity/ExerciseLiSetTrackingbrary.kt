package com.example.workouttracker.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "set_tracking",
    indices = [Index(value = ["workoutSessionId"]), Index(value = ["exerciseId"])],
    foreignKeys = [
        ForeignKey(
            entity = WorkoutSession::class,
            parentColumns = ["id"],
            childColumns = ["workoutSessionId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Exercise::class,
            parentColumns = ["id"],
            childColumns = ["exerciseId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class SetTracking(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val workoutSessionId: Int,
    val exerciseId: Int,
    val setNumber: Int,
    val targetReps: Int,
    val actualReps: Int,
    val weight: Double,
    val isSuccessful: Boolean,
    val rpe: Double? = null  // ← Make it nullable with Double?
)
