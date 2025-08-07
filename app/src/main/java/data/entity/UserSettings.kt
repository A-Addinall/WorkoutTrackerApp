package com.example.workouttracker.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class UserSettings(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "dark_theme")
    val darkTheme: Boolean,

    @ColumnInfo(name = "auto_weight_increment")
    val autoWeightIncrement: Double,

    @ColumnInfo(name = "default_rest_time")
    val defaultRestTime: Int,

    @ColumnInfo(name = "units")
    val units: String
) {
    @Ignore
    constructor() : this(
        id = 1,
        darkTheme = false,
        autoWeightIncrement = 2.5,
        defaultRestTime = 180,
        units = "kg"
    )
}
