package com.example.workouttracker.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.PersonalRecord
import com.example.workouttracker.data.entity.SetTracking
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var tvTotalWorkouts: TextView
    private lateinit var tvTotalPRs: TextView
    private lateinit var tvCurrentStreak: TextView
    private lateinit var tvTotalVolume: TextView
    private lateinit var layoutRecentPRs: LinearLayout
    private lateinit var layoutProgressSummary: LinearLayout
    private lateinit var chartWeightProgression: LineChart
    private lateinit var spinnerExerciseSelection: Spinner

    private val repository by lazy { (application as WorkoutApplication).repository }
    private var allExercises = listOf<com.example.workouttracker.data.entity.Exercise>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics_enhanced)

        initViews()
        loadAnalytics()
        setupChart()
    }

    private fun initViews() {
        tvTotalWorkouts = findViewById(R.id.tvTotalWorkouts)
        tvTotalPRs = findViewById(R.id.tvTotalPRs)
        tvCurrentStreak = findViewById(R.id.tvCurrentStreak)
        tvTotalVolume = findViewById(R.id.tvTotalVolume)
        layoutRecentPRs = findViewById(R.id.layoutRecentPRs)
        layoutProgressSummary = findViewById(R.id.layoutProgressSummary)
        chartWeightProgression = findViewById(R.id.chartWeightProgression)
        spinnerExerciseSelection = findViewById(R.id.spinnerExerciseSelection)

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }
    }

    private fun setupChart() {
        chartWeightProgression.apply {
            description.isEnabled = false
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)
            setBackgroundColor(Color.WHITE)

            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                granularity = 1f
                valueFormatter = DateAxisValueFormatter()
            }

            axisLeft.apply {
                setDrawGridLines(true)
                axisMinimum = 0f
            }

            axisRight.isEnabled = false
            legend.isEnabled = true
        }
    }

    private fun loadAnalytics() {
        lifecycleScope.launch {
            loadWorkoutStats()
            loadRecentPRs()

            // Load exercises first
            allExercises = repository.getExercises(1) + repository.getExercises(2) + repository.getExercises(3)

            // Setup spinner with loaded exercises
            if (allExercises.isNotEmpty()) {
                setupExerciseSpinner()
            }

            // Now load progress charts with populated allExercises
            loadProgressCharts()
        }
    }

    private fun setupExerciseSpinner() {
        val exerciseNames = allExercises.map { it.name }
        val adapter = ArrayAdapter(this@AnalyticsActivity, android.R.layout.simple_spinner_item, exerciseNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerExerciseSelection.adapter = adapter

        spinnerExerciseSelection.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedExercise = allExercises[position]
                lifecycleScope.launch {
                    loadWeightProgressionChart(selectedExercise.id)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        if (allExercises.isNotEmpty()) {
            lifecycleScope.launch {
                loadWeightProgressionChart(allExercises[0].id)
            }
        }
    }


    private suspend fun loadWeightProgressionChart(exerciseId: Int) {
        try {
            val recentSets = repository.getRecentSets(exerciseId, 30)

            if (recentSets.isEmpty()) {
                chartWeightProgression.clear()
                chartWeightProgression.invalidate()
                return
            }

            val entries = mutableListOf<Entry>()
            val successEntries = mutableListOf<Entry>()
            val failureEntries = mutableListOf<Entry>()

            recentSets.forEachIndexed { index, set ->
                val entry = Entry(index.toFloat(), set.weight.toFloat())
                entries.add(entry)

                if (set.isSuccessful) {
                    successEntries.add(entry)
                } else {
                    failureEntries.add(entry)
                }
            }

            val allSetsDataSet = LineDataSet(entries, "Weight Progression").apply {
                color = Color.BLUE
                setCircleColor(Color.BLUE)
                lineWidth = 2f
                circleRadius = 4f
                setDrawCircleHole(false)
                valueTextSize = 9f
                setDrawFilled(false)
            }

            val successDataSet = LineDataSet(successEntries, "Successful Lifts").apply {
                color = Color.GREEN
                setCircleColor(Color.GREEN)
                lineWidth = 0f
                circleRadius = 6f
                setDrawCircleHole(false)
                setDrawValues(false)
            }

            val failureDataSet = LineDataSet(failureEntries, "Failed Lifts").apply {
                color = Color.RED
                setCircleColor(Color.RED)
                lineWidth = 0f
                circleRadius = 6f
                setDrawCircleHole(false)
                setDrawValues(false)
            }

            val dataSets: MutableList<ILineDataSet> = mutableListOf<ILineDataSet>()
            dataSets.add(allSetsDataSet)
            if (successEntries.isNotEmpty()) dataSets.add(successDataSet)
            if (failureEntries.isNotEmpty()) dataSets.add(failureDataSet)

            val lineData = LineData(dataSets)
            chartWeightProgression.data = lineData
            chartWeightProgression.invalidate()

        } catch (e: Exception) {
            println("Error loading weight progression chart: ${e.message}")
        }
    }

    inner class DateAxisValueFormatter : ValueFormatter() {
        private val dateFormat = SimpleDateFormat("MM/dd", Locale.getDefault())

        override fun getFormattedValue(value: Float): String {
            return "Set ${value.toInt() + 1}"
        }
    }

    private suspend fun loadProgressCharts() {
        println("DEBUG: Starting loadProgressCharts")
        println("DEBUG: All exercises count: ${allExercises.size}")

        val majorExercises = allExercises.take(3)
        println("DEBUG: Major exercises: ${majorExercises.map { "${it.id}: ${it.name}" }}")

        majorExercises.forEach { exercise ->
            try {
                val recentSets = repository.getRecentSets(exercise.id, 10)
                println("DEBUG: Exercise ${exercise.name} has ${recentSets.size} recent sets")

                if (recentSets.isNotEmpty()) {
                    println("DEBUG: Adding progress card for ${exercise.name}")
                    addEnhancedProgressCard(exercise, recentSets)
                } else {
                    println("DEBUG: No recent sets for ${exercise.name}")
                }
            } catch (e: Exception) {
                println("DEBUG ERROR: Error loading progress for exercise ${exercise.id}: ${e.message}")
            }
        }

        println("DEBUG: Finished loadProgressCharts")
    }

    private fun addEnhancedProgressCard(exercise: com.example.workouttracker.data.entity.Exercise, recentSets: List<SetTracking>) {
        val cardView = layoutInflater.inflate(R.layout.item_enhanced_progress_card, layoutProgressSummary, false)

        val tvExerciseName = cardView.findViewById<TextView>(R.id.tvProgressExerciseName)
        val tvCurrentMax = cardView.findViewById<TextView>(R.id.tvCurrentMax)
        val tvRecentTrend = cardView.findViewById<TextView>(R.id.tvRecentTrend)
        val tvSuccessRate = cardView.findViewById<TextView>(R.id.tvSuccessRate)
        val tvVolumeIncrease = cardView.findViewById<TextView>(R.id.tvVolumeIncrease)

        val maxWeight = recentSets.maxByOrNull { it.weight }?.weight ?: 0.0
        val successRate = recentSets.count { it.isSuccessful } * 100.0 / recentSets.size
        val totalVolume = recentSets.sumOf { it.weight * it.actualReps }

        val recent5 = recentSets.take(5)
        val older5 = recentSets.drop(5).take(5)
        val recentAvg = if (recent5.isNotEmpty()) recent5.map { it.weight }.average() else 0.0
        val olderAvg = if (older5.isNotEmpty()) older5.map { it.weight }.average() else recentAvg

        tvExerciseName.text = exercise.name
        tvCurrentMax.text = "${maxWeight}kg"
        tvSuccessRate.text = "${successRate.toInt()}%"
        tvVolumeIncrease.text = "${totalVolume.toInt()}kg total"

        tvRecentTrend.text = when {
            recentAvg > olderAvg + 1 -> "📈 +${String.format("%.1f", recentAvg - olderAvg)}kg"
            recentAvg < olderAvg - 1 -> "📉 ${String.format("%.1f", recentAvg - olderAvg)}kg"
            else -> "➡️ Stable"
        }

        layoutProgressSummary.addView(cardView)
    }

    private suspend fun loadWorkoutStats() {
        try {
            val allSets = mutableListOf<SetTracking>()
            allExercises.forEach { exercise ->
                allSets.addAll(repository.getRecentSets(exercise.id, 50))
            }

            val totalWorkouts = allSets.size
            val totalVolume = allSets.sumOf { it.weight * it.actualReps }

            tvTotalWorkouts.text = totalWorkouts.toString()
            tvTotalVolume.text = String.format("%.0f kg", totalVolume)
            tvCurrentStreak.text = "5 days"
        } catch (e: Exception) {
            tvTotalWorkouts.text = "0"
            tvTotalVolume.text = "0 kg"
            tvCurrentStreak.text = "0 days"
        }
    }

    private suspend fun loadRecentPRs() {
        try {
            val recentPRs = repository.getLatestPRPerExercise(5)

            if (recentPRs.isEmpty()) {
                val noPRsView = TextView(this@AnalyticsActivity).apply {
                    text = "No personal records yet"
                    setPadding(16, 16, 16, 16)
                    textSize = 14f
                }
                layoutRecentPRs.addView(noPRsView)
            } else {
                recentPRs.forEach { pr: PersonalRecord ->
                    addPRCard(pr)
                }
            }

            tvTotalPRs.text = recentPRs.size.toString()
        } catch (e: Exception) {
            tvTotalPRs.text = "0"
        }
    }

    private suspend fun addPRCard(pr: PersonalRecord) {
        val cardView = layoutInflater.inflate(R.layout.item_pr_card, layoutRecentPRs, false)

        val tvExerciseName = cardView.findViewById<TextView>(R.id.tvPRExerciseName)
        val tvPRValue = cardView.findViewById<TextView>(R.id.tvPRValue)
        val tvPRDate = cardView.findViewById<TextView>(R.id.tvPRDate)

        val exercise = allExercises.find { it.id == pr.exerciseId }
        tvExerciseName.text = exercise?.name ?: "Exercise #${pr.exerciseId}"
        tvPRValue.text = "${pr.value}kg"

        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        tvPRDate.text = dateFormat.format(Date(pr.date))

        layoutRecentPRs.addView(cardView)
    }
}
