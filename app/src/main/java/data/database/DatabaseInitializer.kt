package com.example.workouttracker.data.database

import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.Exercise
import com.example.workouttracker.data.entity.WorkoutType

class DatabaseInitializer {
    companion object {
        fun initializeDatabase(dao: WorkoutDao) {
            // Check if data already exists
            val count = dao.getWorkoutTypeCount()
            if (count > 0) return

            // Insert workout types
            val workoutTypes = listOf(
                WorkoutType(1, "Day A - Push Focus", "Upper body pushing movements and shoulders"),
                WorkoutType(2, "Day B - Pull Focus", "Upper body pulling movements and back"),
                WorkoutType(3, "Day C - Legs/Core + Landmine", "Lower body, core, and landmine exercises")
            )

            workoutTypes.forEach { dao.insertWorkoutType(it) }

            // Insert all exercises
            val allExercises = listOf(
                // Day A exercises
                Exercise(0, 1, "Barbell Bench Press", "Strength", "5-8 reps"),
                Exercise(0, 1, "Overhead Press - Barbell", "Strength", "5-8 reps"),
                Exercise(0, 1, "Dumbbell Incline Press", "Strength", "8-12 reps"),
                Exercise(0, 1, "Lateral Raise", "Strength", "12-15 reps"),
                Exercise(0, 1, "Close-Grip Bench Press", "Strength", "6-10 reps"),
                Exercise(0, 1, "Wall Walks", "Strength", "3-5 reps or 30-60s"),
                Exercise(0, 1, "Assault Bike", "Metcon", "20/15 cal"),
                Exercise(0, 1, "Wall Walks", "Metcon", "4 reps"),
                Exercise(0, 1, "Kettlebell Swings (Russian)", "Metcon", "16 reps"),
                Exercise(0, 1, "Dumbbell Push Press", "Metcon", "10 reps each arm"),

                // Day B exercises
                Exercise(0, 2, "Barbell Row", "Strength", "6-10 reps"),
                Exercise(0, 2, "Pull-ups/Chin-ups", "Strength", "6-10 reps or AMRAP"),
                Exercise(0, 2, "One-arm Dumbbell Row", "Strength", "8-12 reps"),
                Exercise(0, 2, "Barbell or Dumbbell Curl", "Strength", "10-15 reps"),
                Exercise(0, 2, "Face Pulls", "Strength", "12-20 reps"),
                Exercise(0, 2, "400m Run", "Metcon", "400m or 0.5km bike"),
                Exercise(0, 2, "One-arm KB Rows", "Metcon", "12 reps each side"),
                Exercise(0, 2, "KB Swings (full)", "Metcon", "16 reps"),
                Exercise(0, 2, "Burpees", "Metcon", "10 reps"),
                Exercise(0, 2, "Plank", "Metcon", "30s"),

                // Day C exercises
                Exercise(0, 3, "Barbell Back Squat", "Strength", "5-8 reps"),
                Exercise(0, 3, "Romanian Deadlift", "Strength", "6-10 reps"),
                Exercise(0, 3, "Bulgarian Split Squat", "Strength", "8-12 reps"),
                Exercise(0, 3, "Calf Raise", "Strength", "12-20 reps"),
                Exercise(0, 3, "Ab Wheel/Plank", "Strength", "8-10 reps or 30-60s"),
                Exercise(0, 3, "Landmine Press", "Strength", "6-10 reps"),
                Exercise(0, 3, "Landmine Rotations", "Strength", "10-15 reps per side"),
                Exercise(0, 3, "Landmine Rotations", "Metcon", "10 reps each side"),
                Exercise(0, 3, "Walking Lunges", "Metcon", "20m"),
                Exercise(0, 3, "KB Goblet Squats", "Metcon", "12 reps"),
                Exercise(0, 3, "V-ups or Ab Wheel Rollouts", "Metcon", "10 reps"),
                Exercise(0, 3, "Assault Bike Sprint", "Metcon", "250m")
            )

            dao.insertExercises(allExercises)
        }
    }
}
