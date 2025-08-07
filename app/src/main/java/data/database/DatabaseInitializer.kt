package com.example.workouttracker.data.database

import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.*

class DatabaseInitializer {
    companion object {
        fun initializeDatabase(dao: WorkoutDao) {
            // Initialize original workout data
            initializeWorkoutTypes(dao)

            // Initialize new Phase 1 data
            initializeUserSettings(dao)
            initializeExerciseLibrary(dao)
        }

        private fun initializeWorkoutTypes(dao: WorkoutDao) {
            val count = dao.getWorkoutTypeCount()
            if (count > 0) return

            // Original workout types
            val workoutTypes = listOf(
                WorkoutType(1, "Day A - Push Focus", "Upper body pushing movements and shoulders"),
                WorkoutType(2, "Day B - Pull Focus", "Upper body pulling movements and back"),
                WorkoutType(3, "Day C - Legs/Core + Landmine", "Lower body, core, and landmine exercises")
            )
            workoutTypes.forEach { dao.insertWorkoutType(it) }

            // Original exercises (keeping your existing data)
            val exercises = listOf(
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
            dao.insertExercises(exercises)
        }

        private fun initializeUserSettings(dao: WorkoutDao) {
            if (dao.getUserSettings() == null) {
                dao.insertUserSettings(UserSettings())
            }
        }

        private fun initializeExerciseLibrary(dao: WorkoutDao) {
            val count = dao.getExerciseLibraryCount()
            if (count > 0) return

            val exerciseLibrary = listOf(
                // Upper Push
                ExerciseLibrary(0, "Barbell Bench Press", "Strength", "[\"chest\",\"shoulders\",\"triceps\"]", "barbell", 3, "Lie flat, grip bar wider than shoulders, press up", true, true),
                ExerciseLibrary(0, "Overhead Press", "Strength", "[\"shoulders\",\"triceps\",\"core\"]", "barbell", 4, "Stand tall, press bar overhead", true, true),
                ExerciseLibrary(0, "Dumbbell Bench Press", "Strength", "[\"chest\",\"shoulders\",\"triceps\"]", "dumbbell", 2, "Same as barbell but with dumbbells", true, true),
                ExerciseLibrary(0, "Push-ups", "Strength", "[\"chest\",\"shoulders\",\"triceps\"]", "bodyweight", 1, "Standard push-up form", true, true),
                ExerciseLibrary(0, "Dips", "Strength", "[\"chest\",\"shoulders\",\"triceps\"]", "bodyweight", 3, "Parallel bars or rings", true, true),

                // Upper Pull
                ExerciseLibrary(0, "Pull-ups", "Strength", "[\"back\",\"biceps\"]", "bodyweight", 4, "Overhand grip, full range", true, true),
                ExerciseLibrary(0, "Chin-ups", "Strength", "[\"back\",\"biceps\"]", "bodyweight", 3, "Underhand grip", true, true),
                ExerciseLibrary(0, "Barbell Row", "Strength", "[\"back\",\"biceps\"]", "barbell", 3, "Bent over, pull to chest", true, true),
                ExerciseLibrary(0, "Dumbbell Row", "Strength", "[\"back\",\"biceps\"]", "dumbbell", 2, "Single arm or both arms", true, true),
                ExerciseLibrary(0, "Face Pulls", "Strength", "[\"rear_delts\",\"upper_back\"]", "cable", 2, "Pull to face level", true, true),

                // Lower Body
                ExerciseLibrary(0, "Back Squat", "Strength", "[\"quads\",\"glutes\",\"core\"]", "barbell", 4, "Bar on upper back, squat down", true, true),
                ExerciseLibrary(0, "Front Squat", "Strength", "[\"quads\",\"glutes\",\"core\"]", "barbell", 4, "Bar on front shoulders", true, true),
                ExerciseLibrary(0, "Deadlift", "Strength", "[\"hamstrings\",\"glutes\",\"back\"]", "barbell", 5, "Hip hinge movement", true, true),
                ExerciseLibrary(0, "Romanian Deadlift", "Strength", "[\"hamstrings\",\"glutes\"]", "barbell", 3, "Stiff leg deadlift", true, true),
                ExerciseLibrary(0, "Lunges", "Strength", "[\"quads\",\"glutes\"]", "bodyweight", 2, "Step forward, lower knee", true, true),

                // Accessories
                ExerciseLibrary(0, "Bicep Curls", "Accessory", "[\"biceps\"]", "dumbbell", 1, "Curl weight to shoulders", true, true),
                ExerciseLibrary(0, "Tricep Extensions", "Accessory", "[\"triceps\"]", "dumbbell", 2, "Extend weight overhead", true, true),
                ExerciseLibrary(0, "Lateral Raises", "Accessory", "[\"shoulders\"]", "dumbbell", 2, "Raise arms to sides", true, true),
                ExerciseLibrary(0, "Calf Raises", "Accessory", "[\"calves\"]", "bodyweight", 1, "Rise up on toes", true, true),

                // Metcon/Cardio
                ExerciseLibrary(0, "Burpees", "Metcon", "[\"full_body\"]", "bodyweight", 3, "Drop, jump back, push-up, jump up", true, true),
                ExerciseLibrary(0, "Mountain Climbers", "Metcon", "[\"core\",\"cardio\"]", "bodyweight", 2, "Plank position, alternate knees", true, true),
                ExerciseLibrary(0, "Kettlebell Swings", "Metcon", "[\"glutes\",\"core\",\"cardio\"]", "kettlebell", 2, "Hip hinge swing", true, true),
                ExerciseLibrary(0, "Box Jumps", "Metcon", "[\"legs\",\"power\"]", "box", 3, "Jump onto box, step down", true, true)
            )

            dao.insertExerciseLibrary(exerciseLibrary)
        }
    }
}
