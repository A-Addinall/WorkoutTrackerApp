package com.example.workouttracker.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workouttracker.MainActivity
import com.example.workouttracker.ui.theme.WorkoutTrackerTheme

class WorkoutDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = intent.getStringExtra("workout_type") ?: "Unknown"
        val mode = intent.getStringExtra("workout_mode") ?: "Unknown"

        setContent {
            WorkoutTrackerTheme {
                WorkoutDetailScreen(
                    type = type,
                    mode = mode,
                    onBack = { finish() },
                    onHome = {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutDetailScreen(
    type: String,
    mode: String,
    onBack: () -> Unit,
    onHome: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$type — $mode Workout") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onHome) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }
                }
            )
        }
    ) { innerPadding ->
        WorkoutDetailContent(
            type = type,
            mode = mode,
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        )
    }
}

@Composable
fun WorkoutDetailContent(type: String, mode: String, modifier: Modifier = Modifier) {
    val sampleData = when (mode) {
        "Strength" -> listOf(
            "Barbell Bench Press" to "80kg",
            "Overhead Press" to "50kg"
        )
        "Metcon" -> listOf(
            "Bike Sprints + Wall Walks" to "9:45",
            "Row Intervals" to "12:30"
        )
        else -> emptyList()
    }

    Column(modifier = modifier) {
        sampleData.forEach { (exercise, metric) ->
            Text(
                text = "$exercise — ${if (mode == "Strength") "Max: $metric" else "Time: $metric"}",
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
