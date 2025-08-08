package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.workouttracker.ui.SettingsActivity
import com.example.workouttracker.ui.AnalyticsActivity
import com.example.workouttracker.ui.WorkoutActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWorkoutCards()
        setupProgressCards()
        setupSettingsCard()
        setupExerciseLibraryCard()
    }

    private fun setupWorkoutCards() {
        // Day A - Push Focus
        findViewById<CardView>(R.id.cardDayA).setOnClickListener {
            startWorkoutActivity(1, "Day A - Push Focus")
        }

        // Day B - Pull Focus
        findViewById<CardView>(R.id.cardDayB).setOnClickListener {
            startWorkoutActivity(2, "Day B - Pull Focus")
        }

        // Day C - Legs/Core
        findViewById<CardView>(R.id.cardDayC).setOnClickListener {
            startWorkoutActivity(3, "Day C - Legs/Core")
        }
    }

    private fun setupProgressCards() {
        // Personal Records - This will open Analytics for now
        findViewById<CardView>(R.id.cardPersonalRecords).setOnClickListener {
            startActivity(Intent(this, AnalyticsActivity::class.java))
        }
    }

    private fun setupSettingsCard() {
        // Settings
        findViewById<CardView>(R.id.cardSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun setupExerciseLibraryCard() {
        // Exercise Library - Placeholder for future feature
        findViewById<CardView>(R.id.cardExerciseLibrary).setOnClickListener {
            // TODO: Implement Exercise Library Activity
            // For now, we can show a simple message
            android.widget.Toast.makeText(
                this,
                "Exercise Library coming soon!",
                android.widget.Toast.LENGTH_SHORT
            ).show()
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
