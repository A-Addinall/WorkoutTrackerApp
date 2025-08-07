package com.example.workouttracker.data.repository

import androidx.lifecycle.LiveData
import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.*
import com.example.workouttracker.data.database.DatabaseInitializer
import com.example.workouttracker.logic.WeightSuggestionEngine

class WorkoutRepository(private val dao: WorkoutDao) {

    // Remove this initialization:
    // private val databaseInitializer = DatabaseInitializer()
    // init {
    //     databaseInitializer.initializeDatabase(dao)
    // }

    // Keep everything else the same...
    private val weightSuggestionEngine = WeightSuggestionEngine()


    // Smart weight suggestion using your WeightSuggestionEngine
    suspend fun getSuggestedWeight(exerciseId: Int): Double? {
        return try {
            // Get exercise details
            val exercise = dao.getExerciseById(exerciseId)

            // Get recent WorkoutSession data instead of SetTracking
            val recentSessions = dao.getRecentWorkoutSessions(exerciseId, 10)

            // Convert WorkoutSession to SetTracking format for the engine
            val recentSets = recentSessions.mapNotNull { session ->
                session.weight?.let { weight ->
                    SetTracking(
                        id = 0,
                        workoutSessionId = session.id,
                        exerciseId = session.exerciseId,
                        setNumber = 1,
                        targetReps = session.reps,
                        actualReps = session.reps,
                        weight = weight,
                        isSuccessful = true, // Assume successful for now
                        rpe = 7 // Default RPE value
                    )
                }
            }

            val userSettings = dao.getUserSettings() ?: getDefaultUserSettings()

            weightSuggestionEngine.suggestWeight(
                exerciseId = exerciseId,
                exerciseName = exercise?.name ?: "",
                recentSets = recentSets,
                userSettings = userSettings
            )
        } catch (e: Exception) {
            // Fallback to simple last weight
            dao.getLastWeightForExercise(exerciseId)
        }
    }

    private fun getDefaultUserSettings(): UserSettings {
        return UserSettings(
            id = 1,
            darkTheme = false,
            autoWeightIncrement = 2.5,
            defaultRestTime = 120,
            units = "kg"
        )
    }

    suspend fun getWorkoutTypes(): List<WorkoutType> {
        return dao.getAllWorkoutTypes()
    }

    suspend fun getExercises(workoutTypeId: Int): List<Exercise> {
        return dao.getExercisesByWorkoutType(workoutTypeId)
    }

    suspend fun lastSession(exerciseId: Int): WorkoutSession? {
        return dao.getLastSession(exerciseId)
    }

    fun getLastWeightLiveData(exerciseId: Int): LiveData<Double?> {
        return dao.getLastWeightForExerciseLiveData(exerciseId)
    }

    suspend fun logStrength(exerciseId: Int, sets: Int, reps: Int, weight: Double?, notes: String? = null): Long {
        val session = WorkoutSession(
            exerciseId = exerciseId,
            date = System.currentTimeMillis(),
            sets = sets,
            reps = reps,
            weight = weight,
            time = null,
            notes = notes
        )
        return dao.insertWorkoutSession(session)
    }

    suspend fun logMetcon(exerciseId: Int, timeInSeconds: Long, notes: String? = null): Long {
        val session = WorkoutSession(
            exerciseId = exerciseId,
            date = System.currentTimeMillis(),
            sets = 1,
            reps = 0,
            weight = null,
            time = timeInSeconds,
            notes = notes
        )
        return dao.insertWorkoutSession(session)
    }

    suspend fun getLastMetconTime(exerciseId: Int): Long? {
        return dao.getLastMetconTime(exerciseId)
    }

    fun getLastMetconTimeLiveData(exerciseId: Int): LiveData<Long> {
        return dao.getLastMetconTimeLiveData(exerciseId)
    }

    suspend fun insertWorkoutSession(session: WorkoutSession): Long {
        return dao.insertWorkoutSession(session)
    }

    suspend fun insertSetTracking(setTracking: SetTracking) {
        dao.insertSetTracking(setTracking)
    }

    suspend fun getRecentSets(exerciseId: Int, limit: Int): List<SetTracking> {
        return dao.getRecentSets(exerciseId, limit)
    }

    suspend fun insertPersonalRecord(personalRecord: PersonalRecord) {
        dao.insertPersonalRecord(personalRecord)
    }

    suspend fun getPersonalRecord(exerciseId: Int, type: String): PersonalRecord? {
        return dao.getPersonalRecord(exerciseId, type)
    }

    suspend fun getUserSettings(): UserSettings? {
        return dao.getUserSettings()
    }

    suspend fun insertUserSettings(userSettings: UserSettings) {
        dao.insertUserSettings(userSettings)
    }

    suspend fun updateUserSettings(userSettings: UserSettings) {
        dao.updateUserSettings(userSettings)
    }

    suspend fun getActiveExercisesByCategory(category: String): List<ExerciseLibrary> {
        return dao.getActiveExercisesByCategory(category)
    }

    suspend fun getAllActiveExercises(): List<ExerciseLibrary> {
        return dao.getAllActiveExercises()
    }
}
