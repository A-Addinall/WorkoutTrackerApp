package com.example.workouttracker.data.repository

import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.database.DatabaseInitializer
import com.example.workouttracker.data.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkoutRepository(private val dao: WorkoutDao) {

    suspend fun initializeDatabase() = withContext(Dispatchers.IO) {
        DatabaseInitializer.initializeDatabase(dao)
    }

    /* ── lists ────────────────────────────────────────────────────────── */
    suspend fun getWorkoutTypes() = withContext(Dispatchers.IO) { dao.getAllWorkoutTypes() }
    suspend fun getExercises(wtId: Int) = withContext(Dispatchers.IO) { dao.getExercisesByWorkoutType(wtId) }

    /* ── logging ──────────────────────────────────────────────────────── */
    suspend fun logStrength(exId: Int, sets: Int, reps: Int, wt: Double?) =
        withContext(Dispatchers.IO) {
            dao.insertWorkoutSession(
                WorkoutSession(exerciseId = exId, date = now(),
                    sets = sets, reps = reps, weight = wt, time = null)
            )
        }

    suspend fun logMetcon(wtId: Int, sec: Long) =
        withContext(Dispatchers.IO) {
            dao.insertWorkoutSession(
                WorkoutSession(exerciseId = -wtId, date = now(),
                    sets = 0, reps = 0, weight = null, time = sec)
            )
        }

    /* ── last values ──────────────────────────────────────────────────── */
    suspend fun lastSession(exId: Int) = withContext(Dispatchers.IO) { dao.getLastSession(exId) }

    private fun now() = System.currentTimeMillis()
}
