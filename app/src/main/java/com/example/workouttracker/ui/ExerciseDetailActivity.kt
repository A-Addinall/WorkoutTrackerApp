package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.PersonalRecord
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.appcompat.app.AlertDialog
import android.view.Gravity

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

    private fun setupObservers() {
        val repository = (application as WorkoutApplication).repository

        // Load last successful weight
        CoroutineScope(Dispatchers.Main).launch {
            val recentSets = repository.getRecentSets(exerciseId, 20)
            val lastSuccessfulWeight = recentSets
                .filter { it.isSuccessful }
                .maxByOrNull { it.weight }?.weight

            tvLastWeight.text = if (lastSuccessfulWeight != null && lastSuccessfulWeight > 0) {
                "Last successful lift: ${lastSuccessfulWeight}kg"
            } else {
                "No successful lifts yet"
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
                    // Check if this is a new PR before logging
                    val currentPR = (application as WorkoutApplication).repository
                        .getPersonalRecord(exerciseId, "max_weight")

                    val isNewPR = currentPR == null || weight > currentPR.value

                    (application as WorkoutApplication).repository.logStrength(
                        exerciseId = exerciseId,
                        sets = 1,
                        reps = reps,
                        weight = weight,
                        isSuccessful = true,
                        rpe = 6.0,
                        notes = etNotes.text.toString().ifEmpty { null }
                    )

                    // Save new PR if achieved
                    if (isNewPR) {
                        val personalRecord = PersonalRecord(
                            exerciseId = exerciseId,
                            recordType = "max_weight",
                            value = weight,
                            date = System.currentTimeMillis(),
                            notes = "New max weight PR!"
                        )
                        (application as WorkoutApplication).repository.insertPersonalRecord(personalRecord)

                        // Custom centered dialog for PR celebration
                        AlertDialog.Builder(this@ExerciseDetailActivity)
                            .setTitle("🎉 PERSONAL RECORD! 🎉")
                            .setMessage("New max weight: ${weight}kg\n\nCongratulations!")
                            .setPositiveButton("Awesome!") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .setCancelable(true)
                            .show()
                    } else {
                        // Center the regular success toast
                        val toast = Toast.makeText(
                            this@ExerciseDetailActivity,
                            "✅ Set logged as successful!",
                            Toast.LENGTH_SHORT
                        )
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()
                    }

                    // Update local tracking
                    setData.isSuccessful = true
                    btnSuccess.setBackgroundColor(ContextCompat.getColor(this@ExerciseDetailActivity, android.R.color.holo_green_light))
                    btnFail.setBackgroundColor(ContextCompat.getColor(this@ExerciseDetailActivity, android.R.color.darker_gray))

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

                    // Update local tracking
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
