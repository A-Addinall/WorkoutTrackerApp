package com.example.workouttracker.logic;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/example/workouttracker/logic/WeightSuggestionEngine;", "", "()V", "calculateOneRepMax", "", "weight", "reps", "", "decreaseWeight", "exerciseId", "currentWeight", "increment", "getProgressionRate", "Lcom/example/workouttracker/logic/WeightSuggestionEngine$ProgressionRate;", "exerciseName", "", "getStartingWeight", "increaseWeight", "roundToNearestPlate", "suggestWeight", "recentSets", "", "Lcom/example/workouttracker/data/entity/SetTracking;", "userSettings", "Lcom/example/workouttracker/data/entity/UserSettings;", "ProgressionRate", "app_debug"})
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
    
    private final com.example.workouttracker.logic.WeightSuggestionEngine.ProgressionRate getProgressionRate(int exerciseId, java.lang.String exerciseName) {
        return null;
    }
    
    private final double getStartingWeight(int exerciseId, java.lang.String exerciseName) {
        return 0.0;
    }
    
    private final double increaseWeight(int exerciseId, double currentWeight, double increment) {
        return 0.0;
    }
    
    private final double decreaseWeight(int exerciseId, double currentWeight, double increment) {
        return 0.0;
    }
    
    private final double roundToNearestPlate(double weight) {
        return 0.0;
    }
    
    public final double calculateOneRepMax(double weight, int reps) {
        return 0.0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/example/workouttracker/logic/WeightSuggestionEngine$ProgressionRate;", "", "fastIncrement", "", "normalIncrement", "slowIncrement", "(DDD)V", "getFastIncrement", "()D", "getNormalIncrement", "getSlowIncrement", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class ProgressionRate {
        private final double fastIncrement = 0.0;
        private final double normalIncrement = 0.0;
        private final double slowIncrement = 0.0;
        
        public ProgressionRate(double fastIncrement, double normalIncrement, double slowIncrement) {
            super();
        }
        
        public final double getFastIncrement() {
            return 0.0;
        }
        
        public final double getNormalIncrement() {
            return 0.0;
        }
        
        public final double getSlowIncrement() {
            return 0.0;
        }
        
        public final double component1() {
            return 0.0;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.workouttracker.logic.WeightSuggestionEngine.ProgressionRate copy(double fastIncrement, double normalIncrement, double slowIncrement) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}