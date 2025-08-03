package com.example.workouttracker.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workout_entries ORDER BY id DESC")
    fun getAllWorkouts(): Flow<List<WorkoutEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(entry: WorkoutEntry)
}
