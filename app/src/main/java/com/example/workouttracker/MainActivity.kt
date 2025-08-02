
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
                    WorkoutSelectionScreen { day ->
                        val intent = Intent(this, WorkoutDetailActivity::class.java)
                        intent.putExtra("workout_day", day)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun WorkoutSelectionScreen(onSelect: (String) -> Unit) {
    val days = listOf("Day A - Push", "Day B - Pull", "Day C - Legs/Core")
    Column(modifier = Modifier.padding(16.dp)) {
        days.forEach { day ->
            Button(
                onClick = { onSelect(day) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(day)
            }
        }
    }
}
