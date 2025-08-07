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
                    WorkoutType(1, "Day A", "Upper body strength training"),
                    WorkoutType(2, "Day B", "Lower body strength training"),
                    WorkoutType(3, "Day C", "Full body and conditioning")
                )
                workoutTypes.forEach { workoutType ->
                    dao.insertWorkoutType(workoutType)
                }
            }

            // Initialize Exercises for each workout type
            val exercisesList = listOf(
                // Day A Exercises
                Exercise(0, 1, "Bench Press", "Strength", "3-5 reps", "Chest compound movement"),
                Exercise(0, 1, "Overhead Press", "Strength", "3-5 reps", "Shoulder compound movement"),
                Exercise(0, 1, "Barbell Rows", "Strength", "3-5 reps", "Back compound movement"),
                Exercise(0, 1, "Dips", "Strength", "8-12 reps", "Triceps accessory"),
                Exercise(0, 1, "Chin-ups", "Strength", "5-10 reps", "Back accessory"),

                // Day B Exercises
                Exercise(0, 2, "Squat", "Strength", "3-5 reps", "Leg compound movement"),
                Exercise(0, 2, "Deadlift", "Strength", "1-5 reps", "Posterior chain compound"),
                Exercise(0, 2, "Romanian Deadlift", "Strength", "8-12 reps", "Hamstring accessory"),
                Exercise(0, 2, "Bulgarian Split Squat", "Strength", "8-12 reps", "Unilateral leg work"),
                Exercise(0, 2, "Walking Lunges", "Strength", "10-15 reps", "Leg accessory"),

                // Day C Exercises
                Exercise(0, 3, "Thrusters", "Metcon", "AMRAP", "Full body conditioning"),
                Exercise(0, 3, "Burpees", "Metcon", "AMRAP", "Full body cardio"),
                Exercise(0, 3, "Kettlebell Swings", "Metcon", "EMOM", "Hip hinge conditioning"),
                Exercise(0, 3, "Mountain Climbers", "Metcon", "Tabata", "Core conditioning"),
                Exercise(0, 3, "Push-up to T", "Metcon", "AMRAP", "Upper body conditioning")
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
