package com.example.workouttracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workouttracker.data.dao.WorkoutDao
import com.example.workouttracker.data.entity.Exercise
import com.example.workouttracker.data.entity.WorkoutSession
import com.example.workouttracker.data.entity.WorkoutType

@Database(
    entities = [WorkoutType::class, Exercise::class, WorkoutSession::class],
    version = 3,  // Changed from 1 to 2
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
                )
                    .fallbackToDestructiveMigration()  // Add this line
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
