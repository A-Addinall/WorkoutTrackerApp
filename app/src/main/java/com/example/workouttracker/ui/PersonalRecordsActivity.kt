package com.example.workouttracker.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.workouttracker.R

class PersonalRecordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)

        findViewById<TextView>(R.id.tvTitle).text = "Personal Records"

        findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            finish()
        }

        // TODO: Phase 3 - Implement personal records functionality
    }
}
