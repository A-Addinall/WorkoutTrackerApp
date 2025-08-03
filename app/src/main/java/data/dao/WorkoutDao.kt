package com.example.workouttracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.workouttracker.data.entity.*

@Dao
interface WorkoutDao {

    /* ── read ─────────────────────────────────────────────────────────── */
    @Query("SELECT * FROM workout_types")
    fun getAllWorkoutTypes(): List<WorkoutType>

    @Query("SELECT * FROM exercises WHERE workoutTypeId=:wtId")
    fun getExercisesByWorkoutType(wtId: Int): List<Exercise>

    /* NEW – last logged session per id */
    @Query(
        "SELECT * FROM workout_sessions " +
                "WHERE exerciseId = :exId " +
                "ORDER BY date DESC LIMIT 1"
    )
    fun getLastSession(exId: Int): WorkoutSession?

    /* ── write ────────────────────────────────────────────────────────── */
    @Insert fun insertWorkoutSession(s: WorkoutSession)
    @Insert fun insertWorkoutType(t: WorkoutType)
    @Insert fun insertExercises(list: List<Exercise>)
    @Query("SELECT COUNT(*) FROM workout_types") fun getWorkoutTypeCount(): Int
}
