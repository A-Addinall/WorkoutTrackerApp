package com.example.workouttracker.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.workouttracker.MainActivity
import com.example.workouttracker.ui.theme.WorkoutTrackerTheme
import com.example.workouttracker.viewmodel.WorkoutViewModel

class WorkoutDetailActivity : ComponentActivity() {
    private val viewModel: WorkoutViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = intent.getStringExtra("workout_type") ?: "Unknown"
        val category = intent.getStringExtra("workout_category") ?: "Unknown"

        setContent {
            WorkoutTrackerTheme {
                WorkoutDetailScreen(
                    type = type,
                    category = category,
                    viewModel = viewModel,
                    onBack = { finish() },
                    onHome = {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                )
            }
        }
    }
}
