package com.example.workouttracker.logic;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/example/workouttracker/logic/WeightSuggestionEngine;", "", "()V", "calculateOneRepMax", "", "weight", "reps", "", "getStartingWeight", "exerciseId", "exerciseName", "", "roundToNearestPlate", "suggestWeight", "recentSets", "", "Lcom/example/workouttracker/data/entity/SetTracking;", "userSettings", "Lcom/example/workouttracker/data/entity/UserSettings;", "app_debug"})
public final class WeightSuggestionEngine {
    
    public WeightSuggestionEngine() {
        super();
    }
    
    public final double suggestWeight(int exerciseId, @org.jetbrains.annotations.NotNull
    java.lang.String exerciseName, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.workouttracker.data.entity.SetTracking> recentSets, @org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.UserSettings userSettings) {
        return 0.0;
    }
    
    private final double getStartingWeight(int exerciseId, java.lang.String exerciseName) {
        return 0.0;
    }
    
    private final double roundToNearestPlate(double weight) {
        return 0.0;
    }
    
    public final double calculateOneRepMax(double weight, int reps) {
        return 0.0;
    }
}