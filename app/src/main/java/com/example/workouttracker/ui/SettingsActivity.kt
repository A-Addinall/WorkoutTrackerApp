package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.workouttracker.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)

        findViewById<TextView>(R.id.tvTitle).text = "Settings"

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }

        // TODO: Phase 3 - Implement settings functionality (dark theme, preferences)
    }
}
