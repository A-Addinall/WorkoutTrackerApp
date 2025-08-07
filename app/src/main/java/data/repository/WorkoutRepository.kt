package com.example.workouttracker.data.repository

import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.database.DatabaseInitializer
import com.example.workouttracker.data.entity.*
import com.example.workouttracker.logic.WeightSuggestionEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutRepository(private val dao: WorkoutDao) {

    private val weightSuggestionEngine = WeightSuggestionEngine()

    /* ────────── ORIGINAL METHODS ────────── */
    suspend fun initializeDatabase() = withContext(Dispatchers.IO) {
        DatabaseInitializer.initializeDatabase(dao)
    }

    suspend fun getWorkoutTypes() = withContext(Dispatchers.IO) {
        dao.getAllWorkoutTypes()
    }

    suspend fun getExercises(wtId: Int) = withContext(Dispatchers.IO) {
        dao.getExercisesByWorkoutType(wtId)
    }

    suspend fun lastSession(exId: Int) = withContext(Dispatchers.IO) {
        dao.getLastSession(exId)
    }

    suspend fun logStrength(exId: Int, sets: Int, reps: Int, wt: Double?) =
        withContext(Dispatchers.IO) {
            dao.insertWorkoutSession(
                WorkoutSession(
                    exerciseId = exId,
                    date = System.currentTimeMillis(),
                    sets = sets,
                    reps = reps,
                    weight = wt,
                    time = null
                )
            )
        }

    suspend fun logMetcon(wtId: Int, sec: Long) = withContext(Dispatchers.IO) {
        dao.insertWorkoutSession(
            WorkoutSession(
                exerciseId = -wtId,
                date = System.currentTimeMillis(),
                sets = 0,
                reps = 0,
                weight = null,
                time = sec
            )
        )
    }

    /* ────────── NEW PHASE 1 METHODS ────────── */

    // Personal Records
    suspend fun insertPersonalRecord(pr: PersonalRecord) = withContext(Dispatchers.IO) {
        dao.insertPersonalRecord(pr)
    }

    suspend fun getPersonalRecord(exerciseId: Int, type: String) = withContext(Dispatchers.IO) {
        dao.getPersonalRecord(exerciseId, type)
    }

    suspend fun getPersonalRecordHistory(exerciseId: Int) = withContext(Dispatchers.IO) {
        dao.getPersonalRecordHistory(exerciseId)
    }

    // User Settings
    suspend fun getUserSettings() = withContext(Dispatchers.IO) {
        dao.getUserSettings() ?: UserSettings() // Return default if null
    }

    suspend fun updateUserSettings(settings: UserSettings) = withContext(Dispatchers.IO) {
        dao.updateUserSettings(settings)
    }

    // Exercise Library
    suspend fun getActiveExercisesByCategory(category: String) = withContext(Dispatchers.IO) {
        dao.getActiveExercisesByCategory(category)
    }

    suspend fun getAllActiveExercises() = withContext(Dispatchers.IO) {
        dao.getAllActiveExercises()
    }

    suspend fun updateExerciseLibrary(exercise: ExerciseLibrary) = withContext(Dispatchers.IO) {
        dao.updateExerciseLibrary(exercise)
    }

    // Weight Suggestions - now needs exercise name for specific logic
    suspend fun getSuggestedWeight(exerciseId: Int): Double = withContext(Dispatchers.IO) {
        val exercise = dao.getExercisesByWorkoutType(1).find { it.id == exerciseId }
            ?: dao.getExercisesByWorkoutType(2).find { it.id == exerciseId }
            ?: dao.getExercisesByWorkoutType(3).find { it.id == exerciseId }

        val exerciseName = exercise?.name ?: "Unknown Exercise"
        val recentSets = dao.getRecentSets(exerciseId, 6)
        val userSettings = getUserSettings()

        weightSuggestionEngine.suggestWeight(exerciseId, exerciseName, recentSets, userSettings)
    }

    // Set Tracking
    suspend fun insertSetTracking(setTracking: SetTracking) = withContext(Dispatchers.IO) {
        dao.insertSetTracking(setTracking)
    }

    suspend fun getRecentSets(exerciseId: Int, limit: Int = 6) = withContext(Dispatchers.IO) {
        dao.getRecentSets(exerciseId, limit)
    }

    suspend fun getSetsForSession(sessionId: Int) = withContext(Dispatchers.IO) {
        dao.getSetsForSession(sessionId)
    }

    // Helper method to update personal records after logging sets
    suspend fun checkAndUpdatePersonalRecord(exerciseId: Int, weight: Double) = withContext(Dispatchers.IO) {
        val currentPR = dao.getPersonalRecord(exerciseId, "weight")
        if (currentPR == null || weight > currentPR.value) {
            dao.insertPersonalRecord(
                PersonalRecord(
                    exerciseId = exerciseId,
                    recordType = "weight",
                    value = weight,
                    date = System.currentTimeMillis()
                )
            )
        }
    }
}
