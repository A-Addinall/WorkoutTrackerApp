package com.example.workouttracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.workouttracker.data.entity.*
import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy

@Dao
interface WorkoutDao {

    @Query("SELECT COUNT(*) FROM workout_type")
    suspend fun getWorkoutTypeCount(): Int

    @Query("SELECT * FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT :limit")
    suspend fun getRecentWorkoutSessions(exerciseId: Int, limit: Int): List<WorkoutSession>

    @Query("SELECT * FROM exercise WHERE id = :exerciseId LIMIT 1")
    suspend fun getExerciseById(exerciseId: Int): Exercise?

    @Query("SELECT COUNT(*) FROM exercise_library")
    suspend fun getExerciseLibraryCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(exercises: List<Exercise>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseLibrary(exerciseLibrary: ExerciseLibrary)
    /* ────────── WORKOUT TYPES ────────── */
    @Query("SELECT * FROM workout_type")
    suspend fun getAllWorkoutTypes(): List<WorkoutType>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutType(workoutType: WorkoutType)

    /* ────────── EXERCISES ────────── */
    @Query("SELECT * FROM exercise WHERE workoutTypeId = :workoutTypeId")
    suspend fun getExercisesByWorkoutType(workoutTypeId: Int): List<Exercise>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    /* ────────── WORKOUT SESSIONS ────────── */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutSession(session: WorkoutSession): Long

    @Query("SELECT * FROM workout_session WHERE exerciseId = :exerciseId ORDER BY date DESC LIMIT 1")
    suspend fun getLastSession(exerciseId: Int): WorkoutSession?

    @Query("SELECT time FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    suspend fun getLastMetconTime(exerciseId: Int): Long?

    @Query("SELECT COALESCE(time, 0) FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    fun getLastMetconTimeLiveData(exerciseId: Int): LiveData<Long>

    /* ────────── SET TRACKING ────────── */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSetTracking(setTracking: SetTracking)

    @Query("SELECT * FROM set_tracking WHERE exerciseId = :exerciseId ORDER BY id DESC LIMIT :limit")
    suspend fun getRecentSets(exerciseId: Int, limit: Int): List<SetTracking>

    @Query("SELECT * FROM set_tracking WHERE workoutSessionId = :sessionId ORDER BY setNumber ASC")
    suspend fun getSetsForSession(sessionId: Int): List<SetTracking>

    @Query("SELECT weight FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT 1")
    suspend fun getLastWeightForExercise(exerciseId: Int): Double?

    @Query("SELECT weight FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT 1")
    fun getLastWeightForExerciseLiveData(exerciseId: Int): LiveData<Double?>

    /* ────────── PERSONAL RECORDS ────────── */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersonalRecord(personalRecord: PersonalRecord)

    @Query("SELECT * FROM personal_record WHERE exerciseId = :exerciseId AND recordType = :type ORDER BY date DESC LIMIT 1")
    suspend fun getPersonalRecord(exerciseId: Int, type: String): PersonalRecord?

    @Query("SELECT * FROM personal_record WHERE exerciseId = :exerciseId ORDER BY date DESC")
    suspend fun getPersonalRecordHistory(exerciseId: Int): List<PersonalRecord>

    /* ────────── USER SETTINGS ────────── */
    @Query("SELECT * FROM user_settings LIMIT 1")
    suspend fun getUserSettings(): UserSettings?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserSettings(userSettings: UserSettings)

    @Update
    suspend fun updateUserSettings(userSettings: UserSettings)

    /* ────────── EXERCISE LIBRARY ────────── */
    @Query("SELECT * FROM exercise_library WHERE category = :category AND isActive = 1")
    suspend fun getActiveExercisesByCategory(category: String): List<ExerciseLibrary>

    @Query("SELECT * FROM exercise_library WHERE isActive = 1")
    suspend fun getAllActiveExercises(): List<ExerciseLibrary>

    @Update
    suspend fun updateExerciseLibrary(exercise: ExerciseLibrary)
}
