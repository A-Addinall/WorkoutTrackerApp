package com.example.workouttracker.data.repository

import androidx.lifecycle.LiveData
import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.*
import com.example.workouttracker.logic.WeightSuggestionEngine

class WorkoutRepository(private val dao: WorkoutDao) {

    private val weightSuggestionEngine = WeightSuggestionEngine()

    // Smart weight suggestion using your WeightSuggestionEngine
    suspend fun getSuggestedWeight(exerciseId: Int): Double? {
        return try {
            val exercise = dao.getExerciseById(exerciseId)
            // Use SetTracking data directly for real success/failure data
            val recentSets = dao.getRecentSets(exerciseId, 10)
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

    // Main logStrength method with success/failure tracking
    suspend fun logStrength(
        exerciseId: Int,
        sets: Int,
        reps: Int,
        weight: Double?,
        isSuccessful: Boolean,
        rpe: Double = 7.0,
        notes: String? = null
    ): Long {
        val session = WorkoutSession(
            exerciseId = exerciseId,
            date = System.currentTimeMillis(),
            sets = sets,
            reps = reps,
            weight = weight,
            time = null,
            notes = notes
        )
        val sessionId = dao.insertWorkoutSession(session)

        // Also create SetTracking record with success/failure data
        val setTracking = SetTracking(
            id = 0,
            workoutSessionId = sessionId.toInt(),
            exerciseId = exerciseId,
            setNumber = 1,
            targetReps = reps,
            actualReps = reps,
            weight = weight ?: 0.0,
            isSuccessful = isSuccessful,
            rpe = rpe
        )
        dao.insertSetTracking(setTracking)

        return sessionId
    }

    // Overloaded method for backward compatibility
    suspend fun logStrength(exerciseId: Int, sets: Int, reps: Int, weight: Double?): Long {
        return logStrength(exerciseId, sets, reps, weight, true, 7.0, null)
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

    suspend fun getLastSuccessfulWeight(exerciseId: Int): Double? {
        // Get recent successful sets and find the heaviest one
        val successfulSets = dao.getRecentSets(exerciseId, 20) // Get more sets to find successes
            .filter { it.isSuccessful } // Only successful lifts

        return successfulSets.maxByOrNull { it.weight }?.weight
    }

    // Also add a LiveData version for real-time updates:
    fun getLastSuccessfulWeightLiveData(exerciseId: Int): LiveData<Double?> {
        // We'll need to add this to the DAO as well
        return dao.getLastSuccessfulWeightLiveData(exerciseId)
    }

    suspend fun getRecentPersonalRecords(limit: Int = 10): List<PersonalRecord> {
        // You'll need to add this method to your DAO first
        return dao.getRecentPersonalRecords(limit)
    }

    suspend fun getAllPersonalRecords(): List<PersonalRecord> {
        return dao.getAllPersonalRecords()
    }
}
