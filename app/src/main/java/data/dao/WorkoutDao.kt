package com.example.workouttracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.workouttracker.data.entity.*

@Dao
interface WorkoutDao {

    /* ────────── ORIGINAL QUERIES ────────── */
    @Query("SELECT * FROM workout_types")
    fun getAllWorkoutTypes(): List<WorkoutType>

    @Query("SELECT * FROM exercises WHERE workoutTypeId = :wtId")
    fun getExercisesByWorkoutType(wtId: Int): List<Exercise>

    @Query("SELECT * FROM workout_sessions WHERE exerciseId = :exId ORDER BY date DESC LIMIT 1")
    fun getLastSession(exId: Int): WorkoutSession?

    @Insert fun insertWorkoutSession(s: WorkoutSession)
    @Insert fun insertWorkoutType(t: WorkoutType)
    @Insert fun insertExercises(list: List<Exercise>)
    @Query("SELECT COUNT(*) FROM workout_types")
    fun getWorkoutTypeCount(): Int

    /* ────────── NEW QUERIES FOR PHASE 1 ────────── */

    // Personal Records
    @Insert fun insertPersonalRecord(pr: PersonalRecord)

    @Query("SELECT * FROM personal_records WHERE exerciseId = :exerciseId AND recordType = :type ORDER BY value DESC LIMIT 1")
    fun getPersonalRecord(exerciseId: Int, type: String): PersonalRecord?

    @Query("SELECT * FROM personal_records WHERE exerciseId = :exerciseId ORDER BY date DESC")
    fun getPersonalRecordHistory(exerciseId: Int): List<PersonalRecord>

    // User Settings
    @Insert fun insertUserSettings(settings: UserSettings)
    @Update fun updateUserSettings(settings: UserSettings)

    @Query("SELECT * FROM user_settings WHERE id = 1 LIMIT 1")
    fun getUserSettings(): UserSettings?

    // Exercise Library
    @Insert fun insertExerciseLibrary(exercises: List<ExerciseLibrary>)
    @Update fun updateExerciseLibrary(exercise: ExerciseLibrary)

    @Query("SELECT * FROM exercise_library WHERE category = :category AND isActive = 1")
    fun getActiveExercisesByCategory(category: String): List<ExerciseLibrary>

    @Query("SELECT * FROM exercise_library WHERE isActive = 1 ORDER BY category, name")
    fun getAllActiveExercises(): List<ExerciseLibrary>

    @Query("SELECT COUNT(*) FROM exercise_library")
    fun getExerciseLibraryCount(): Int

    // Set Tracking
    @Insert fun insertSetTracking(setTracking: SetTracking)

    @Query("SELECT * FROM set_tracking WHERE exerciseId = :exerciseId ORDER BY workoutSessionId DESC LIMIT :limit")
    fun getRecentSets(exerciseId: Int, limit: Int = 6): List<SetTracking>

    @Query("SELECT * FROM set_tracking WHERE workoutSessionId = :sessionId ORDER BY setNumber")
    fun getSetsForSession(sessionId: Int): List<SetTracking>
}
