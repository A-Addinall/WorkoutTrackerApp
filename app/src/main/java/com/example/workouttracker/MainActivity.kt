package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workouttracker.ui.WorkoutDetailActivity
import com.example.workouttracker.ui.theme.WorkoutTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WorkoutSelectionScreen { type, mode ->
                        val intent = Intent(this, WorkoutDetailActivity::class.java).apply {
                            putExtra("workout_type", type)
                            putExtra("workout_mode", mode)
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun WorkoutSelectionScreen(onNavigate: (String, String) -> Unit) {
    val workouts = listOf("Push", "Pull", "Legs/Core")
    Column(modifier = Modifier.padding(16.dp)) {
        workouts.forEach { type ->
            WorkoutCard(type = type, onNavigate = onNavigate)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun WorkoutCard(type: String, onNavigate: (String, String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "$type Workout", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { onNavigate(type, "Strength") }) {
                    Text("Strength")
                }
                Button(onClick = { onNavigate(type, "Metcon") }) {
                    Text("Metcon")
                }
            }
        }
    }
}
