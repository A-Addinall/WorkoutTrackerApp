package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

    private fun setupObservers() {
        val repository = (application as WorkoutApplication).repository

        // Fix: Explicitly specify Double? type for lastWeight parameter
        repository.getLastWeightLiveData(exerciseId).observe(this) { lastWeight: Double? ->
            tvLastWeight.text = if (lastWeight != null && lastWeight > 0) {
                "Last: ${lastWeight}kg"
            } else {
                "No previous data"
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

        var isSuccessful: Boolean? = null

        btnSuccess.setOnClickListener {
            isSuccessful = true
            btnSuccess.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
            btnFail.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        }

        btnFail.setOnClickListener {
            isSuccessful = false
            btnFail.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
            btnSuccess.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        }

        val setData = SetData(setNumber, etWeight, etReps, isSuccessful)
        currentSets.add(setData)

        layoutSets.addView(setView)
    }

    private fun completeExercise() {
        var hasValidSets = false

        CoroutineScope(Dispatchers.Main).launch {
            val sessionId = System.currentTimeMillis().toInt()

            currentSets.forEach { setData ->
                val weight = setData.etWeight.text.toString().toDoubleOrNull() ?: 0.0
                val reps = setData.etReps.text.toString().toIntOrNull() ?: 0

                if (weight > 0 && reps > 0) {
                    hasValidSets = true

                    // Save to WorkoutSession (this is what your working metcon uses)
                    val workoutSession = WorkoutSession(
                        exerciseId = exerciseId,
                        date = System.currentTimeMillis(),
                        sets = 1,  // Individual set
                        reps = reps,
                        weight = weight,
                        time = null  // Only metcon uses time
                    )

                    (application as WorkoutApplication).repository.logStrength(
                        exerciseId, 1, reps, weight
                    )
                }
            }

            if (hasValidSets) {
                Toast.makeText(this@ExerciseDetailActivity, "Exercise completed successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this@ExerciseDetailActivity, "Please complete at least one set", Toast.LENGTH_SHORT).show()
            }
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
