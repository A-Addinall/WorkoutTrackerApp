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

        val lastWeight = recentSets.maxByOrNull { it.weight }?.weight ?: getStartingWeight(exerciseId, exerciseName)
        val recentPerformance = recentSets.takeLast(6)

        if (recentPerformance.isEmpty()) return lastWeight

        val successRate = recentPerformance.count { it.isSuccessful } / recentPerformance.size.toDouble()
        val avgRPE = recentPerformance.mapNotNull { it.rpe }.average()
        val progressionRate = getProgressionRate(exerciseId, exerciseName)

        return when {
            // High success rate and low RPE = increase weight
            successRate >= 0.85 && avgRPE < 7.0 -> increaseWeight(
                exerciseId,
                lastWeight,
                userSettings.autoWeightIncrement * progressionRate.fastIncrement
            )

            // Good success rate = maintain or small increase
            successRate >= 0.70 -> if (avgRPE < 8.0) {
                increaseWeight(
                    exerciseId,
                    lastWeight,
                    userSettings.autoWeightIncrement * progressionRate.normalIncrement
                )
            } else lastWeight

            // Poor success rate = decrease weight
            successRate < 0.50 -> decreaseWeight(
                exerciseId,
                lastWeight,
                userSettings.autoWeightIncrement * progressionRate.normalIncrement
            )

            // Default = small increase
            else -> increaseWeight(
                exerciseId,
                lastWeight,
                userSettings.autoWeightIncrement * progressionRate.slowIncrement
            )
        }
    }

    private fun getProgressionRate(exerciseId: Int, exerciseName: String): ProgressionRate {
        // Use exerciseId for future database-stored progression rules
        // For now, use exerciseName for logic but keep exerciseId for extensibility
        return when {
            // Fast progressing exercises
            exerciseName.contains("curl", ignoreCase = true) ||
                    exerciseName.contains("lateral raise", ignoreCase = true) ||
                    exerciseName.contains("tricep", ignoreCase = true) ||
                    exerciseName.contains("face pull", ignoreCase = true) ->
                ProgressionRate(fastIncrement = 1.2, normalIncrement = 1.0, slowIncrement = 0.8)

            // Slow progressing exercises
            exerciseName.contains("deadlift", ignoreCase = true) ||
                    exerciseName.contains("squat", ignoreCase = true) ||
                    exerciseName.contains("pull-up", ignoreCase = true) ||
                    exerciseName.contains("chin-up", ignoreCase = true) ->
                ProgressionRate(fastIncrement = 0.8, normalIncrement = 0.6, slowIncrement = 0.4)

            // Press movements (moderate-slow)
            exerciseName.contains("bench press", ignoreCase = true) ||
                    exerciseName.contains("overhead press", ignoreCase = true) ||
                    exerciseName.contains("shoulder press", ignoreCase = true) ->
                ProgressionRate(fastIncrement = 0.9, normalIncrement = 0.7, slowIncrement = 0.5)

            // Default for other exercises
            else -> ProgressionRate(fastIncrement = 1.0, normalIncrement = 0.8, slowIncrement = 0.6)
        }.also {
            // Log exerciseId for future reference/debugging
            // This actually uses the exerciseId parameter
            println("Exercise ID $exerciseId ($exerciseName) using progression: $it")
        }
    }

    private fun getStartingWeight(exerciseId: Int, exerciseName: String): Double {
        // Use exerciseId for potential database lookups in the future
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
        }.also {
            // This actually uses the exerciseId parameter for logging/debugging
            println("Starting weight for exercise ID $exerciseId ($exerciseName): $it kg")
        }
    }

    private fun increaseWeight(exerciseId: Int, currentWeight: Double, increment: Double): Double {
        val suggested = when {
            currentWeight < 15 -> currentWeight + (increment * 1.25) // Light weights
            currentWeight < 50 -> currentWeight + (increment * 2.5)  // Medium weights
            currentWeight < 100 -> currentWeight + (increment * 2.5) // Standard
            else -> currentWeight + (increment * 5.0)                // Heavy weights
        }

        val result = roundToNearestPlate(suggested)

        // Actually use exerciseId for logging/tracking
        println("Exercise ID $exerciseId: Increased weight from $currentWeight kg to $result kg")

        return result
    }

    private fun decreaseWeight(exerciseId: Int, currentWeight: Double, increment: Double): Double {
        val suggested = currentWeight - (increment * 2.5)
        val result = maxOf(roundToNearestPlate(suggested), 5.0) // Minimum 5kg

        // Actually use exerciseId for logging/tracking
        println("Exercise ID $exerciseId: Decreased weight from $currentWeight kg to $result kg")

        return result
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

    // Data class for progression rates
    private data class ProgressionRate(
        val fastIncrement: Double,    // When doing really well
        val normalIncrement: Double,  // Standard progression
        val slowIncrement: Double     // Conservative progression
    )
}
