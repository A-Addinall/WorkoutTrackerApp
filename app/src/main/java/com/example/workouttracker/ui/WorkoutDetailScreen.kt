package com.example.workouttracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workouttracker.viewmodel.WorkoutViewModel
import com.example.workouttracker.data.WorkoutEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutDetailScreen(
    type: String,
    category: String,
    viewModel: WorkoutViewModel,
    onBack: () -> Unit = {},
    onHome: () -> Unit = {}
) {
    val entries by viewModel.allWorkouts.collectAsState(initial = emptyList())
    var exercise by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$type — $category") },
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
    ) { padding: PaddingValues ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)
        ) {
            OutlinedTextField(
                value = exercise,
                onValueChange = { exercise = it },
                label = { Text("Exercise") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = score,
                onValueChange = { score = it },
                label = { Text("Score") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    if (exercise.isNotBlank() && score.isNotBlank()) {
                        viewModel.addEntry(
                            WorkoutEntry(
                                type = type,
                                category = category,
                                exercise = exercise,
                                score = score
                            )
                        )
                        exercise = ""
                        score = ""
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Log Entry")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Previous Entries", style = MaterialTheme.typography.titleMedium)

            entries
                .filter { it.type == type && it.category == category }
                .forEach { entry ->
                    Text("• ${entry.exercise} — ${entry.score}")
                }
        }
    }
}
