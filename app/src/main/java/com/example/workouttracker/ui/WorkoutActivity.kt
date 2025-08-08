package com.example.workouttracker.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.Exercise
import com.example.workouttracker.data.repository.WorkoutRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

class WorkoutActivity : AppCompatActivity() {

    private val workoutViewModel: WorkoutViewModel by viewModels {
        WorkoutViewModelFactory((application as WorkoutApplication).repository)
    }

    private lateinit var layoutExercises: LinearLayout
    private lateinit var tvWorkoutTitle: TextView
    private var workoutTypeId: Int = 1
    private var workoutName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        workoutTypeId = intent.getIntExtra("WORKOUT_TYPE_ID", 1)
        workoutName = intent.getStringExtra("WORKOUT_NAME") ?: "Workout"

        // Debug code to check for duplicates
        lifecycleScope.launch {
            val repository = (application as WorkoutApplication).repository
            val dayAExercises = repository.getExercises(workoutTypeId) // Use workoutTypeId instead of hardcoded 1
            val duplicates = dayAExercises.groupBy { it.name }.filter { it.value.size > 1 }
            println("DEBUG: Duplicate exercise names: ${duplicates.keys}")

            // Clean up duplicates if they exist (you'll need to add this method to repository first)
            repository.removeDuplicateExercises(workoutTypeId)
        }

        initViews()
        setupObservers()
        workoutViewModel.loadWorkout(workoutTypeId)
    }

    private fun initViews() {
        tvWorkoutTitle = findViewById(R.id.tvWorkoutTitle)
        layoutExercises = findViewById(R.id.layoutExercises)

        tvWorkoutTitle.text = workoutName

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }
    }

    private fun setupObservers() {
        workoutViewModel.allExercises.observe(this, Observer { exercises ->
            exercises?.let { displayExercises(it) }
        })
    }

    private fun displayExercises(exercises: List<Exercise>) {
        layoutExercises.removeAllViews()

        val strengthExercises = exercises.filter { it.category == "Strength" }
        val metconExercises = exercises.filter { it.category == "Metcon" }

        if (strengthExercises.isNotEmpty()) {
            addSectionTitle("Strength Work")
            strengthExercises.forEach { exercise ->
                addExerciseCard(exercise)
            }
        }

        if (metconExercises.isNotEmpty()) {
            addSectionTitle("Metcon Circuit")
            addMetconCard(metconExercises)
        }
    }

    private fun addSectionTitle(title: String) {
        val titleView = TextView(this).apply {
            text = title
            textSize = 20f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(16, 32, 16, 16)
        }
        layoutExercises.addView(titleView)
    }

    // In WorkoutActivity.kt - Update the addExerciseCard method:
    private fun addExerciseCard(exercise: Exercise) {
        val cardView = layoutInflater.inflate(R.layout.item_exercise_card, layoutExercises, false)

        val tvExerciseName = cardView.findViewById<TextView>(R.id.tvExerciseName)
        val tvRepRange = cardView.findViewById<TextView>(R.id.tvRepRange)
        val tvLastWeight = cardView.findViewById<TextView>(R.id.tvLastWeight)

        tvExerciseName.text = exercise.name
        tvRepRange.text = exercise.repRange

        // UPDATED: Get last successful weight instead of last session
        CoroutineScope(Dispatchers.Main).launch {
            val repository = (application as WorkoutApplication).repository
            val recentSets = repository.getRecentSets(exercise.id, 20)
            val lastSuccessfulWeight = recentSets
                .filter { it.isSuccessful }
                .maxByOrNull { it.weight }?.weight

            tvLastWeight.text = if (lastSuccessfulWeight != null && lastSuccessfulWeight > 0) {
                "Last successful lift: ${lastSuccessfulWeight}kg"  // ← Updated text
            } else {
                "No successful lifts yet"  // ← Updated text for no data
            }
        }

        cardView.setOnClickListener {
            startExerciseDetailActivity(exercise)
        }

        layoutExercises.addView(cardView)
    }


    private fun addMetconCard(exercises: List<Exercise>) {
        val cardView = layoutInflater.inflate(R.layout.item_metcon_card, layoutExercises, false)

        val layoutMetconExercises = cardView.findViewById<LinearLayout>(R.id.layoutMetconExercises)
        val tvLastTime = cardView.findViewById<TextView>(R.id.tvLastTime)

        exercises.forEach { exercise ->
            val exerciseText = TextView(this).apply {
                text = "• ${exercise.name} - ${exercise.repRange}"
                textSize = 16f
                setPadding(16, 4, 16, 4)
            }
            layoutMetconExercises.addView(exerciseText)
        }

        workoutViewModel.lastMetconSec.observe(this) { lastTime ->
            if (lastTime > 0) {
                val minutes = lastTime / 60
                val seconds = lastTime % 60
                tvLastTime.text = "Last time: ${minutes}m ${seconds}s"
            } else {
                tvLastTime.text = "No previous time"
            }
        }

        cardView.setOnClickListener {
            startMetconActivity()
        }

        layoutExercises.addView(cardView)
    }

    private fun startExerciseDetailActivity(exercise: Exercise) {
        val intent = Intent(this, ExerciseDetailActivity::class.java).apply {
            putExtra("EXERCISE_ID", exercise.id)
            putExtra("EXERCISE_NAME", exercise.name)
            putExtra("REP_RANGE", exercise.repRange)
        }
        startActivity(intent)
    }

    private fun startMetconActivity() {
        val intent = Intent(this, MetconActivity::class.java).apply {
            putExtra("WORKOUT_TYPE_ID", workoutTypeId)
            putExtra("WORKOUT_NAME", workoutName)
        }
        startActivity(intent)
    }
}
