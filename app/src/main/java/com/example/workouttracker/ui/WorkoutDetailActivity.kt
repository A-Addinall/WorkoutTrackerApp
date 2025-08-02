
package com.example.workouttracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workouttracker.ui.theme.WorkoutTrackerTheme

class WorkoutDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val day = intent.getStringExtra("workout_day") ?: "Unknown"
        setContent {
            WorkoutTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WorkoutDetailScreen(day)
                }
            }
        }
    }
}

@Composable
fun WorkoutDetailScreen(day: String) {
    val sampleData = listOf(
        "Barbell Bench Press" to "80kg",
        "Overhead Press" to "50kg",
        "Metcon: Bike + Wall Walks" to "9:45"
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Workout: $day", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        sampleData.forEach { (exercise, maxValue) ->
            Text("$exercise — Max: $maxValue", modifier = Modifier.padding(vertical = 4.dp))
        }
    }
}
