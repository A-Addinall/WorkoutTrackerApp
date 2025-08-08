package com.example.workouttracker.logic

import com.example.workouttracker.data.entity.SetTracking
import com.example.workouttracker.data.entity.UserSettings
import kotlin.math.roundToInt

class WeightSuggestionEngine {

    fun suggestWeight(
        exerciseId: Int,
        exerciseName: String,
        recentSets: List<SetTracking>,
        userSettings: UserSettings
    ): Double {
        if (recentSets.isEmpty()) return getStartingWeight(exerciseId, exerciseName)

        // Find the last successful lift
        val lastSuccessfulSet = recentSets
            .filter { it.isSuccessful } // Only successful lifts
            .maxByOrNull { it.weight }   // Get the heaviest successful lift

        return if (lastSuccessfulSet != null) {
            // Simple progression: last successful weight + 2.5kg
            val suggested = lastSuccessfulSet.weight + 2.5
            roundToNearestPlate(suggested)
        } else {
            // No successful lifts found, use starting weight
            getStartingWeight(exerciseId, exerciseName)
        }
    }

    private fun getStartingWeight(exerciseId: Int, exerciseName: String): Double {
        return when {
            exerciseName.contains("curl", ignoreCase = true) -> 10.0
            exerciseName.contains("lateral raise", ignoreCase = true) -> 7.5
            exerciseName.contains("tricep", ignoreCase = true) -> 12.5
            exerciseName.contains("bench press", ignoreCase = true) -> 40.0
            exerciseName.contains("squat", ignoreCase = true) -> 40.0
            exerciseName.contains("deadlift", ignoreCase = true) -> 50.0
            exerciseName.contains("overhead press", ignoreCase = true) -> 30.0
            exerciseName.contains("row", ignoreCase = true) -> 30.0
            else -> 20.0 // Generic starting weight
        }
    }

    private fun roundToNearestPlate(weight: Double): Double {
        // Round to nearest 1.25kg (standard plate increment)
        return (weight * 4).roundToInt() / 4.0
    }

    fun calculateOneRepMax(weight: Double, reps: Int): Double {
        // Brzycki formula: 1RM = weight / (1.0278 - 0.0278 * reps)
        if (reps <= 1) return weight
        return weight / (1.0278 - 0.0278 * reps)
    }
}
