package com.example.workouttracker.ui

import androidx.lifecycle.*
import com.example.workouttracker.data.entity.Exercise
import com.example.workouttracker.data.repository.WorkoutRepository
import kotlinx.coroutines.launch

class WorkoutViewModel(private val repo: WorkoutRepository) : ViewModel() {

    val workoutTypes = MutableLiveData<List<com.example.workouttracker.data.entity.WorkoutType>>()
    val allExercises = MutableLiveData<List<Exercise>>()
    val lastWeights   = MutableLiveData<Map<Int, Double>>()   // exId → kg
    val lastMetconSec = MutableLiveData<Long>()               // seconds (-wtId row)

    init {
        viewModelScope.launch {
            repo.initializeDatabase()
            workoutTypes.value = repo.getWorkoutTypes() } }

    fun loadWorkout(wtId: Int) = viewModelScope.launch {
        val exList = repo.getExercises(wtId)
        allExercises.value = exList

        /* fetch last weight for each strength exercise */
        val map = mutableMapOf<Int, Double>()
        for (ex in exList.filter { it.category == "Strength" }) {
            repo.lastSession(ex.id)?.weight?.let { map[ex.id] = it }
        }
        lastWeights.value = map

        /* fetch last metcon time */
        lastMetconSec.value = repo.lastSession(-wtId)?.time ?: 0L
    }

    fun logStrength(exId:Int,s:Int,r:Int,w:Double?) = viewModelScope.launch {
        repo.logStrength(exId,s,r,w); loadWorkout(currentWtId)    // refresh
    }
    fun logMetcon(wtId:Int,sec:Long)=viewModelScope.launch {
        repo.logMetcon(wtId,sec); loadWorkout(wtId)
    }

    var currentWtId = 1              // helper for MainActivity
}
