package com.example.workouttracker.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.Exercise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MetconActivity : AppCompatActivity() {

    private val workoutViewModel: WorkoutViewModel by viewModels {
        WorkoutViewModelFactory((application as WorkoutApplication).repository)
    }

    private lateinit var layoutMetconExercises: LinearLayout
    private lateinit var tvWorkoutTitle: TextView
    private lateinit var tvTimer: TextView
    private lateinit var btnStartStop: Button
    private lateinit var btnReset: Button
    private lateinit var btnComplete: Button
    private lateinit var tvLastTime: TextView

    private var workoutTypeId: Int = 1
    private var workoutName: String = ""
    private var metconExercises = listOf<Exercise>()

    private var timer: CountDownTimer? = null
    private var isRunning = false
    private var timeElapsedMs = 0L
    private var startTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metcon)  // FIXED: Now uses correct layout

        workoutTypeId = intent.getIntExtra("WORKOUT_TYPE_ID", 1)
        workoutName = intent.getStringExtra("WORKOUT_NAME") ?: "Metcon"

        initViews()
        setupObservers()
        loadMetconData()
    }

    private fun initViews() {
        layoutMetconExercises = findViewById(R.id.layoutMetconExercises)
        tvWorkoutTitle = findViewById(R.id.tvWorkoutTitle)
        tvTimer = findViewById(R.id.tvTimer)
        btnStartStop = findViewById(R.id.btnStartStop)
        btnReset = findViewById(R.id.btnReset)
        btnComplete = findViewById(R.id.btnComplete)
        tvLastTime = findViewById(R.id.tvLastTime)

        tvWorkoutTitle.text = "$workoutName - Metcon"
        tvTimer.text = "00:00"

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }

        btnStartStop.setOnClickListener {
            if (isRunning) {
                stopTimer()
            } else {
                startTimer()
            }
        }

        btnReset.setOnClickListener {
            resetTimer()
        }

        btnComplete.setOnClickListener {
            completeMetcon()
        }
    }

    private fun setupObservers() {
        workoutViewModel.allExercises.observe(this, Observer { exercises ->
            exercises?.let {
                metconExercises = it.filter { exercise -> exercise.category == "Metcon" }
                displayMetconExercises()
            }
        })

        workoutViewModel.lastMetconSec.observe(this, Observer { lastTime ->
            if (lastTime > 0) {
                val minutes = lastTime / 60
                val seconds = lastTime % 60
                tvLastTime.text = "Last time: ${minutes}m ${seconds}s"
            } else {
                tvLastTime.text = "No previous time"
            }
        })
    }

    private fun loadMetconData() {
        workoutViewModel.loadWorkout(workoutTypeId)
    }

    private fun displayMetconExercises() {
        layoutMetconExercises.removeAllViews()

        if (metconExercises.isEmpty()) {
            val noExercisesText = TextView(this).apply {
                text = "No metcon exercises found for this workout"
                textSize = 16f
                setPadding(16, 16, 16, 16)
            }
            layoutMetconExercises.addView(noExercisesText)
            return
        }

        // Add title
        val titleView = TextView(this).apply {
            text = "Metcon Circuit"
            textSize = 20f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(16, 16, 16, 16)
        }
        layoutMetconExercises.addView(titleView)

        // Add each exercise
        metconExercises.forEach { exercise ->
            val exerciseView = layoutInflater.inflate(R.layout.item_metcon_exercise, layoutMetconExercises, false)

            val tvExerciseName = exerciseView.findViewById<TextView>(R.id.tvExerciseName)
            val tvRepRange = exerciseView.findViewById<TextView>(R.id.tvRepRange)

            tvExerciseName.text = exercise.name
            tvRepRange.text = exercise.repRange

            layoutMetconExercises.addView(exerciseView)
        }
    }

    private fun startTimer() {
        if (!isRunning) {
            startTime = System.currentTimeMillis() - timeElapsedMs
            isRunning = true
            btnStartStop.text = "PAUSE"

            timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timeElapsedMs = System.currentTimeMillis() - startTime
                    updateTimerDisplay()
                }

                override fun onFinish() {
                    // This won't be called since we use Long.MAX_VALUE
                }
            }
            timer?.start()
        }
    }

    private fun stopTimer() {
        if (isRunning) {
            timer?.cancel()
            isRunning = false
            btnStartStop.text = "START"
        }
    }

    private fun resetTimer() {
        timer?.cancel()
        isRunning = false
        timeElapsedMs = 0L
        startTime = 0L
        btnStartStop.text = "START"
        tvTimer.text = "00:00"
    }

    private fun updateTimerDisplay() {
        val totalSeconds = (timeElapsedMs / 1000).toInt()
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        tvTimer.text = String.format("%02d:%02d", minutes, seconds)
    }

    private fun completeMetcon() {
        if (timeElapsedMs == 0L) {
            Toast.makeText(this, "Please start the timer first!", Toast.LENGTH_SHORT).show()
            return
        }

        // Stop timer if running
        if (isRunning) {
            stopTimer()
        }

        val totalSeconds = (timeElapsedMs / 1000).toInt()

        CoroutineScope(Dispatchers.Main).launch {
            // Log metcon time using negative workout type ID (as per original implementation)
            (application as WorkoutApplication).repository.logMetcon(workoutTypeId, totalSeconds.toLong())

            val minutes = totalSeconds / 60
            val seconds = totalSeconds % 60

            Toast.makeText(
                this@MetconActivity,
                "Metcon completed in ${minutes}m ${seconds}s!",
                Toast.LENGTH_LONG
            ).show()

            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
