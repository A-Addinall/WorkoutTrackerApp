package com.example.workouttracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0012J-\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010%R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00160\u00150\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\n\u00a8\u0006&"}, d2 = {"Lcom/example/workouttracker/ui/WorkoutViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/workouttracker/data/repository/WorkoutRepository;", "(Lcom/example/workouttracker/data/repository/WorkoutRepository;)V", "allExercises", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/workouttracker/data/entity/Exercise;", "getAllExercises", "()Landroidx/lifecycle/MutableLiveData;", "currentWtId", "", "getCurrentWtId", "()I", "setCurrentWtId", "(I)V", "lastMetconSec", "", "getLastMetconSec", "lastWeights", "", "", "getLastWeights", "workoutTypes", "Lcom/example/workouttracker/data/entity/WorkoutType;", "getWorkoutTypes", "loadWorkout", "Lkotlinx/coroutines/Job;", "wtId", "logMetcon", "sec", "logStrength", "exId", "s", "r", "w", "(IIILjava/lang/Double;)Lkotlinx/coroutines/Job;", "app_debug"})
public final class WorkoutViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.workouttracker.data.repository.WorkoutRepository repo = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.workouttracker.data.entity.WorkoutType>> workoutTypes = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.workouttracker.data.entity.Exercise>> allExercises = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.Integer, java.lang.Double>> lastWeights = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> lastMetconSec = null;
    private int currentWtId = 1;
    
    public WorkoutViewModel(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.repository.WorkoutRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.workouttracker.data.entity.WorkoutType>> getWorkoutTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.workouttracker.data.entity.Exercise>> getAllExercises() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.Integer, java.lang.Double>> getLastWeights() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getLastMetconSec() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job loadWorkout(int wtId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job logStrength(int exId, int s, int r, @org.jetbrains.annotations.Nullable
    java.lang.Double w) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job logMetcon(int wtId, long sec) {
        return null;
    }
    
    public final int getCurrentWtId() {
        return 0;
    }
    
    public final void setCurrentWtId(int p0) {
    }
}