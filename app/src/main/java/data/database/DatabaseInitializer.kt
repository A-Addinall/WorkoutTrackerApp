package com.example.workouttracker.data.database

import kotlinx.coroutines.runBlocking
import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.*

class DatabaseInitializer {

    fun initializeDatabase(dao: WorkoutDao) {
        runBlocking {
            // Initialize Workout Types
            val workoutTypeCount = dao.getWorkoutTypeCount()
            if (workoutTypeCount == 0) {
                val workoutTypes = listOf(
                    WorkoutType(1, "Day 1", "Upper body strength training"),
                    WorkoutType(2, "Day 2", "Lower body strength training"),
                    WorkoutType(3, "Day 3", "Full body and conditioning")
                )
                workoutTypes.forEach { workoutType ->
                    dao.insertWorkoutType(workoutType)
                }
            }

// Updated exercise list with distinct names:
            val exercisesList = listOf(
                // Day A exercises
                Exercise(0, 1, "Barbell Bench Press", "Strength", "5-8 reps"),
                Exercise(0, 1, "Overhead Press - Barbell", "Strength", "5-8 reps"),
                Exercise(0, 1, "Dumbbell Incline Press", "Strength", "8-12 reps"),
                Exercise(0, 1, "Lateral Raise", "Strength", "12-15 reps"),
                Exercise(0, 1, "Close-Grip Bench Press", "Strength", "6-10 reps"),
                Exercise(0, 1, "Wall Walks - Strength", "Strength", "3-5 reps or 30-60s"), // ← RENAMED
                Exercise(0, 1, "Assault Bike", "Metcon", "20/15 cal"),
                Exercise(0, 1, "Wall Walks - Metcon", "Metcon", "4 reps"), // ← RENAMED
                Exercise(0, 1, "Kettlebell Swings (Russian)", "Metcon", "16 reps"),
                Exercise(0, 1, "Dumbbell Push Press", "Metcon", "10 reps each arm"),

                // Day B exercises (no changes needed)
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
                Exercise(0, 3, "Landmine Rotations - Strength", "Strength", "10-15 reps per side"), // ← RENAMED
                Exercise(0, 3, "Landmine Rotations - Metcon", "Metcon", "10 reps each side"), // ← RENAMED
                Exercise(0, 3, "Walking Lunges", "Metcon", "20m"),
                Exercise(0, 3, "KB Goblet Squats", "Metcon", "12 reps"),
                Exercise(0, 3, "V-ups or Ab Wheel Rollouts", "Metcon", "10 reps"),
                Exercise(0, 3, "Assault Bike Sprint", "Metcon", "250m")
            )


            dao.insertExercises(exercisesList)

            // Initialize User Settings
            val userSettings = dao.getUserSettings()
            if (userSettings == null) {
                val defaultSettings = UserSettings(
                    id = 1,
                    darkTheme = false,
                    autoWeightIncrement = 2.5,
                    defaultRestTime = 120,
                    units = "kg"
                )
                dao.insertUserSettings(defaultSettings)
            }

            // Initialize Exercise Library
            val exerciseLibraryCount = dao.getExerciseLibraryCount()
            if (exerciseLibraryCount == 0) {
                val exerciseLibraryList = listOf(
                    ExerciseLibrary(
                        id = 0,
                        name = "Bench Press",
                        category = "Chest",
                        muscleGroups = "Chest, Triceps, Front Delts",
                        equipment = "Barbell, Bench",
                        difficulty = "Intermediate",
                        instructions = "Lie on bench, grip bar slightly wider than shoulder width, lower to chest, press up",
                        isActive = true,
                        isDefault = true
                    ),
                    ExerciseLibrary(
                        id = 0,
                        name = "Squat",
                        category = "Legs",
                        muscleGroups = "Quadriceps, Glutes, Core",
                        equipment = "Barbell, Squat Rack",
                        difficulty = "Intermediate",
                        instructions = "Stand with feet shoulder width, descend by pushing hips back, drive through heels",
                        isActive = true,
                        isDefault = true
                    ),
                    ExerciseLibrary(
                        id = 0,
                        name = "Deadlift",
                        category = "Back",
                        muscleGroups = "Hamstrings, Glutes, Back, Traps",
                        equipment = "Barbell",
                        difficulty = "Advanced",
                        instructions = "Hip hinge movement, keep bar close to body, drive hips forward",
                        isActive = true,
                        isDefault = true
                    ),
                    ExerciseLibrary(
                        id = 0,
                        name = "Thrusters",
                        category = "Full Body",
                        muscleGroups = "Legs, Shoulders, Core",
                        equipment = "Dumbbells or Barbell",
                        difficulty = "Intermediate",
                        instructions = "Front squat into overhead press, fluid movement",
                        isActive = true,
                        isDefault = true
                    )
                )

                exerciseLibraryList.forEach { exerciseLibrary ->
                    dao.insertExerciseLibrary(exerciseLibrary)
                }
            }
        }
    }
}
