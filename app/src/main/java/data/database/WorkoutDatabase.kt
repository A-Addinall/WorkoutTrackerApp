package com.example.workouttracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.*

@Database(
    entities = [
        WorkoutType::class,
        Exercise::class,
        WorkoutSession::class,
        PersonalRecord::class,
        UserSettings::class,
        ExerciseLibrary::class,
        SetTracking::class
    ],
    version = 10, // Incremented to clear duplicate data
    exportSchema = false
)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao

    companion object {
        @Volatile
        private var INSTANCE: WorkoutDatabase? = null

        fun getDatabase(context: Context): WorkoutDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WorkoutDatabase::class.java,
                    "workout_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
