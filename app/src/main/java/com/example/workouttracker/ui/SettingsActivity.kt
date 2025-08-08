package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.workouttracker.R
import com.example.workouttracker.WorkoutApplication
import com.example.workouttracker.data.entity.UserSettings
import kotlinx.coroutines.launch

class SettingsActivity : AppCompatActivity() {

    private lateinit var switchDarkTheme: Switch
    private lateinit var etWeightIncrement: EditText
    private lateinit var etRestTime: EditText
    private lateinit var spinnerUnits: Spinner
    private lateinit var switchShowPR: Switch
    private lateinit var btnSaveSettings: Button

    private val repository by lazy { (application as WorkoutApplication).repository }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        initViews()
        loadCurrentSettings()
        setupClickListeners()
    }

    private fun initViews() {
        switchDarkTheme = findViewById(R.id.switchDarkTheme)
        etWeightIncrement = findViewById(R.id.etWeightIncrement)
        etRestTime = findViewById(R.id.etRestTime)
        spinnerUnits = findViewById(R.id.spinnerUnits)
        switchShowPR = findViewById(R.id.switchShowPR)
        btnSaveSettings = findViewById(R.id.btnSaveSettings)

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }

        // Setup units spinner
        val unitsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOf("kg", "lbs"))
        unitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUnits.adapter = unitsAdapter
    }

    private fun loadCurrentSettings() {
        lifecycleScope.launch {
            val settings = repository.getUserSettings() ?: UserSettings()

            switchDarkTheme.isChecked = settings.darkTheme
            etWeightIncrement.setText(settings.autoWeightIncrement.toString())
            etRestTime.setText(settings.defaultRestTime.toString())
            spinnerUnits.setSelection(if (settings.units == "kg") 0 else 1)
            switchShowPR.isChecked = settings.showPersonalRecords
        }
    }

    private fun setupClickListeners() {
        btnSaveSettings.setOnClickListener {
            saveSettings()
        }
    }

    private fun saveSettings() {
        val weightIncrement = etWeightIncrement.text.toString().toDoubleOrNull() ?: 2.5
        val restTime = etRestTime.text.toString().toIntOrNull() ?: 120
        val units = if (spinnerUnits.selectedItemPosition == 0) "kg" else "lbs"

        val settings = UserSettings(
            id = 1,
            darkTheme = switchDarkTheme.isChecked,
            autoWeightIncrement = weightIncrement,
            defaultRestTime = restTime,
            units = units,
            showPersonalRecords = switchShowPR.isChecked
        )

        lifecycleScope.launch {
            try {
                val existingSettings = repository.getUserSettings()
                if (existingSettings != null) {
                    repository.updateUserSettings(settings)
                } else {
                    repository.insertUserSettings(settings)
                }

                Toast.makeText(this@SettingsActivity, "Settings saved successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } catch (e: Exception) {
                Toast.makeText(this@SettingsActivity, "Error saving settings", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
