package com.example.workouttracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a2\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a2\u0006\u0010\u0018\u001a\u00020\u0014J#\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u001b\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010&\u001a\u0004\u0018\u00010\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\"H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u0019\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0019\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J\u001b\u00107\u001a\u0004\u0018\u0001052\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J-\u00108\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00172\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J?\u0010<\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010@J\u0019\u0010A\u001a\u00020*2\u0006\u00101\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"Lcom/example/workouttracker/data/repository/WorkoutRepository;", "", "dao", "Lcom/example/workouttracker/data/dao/WorkoutDao;", "(Lcom/example/workouttracker/data/dao/WorkoutDao;)V", "weightSuggestionEngine", "Lcom/example/workouttracker/logic/WeightSuggestionEngine;", "getActiveExercisesByCategory", "", "Lcom/example/workouttracker/data/entity/ExerciseLibrary;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveExercises", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultUserSettings", "Lcom/example/workouttracker/data/entity/UserSettings;", "getExercises", "Lcom/example/workouttracker/data/entity/Exercise;", "workoutTypeId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastMetconTime", "", "exerciseId", "getLastMetconTimeLiveData", "Landroidx/lifecycle/LiveData;", "getLastWeightLiveData", "", "getPersonalRecord", "Lcom/example/workouttracker/data/entity/PersonalRecord;", "type", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentSets", "Lcom/example/workouttracker/data/entity/SetTracking;", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSuggestedWeight", "getUserSettings", "getWorkoutTypes", "Lcom/example/workouttracker/data/entity/WorkoutType;", "insertPersonalRecord", "", "personalRecord", "(Lcom/example/workouttracker/data/entity/PersonalRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSetTracking", "setTracking", "(Lcom/example/workouttracker/data/entity/SetTracking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserSettings", "userSettings", "(Lcom/example/workouttracker/data/entity/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutSession", "session", "Lcom/example/workouttracker/data/entity/WorkoutSession;", "(Lcom/example/workouttracker/data/entity/WorkoutSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lastSession", "logMetcon", "timeInSeconds", "notes", "(IJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logStrength", "sets", "reps", "weight", "(IIILjava/lang/Double;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserSettings", "app_debug"})
public final class WorkoutRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.workouttracker.data.dao.WorkoutDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.workouttracker.logic.WeightSuggestionEngine weightSuggestionEngine = null;
    
    public WorkoutRepository(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.dao.WorkoutDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSuggestedWeight(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    private final com.example.workouttracker.data.entity.UserSettings getDefaultUserSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getWorkoutTypes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.WorkoutType>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getExercises(int workoutTypeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.Exercise>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object lastSession(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.WorkoutSession> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Double> getLastWeightLiveData(int exerciseId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object logStrength(int exerciseId, int sets, int reps, @org.jetbrains.annotations.Nullable
    java.lang.Double weight, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object logMetcon(int exerciseId, long timeInSeconds, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastMetconTime(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Long> getLastMetconTimeLiveData(int exerciseId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertWorkoutSession(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.WorkoutSession session, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertSetTracking(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.SetTracking setTracking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecentSets(int exerciseId, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.SetTracking>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertPersonalRecord(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.PersonalRecord personalRecord, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPersonalRecord(int exerciseId, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.PersonalRecord> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserSettings(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.UserSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertUserSettings(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.UserSettings userSettings, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateUserSettings(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.UserSettings userSettings, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getActiveExercisesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.ExerciseLibrary>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllActiveExercises(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.ExerciseLibrary>> $completion) {
        return null;
    }
}