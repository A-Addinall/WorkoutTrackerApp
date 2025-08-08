package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.WorkoutSession
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseDetailActivity : AppCompatActivity() {

    private val workoutViewModel: WorkoutViewModel by viewModels {
        WorkoutViewModelFactory((application as WorkoutApplication).repository)
    }

    private lateinit var tvExerciseName: TextView
    private lateinit var tvLastWeight: TextView
    private lateinit var tvSuggestedWeight: TextView
    private lateinit var layoutSets: LinearLayout
    private lateinit var btnAddSet: Button
    private lateinit var btnCompleteExercise: Button
    private lateinit var etNotes: EditText

    private var exerciseId: Int = 0
    private var exerciseName: String = ""
    private var repRange: String = ""
    private var currentSets = mutableListOf<SetData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_detail)

        exerciseId = intent.getIntExtra("EXERCISE_ID", 0)
        exerciseName = intent.getStringExtra("EXERCISE_NAME") ?: ""
        repRange = intent.getStringExtra("REP_RANGE") ?: ""

        initViews()
        setupObservers()
        loadInitialData()
    }

    private fun initViews() {
        tvExerciseName = findViewById(R.id.tvExerciseName)
        tvLastWeight = findViewById(R.id.tvLastWeight)
        tvSuggestedWeight = findViewById(R.id.tvSuggestedWeight)
        layoutSets = findViewById(R.id.layoutSets)
        btnAddSet = findViewById(R.id.btnAddSet)
        btnCompleteExercise = findViewById(R.id.btnCompleteExercise)
        etNotes = findViewById(R.id.etNotes)

        tvExerciseName.text = exerciseName

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }

        btnAddSet.setOnClickListener {
            addNewSet()
        }

        btnCompleteExercise.setOnClickListener {
            completeExercise()
        }
    }

    // In ExerciseDetailActivity.kt - Update the setupObservers method:
    private fun setupObservers() {
        val repository = (application as WorkoutApplication).repository

        // UPDATED: Observe last successful weight instead of just last weight
        repository.getLastSuccessfulWeightLiveData(exerciseId).observe(this) { lastSuccessfulWeight: Double? ->
            tvLastWeight.text = if (lastSuccessfulWeight != null && lastSuccessfulWeight > 0) {
                "Last successful lift: ${lastSuccessfulWeight}kg"  // ← Updated text
            } else {
                "No successful lifts yet"  // ← Updated text for no data
            }
        }

        // Load suggested weight
        CoroutineScope(Dispatchers.Main).launch {
            val suggestedWeight = repository.getSuggestedWeight(exerciseId)
            tvSuggestedWeight.text = "Suggested: ${suggestedWeight}kg"
        }
    }


    private fun loadInitialData() {
        // Add one initial set
        addNewSet()
    }

    private fun addNewSet() {
        val setNumber = currentSets.size + 1
        val setView = layoutInflater.inflate(R.layout.item_set_entry, layoutSets, false)

        val tvSetNumber = setView.findViewById<TextView>(R.id.tvSetNumber)
        val etWeight = setView.findViewById<EditText>(R.id.etWeight)
        val etReps = setView.findViewById<EditText>(R.id.etReps)
        val btnSuccess = setView.findViewById<Button>(R.id.btnSuccess)
        val btnFail = setView.findViewById<Button>(R.id.btnFail)

        tvSetNumber.text = "Set $setNumber:"

        // Set suggested weight as hint
        CoroutineScope(Dispatchers.Main).launch {
            val suggestedWeight = (application as WorkoutApplication).repository.getSuggestedWeight(exerciseId)
            etWeight.hint = suggestedWeight.toString()
        }

        // Create SetData object first and add to list
        val setData = SetData(setNumber, etWeight, etReps, null)
        currentSets.add(setData)

        btnSuccess.setOnClickListener {
            val weight = etWeight.text.toString().toDoubleOrNull()
            val reps = etReps.text.toString().toIntOrNull() ?: 1

            if (weight != null && reps > 0) {
                lifecycleScope.launch {
                    (application as WorkoutApplication).repository.logStrength(
                        exerciseId = exerciseId,
                        sets = 1,
                        reps = reps,
                        weight = weight,
                        isSuccessful = true,
                        rpe = 6.0,
                        notes = etNotes.text.toString().ifEmpty { null }
                    )

                    // FIXED: Update local SetData to track success
                    setData.isSuccessful = true

                    btnSuccess.setBackgroundColor(ContextCompat.getColor(this@ExerciseDetailActivity, android.R.color.holo_green_light))
                    btnFail.setBackgroundColor(ContextCompat.getColor(this@ExerciseDetailActivity, android.R.color.darker_gray))

                    Toast.makeText(this@ExerciseDetailActivity, "✅ Set logged as successful!", Toast.LENGTH_SHORT).show()
                    updateSuggestedWeight()
                }
            } else {
                Toast.makeText(this@ExerciseDetailActivity, "Please enter valid weight and reps", Toast.LENGTH_SHORT).show()
            }
        }

        btnFail.setOnClickListener {
            val weight = etWeight.text.toString().toDoubleOrNull()
            val reps = etReps.text.toString().toIntOrNull() ?: 1

            if (weight != null && reps > 0) {
                lifecycleScope.launch {
                    (application as WorkoutApplication).repository.logStrength(
                        exerciseId = exerciseId,
                        sets = 1,
                        reps = reps,
                        weight = weight,
                        isSuccessful = false,
                        rpe = 9.0,
                        notes = etNotes.text.toString().ifEmpty { null }
                    )

                    // FIXED: Update local SetData to track failure
                    setData.isSuccessful = false

                    btnFail.setBackgroundColor(ContextCompat.getColor(this@ExerciseDetailActivity, android.R.color.holo_red_light))
                    btnSuccess.setBackgroundColor(ContextCompat.getColor(this@ExerciseDetailActivity, android.R.color.darker_gray))

                    Toast.makeText(this@ExerciseDetailActivity, "❌ Set logged as failed!", Toast.LENGTH_SHORT).show()
                    updateSuggestedWeight()
                }
            } else {
                Toast.makeText(this@ExerciseDetailActivity, "Please enter valid weight and reps", Toast.LENGTH_SHORT).show()
            }
        }

        layoutSets.addView(setView)
    }

    private fun updateSuggestedWeight() {
        CoroutineScope(Dispatchers.Main).launch {
            val suggestedWeight = (application as WorkoutApplication).repository.getSuggestedWeight(exerciseId)
            tvSuggestedWeight.text = "Suggested: ${suggestedWeight}kg"
        }
    }

    private fun completeExercise() {
        val loggedSets = currentSets.count { it.isSuccessful != null }

        if (loggedSets > 0) {
            Toast.makeText(this, "Exercise completed! $loggedSets sets logged.", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Please complete at least one set by clicking Success or Fail", Toast.LENGTH_SHORT).show()
        }
    }

    private fun extractTargetReps(repRange: String): Int {
        return repRange.split("-").firstOrNull()?.filter { it.isDigit() }?.toIntOrNull() ?: 8
    }

    data class SetData(
        val setNumber: Int,
        val etWeight: EditText,
        val etReps: EditText,
        var isSuccessful: Boolean?
    )
}
