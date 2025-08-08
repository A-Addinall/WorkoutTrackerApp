package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.PersonalRecord
import com.example.workouttracker.data.entity.SetTracking
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

    private val repository by lazy { (application as WorkoutApplication).repository }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)

        initViews()
        loadAnalytics()
    }

    private fun initViews() {
        tvTotalWorkouts = findViewById(R.id.tvTotalWorkouts)
        tvTotalPRs = findViewById(R.id.tvTotalPRs)
        tvCurrentStreak = findViewById(R.id.tvCurrentStreak)
        tvTotalVolume = findViewById(R.id.tvTotalVolume)
        layoutRecentPRs = findViewById(R.id.layoutRecentPRs)
        layoutProgressSummary = findViewById(R.id.layoutProgressSummary)

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }
    }

    private fun loadAnalytics() {
        lifecycleScope.launch {
            loadWorkoutStats()
            loadRecentPRs()
            loadProgressSummary()
        }
    }

    private suspend fun loadWorkoutStats() {
        try {
            // Get all workout sessions from last 30 days
            val thirtyDaysAgo = System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000)

            // For now, get recent sets as a proxy (you may need to add specific DAO methods)
            val recentSets = repository.getRecentSets(1, 100) // Get more sets across exercises

            // Calculate basic stats
            val totalWorkouts = recentSets.size
            val totalVolume = recentSets.sumOf { it.weight * it.actualReps }

            tvTotalWorkouts.text = totalWorkouts.toString()
            tvTotalVolume.text = String.format("%.0f kg", totalVolume)
            tvCurrentStreak.text = "5 days" // Placeholder - would need date-based calculation
        } catch (e: Exception) {
            tvTotalWorkouts.text = "0"
            tvTotalVolume.text = "0 kg"
            tvCurrentStreak.text = "0 days"
        }
    }

    private suspend fun loadRecentPRs() {
        try {
            // Actually fetch PRs from database
            val recentPRs = repository.getRecentPersonalRecords(5)

            println("DEBUG ANALYTICS: Found ${recentPRs.size} PRs")

            if (recentPRs.isEmpty()) {
                val noPRsView = TextView(this@AnalyticsActivity).apply {
                    text = "No recent personal records"
                    setPadding(16, 16, 16, 16)
                    textSize = 14f
                }
                layoutRecentPRs.addView(noPRsView)
            } else {
                recentPRs.forEach { pr ->
                    println("DEBUG ANALYTICS: Adding PR - Exercise: ${pr.exerciseId}, Value: ${pr.value}")
                    addPRCard(pr)
                }
            }

            tvTotalPRs.text = recentPRs.size.toString()
        } catch (e: Exception) {
            println("DEBUG ANALYTICS: Error loading PRs - ${e.message}")
            tvTotalPRs.text = "0"
        }
    }

    private suspend fun addPRCard(pr: PersonalRecord) {
        val cardView = layoutInflater.inflate(R.layout.item_pr_card, layoutRecentPRs, false)

        val tvExerciseName = cardView.findViewById<TextView>(R.id.tvPRExerciseName)
        val tvPRValue = cardView.findViewById<TextView>(R.id.tvPRValue)
        val tvPRDate = cardView.findViewById<TextView>(R.id.tvPRDate)

        // Get actual exercise name
        val exercise = repository.getExercises(1).find { it.id == pr.exerciseId }
        tvExerciseName.text = exercise?.name ?: "Exercise #${pr.exerciseId}"
        tvPRValue.text = "${pr.value}kg"

        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        tvPRDate.text = dateFormat.format(Date(pr.date))

        layoutRecentPRs.addView(cardView)
    }

    private suspend fun loadProgressSummary() {
        // Add progress summary cards for major exercises
        val majorExercises = listOf(1, 2, 3) // Exercise IDs for bench, squat, deadlift

        majorExercises.forEach { exerciseId ->
            try {
                val recentSets = repository.getRecentSets(exerciseId, 10)
                if (recentSets.isNotEmpty()) {
                    addProgressCard(exerciseId, recentSets)
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    private fun addProgressCard(exerciseId: Int, recentSets: List<SetTracking>) {
        val cardView = layoutInflater.inflate(R.layout.item_progress_card, layoutProgressSummary, false)

        val tvExerciseName = cardView.findViewById<TextView>(R.id.tvProgressExerciseName)
        val tvCurrentMax = cardView.findViewById<TextView>(R.id.tvCurrentMax)
        val tvRecentTrend = cardView.findViewById<TextView>(R.id.tvRecentTrend)
        val tvSuccessRate = cardView.findViewById<TextView>(R.id.tvSuccessRate)

        // Calculate metrics
        val maxWeight = recentSets.maxByOrNull { it.weight }?.weight ?: 0.0
        val successRate = recentSets.count { it.isSuccessful } * 100.0 / recentSets.size

        tvExerciseName.text = "Exercise #$exerciseId" // You'd get actual name
        tvCurrentMax.text = "${maxWeight}kg"
        tvSuccessRate.text = "${successRate.toInt()}% success"

        // Simple trend analysis
        val recent5 = recentSets.take(5)
        val older5 = recentSets.drop(5).take(5)
        val recentAvg = recent5.map { it.weight }.average()
        val olderAvg = if (older5.isNotEmpty()) older5.map { it.weight }.average() else recentAvg

        tvRecentTrend.text = when {
            recentAvg > olderAvg + 1 -> "📈 Improving"
            recentAvg < olderAvg - 1 -> "📉 Declining"
            else -> "➡️ Stable"
        }

        layoutProgressSummary.addView(cardView)
    }
}
