package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.workouttracker.ui.WorkoutViewModel
import com.example.workouttracker.ui.WorkoutViewModelFactory
import com.example.workouttracker.ui.ExerciseLibraryActivity
import com.example.workouttracker.ui.PersonalRecordsActivity
import com.example.workouttracker.ui.SettingsActivity
import com.example.workouttracker.ui.WorkoutActivity

class MainActivity : AppCompatActivity() {

    private val workoutViewModel: WorkoutViewModel by viewModels {
        WorkoutViewModelFactory((application as WorkoutApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Workout Day Cards
        findViewById<CardView>(R.id.cardDayA).setOnClickListener {
            startWorkoutActivity(1, "Day A - Push Focus")
        }

        findViewById<CardView>(R.id.cardDayB).setOnClickListener {
            startWorkoutActivity(2, "Day B - Pull Focus")
        }

        findViewById<CardView>(R.id.cardDayC).setOnClickListener {
            startWorkoutActivity(3, "Day C - Legs/Core")
        }

        // Exercise Library
        findViewById<CardView>(R.id.cardExerciseLibrary).setOnClickListener {
            startActivity(Intent(this, ExerciseLibraryActivity::class.java))
        }

        // Personal Records
        findViewById<CardView>(R.id.cardPersonalRecords).setOnClickListener {
            startActivity(Intent(this, PersonalRecordsActivity::class.java))
        }

        // Settings
        findViewById<CardView>(R.id.cardSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun startWorkoutActivity(workoutTypeId: Int, workoutName: String) {
        val intent = Intent(this, WorkoutActivity::class.java).apply {
            putExtra("WORKOUT_TYPE_ID", workoutTypeId)
            putExtra("WORKOUT_NAME", workoutName)
        }
        startActivity(intent)
    }
}
