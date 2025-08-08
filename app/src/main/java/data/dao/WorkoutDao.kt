package com.example.workouttracker.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.workouttracker.data.entity.*

@Dao
interface WorkoutDao {

    // Workout Types
    @Query("SELECT * FROM workout_type")
    suspend fun getAllWorkoutTypes(): List<WorkoutType>

    @Query("SELECT COUNT(*) FROM workout_type")
    suspend fun getWorkoutTypeCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutType(workoutType: WorkoutType)

    // Exercises
    @Query("SELECT * FROM exercise WHERE workoutTypeId = :workoutTypeId")
    suspend fun getExercisesByWorkoutType(workoutTypeId: Int): List<Exercise>

    @Query("SELECT * FROM exercise WHERE id = :exerciseId LIMIT 1")
    suspend fun getExerciseById(exerciseId: Int): Exercise?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(exercises: List<Exercise>)

    // Workout Sessions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutSession(session: WorkoutSession): Long

    @Query("SELECT * FROM workout_session WHERE exerciseId = :exerciseId ORDER BY date DESC LIMIT 1")
    suspend fun getLastSession(exerciseId: Int): WorkoutSession?

    @Query("SELECT time FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    suspend fun getLastMetconTime(exerciseId: Int): Long?

    @Query("SELECT time FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    fun getLastMetconTimeLiveData(exerciseId: Int): LiveData<Long>

    @Query("SELECT * FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT :limit")
    suspend fun getRecentWorkoutSessions(exerciseId: Int, limit: Int): List<WorkoutSession>

    // Set Tracking
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetTracking(setTracking: SetTracking)

    @Query("SELECT * FROM set_tracking WHERE exerciseId = :exerciseId ORDER BY id DESC LIMIT :limit")
    suspend fun getRecentSets(exerciseId: Int, limit: Int): List<SetTracking>

    @Query("SELECT * FROM set_tracking WHERE workoutSessionId = :sessionId")
    suspend fun getSetsForSession(sessionId: Int): List<SetTracking>

    // Weight Tracking
    @Query("SELECT weight FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT 1")
    suspend fun getLastWeightForExercise(exerciseId: Int): Double?

    @Query("SELECT weight FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT 1")
    fun getLastWeightForExerciseLiveData(exerciseId: Int): LiveData<Double?>

    // Personal Records
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersonalRecord(personalRecord: PersonalRecord)

    @Query("SELECT * FROM personal_record WHERE exerciseId = :exerciseId AND recordType = :type ORDER BY value DESC LIMIT 1")
    suspend fun getPersonalRecord(exerciseId: Int, type: String): PersonalRecord?

    @Query("SELECT * FROM personal_record WHERE exerciseId = :exerciseId ORDER BY date DESC")
    suspend fun getPersonalRecordHistory(exerciseId: Int): List<PersonalRecord>

    // User Settings
    @Query("SELECT * FROM user_settings LIMIT 1")
    suspend fun getUserSettings(): UserSettings?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserSettings(userSettings: UserSettings)

    @Update
    suspend fun updateUserSettings(userSettings: UserSettings)

    // Exercise Library
    @Query("SELECT COUNT(*) FROM exercise_library")
    suspend fun getExerciseLibraryCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseLibrary(exerciseLibrary: ExerciseLibrary)

    @Query("SELECT * FROM exercise_library WHERE category = :category AND isActive = 1")
    suspend fun getActiveExercisesByCategory(category: String): List<ExerciseLibrary>

    @Query("SELECT * FROM exercise_library WHERE isActive = 1")
    suspend fun getAllActiveExercises(): List<ExerciseLibrary>

    @Update
    suspend fun updateExerciseLibrary(exerciseLibrary: ExerciseLibrary)

    @Query("SELECT weight FROM set_tracking WHERE exerciseId = :exerciseId AND isSuccessful = 1 AND weight IS NOT NULL ORDER BY weight DESC LIMIT 1")
    fun getLastSuccessfulWeightLiveData(exerciseId: Int): LiveData<Double?>

}
