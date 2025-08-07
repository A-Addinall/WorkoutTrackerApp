package com.example.workouttracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\'J#\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\'\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\'\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u001f\u0010\'\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u0006\u0010(\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0013\u0010)\u001a\u0004\u0018\u00010*H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010+\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u0019\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u001f\u00103\u001a\u00020-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J\u0019\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u001eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J\u0019\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020#H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J\u0019\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020*H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J\u0019\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0019H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0019\u0010E\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0019\u0010F\u001a\u00020-2\u0006\u0010=\u001a\u00020*H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lcom/example/workouttracker/data/dao/WorkoutDao;", "", "getActiveExercisesByCategory", "", "Lcom/example/workouttracker/data/entity/ExerciseLibrary;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveExercises", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWorkoutTypes", "Lcom/example/workouttracker/data/entity/WorkoutType;", "getExerciseById", "Lcom/example/workouttracker/data/entity/Exercise;", "exerciseId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExerciseLibraryCount", "getExercisesByWorkoutType", "workoutTypeId", "getLastMetconTime", "", "getLastMetconTimeLiveData", "Landroidx/lifecycle/LiveData;", "getLastSession", "Lcom/example/workouttracker/data/entity/WorkoutSession;", "getLastWeightForExercise", "", "getLastWeightForExerciseLiveData", "getPersonalRecord", "Lcom/example/workouttracker/data/entity/PersonalRecord;", "type", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersonalRecordHistory", "getRecentSets", "Lcom/example/workouttracker/data/entity/SetTracking;", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentWorkoutSessions", "getSetsForSession", "sessionId", "getUserSettings", "Lcom/example/workouttracker/data/entity/UserSettings;", "getWorkoutTypeCount", "insertExercise", "", "exercise", "(Lcom/example/workouttracker/data/entity/Exercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExerciseLibrary", "exerciseLibrary", "(Lcom/example/workouttracker/data/entity/ExerciseLibrary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExercises", "exercises", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPersonalRecord", "personalRecord", "(Lcom/example/workouttracker/data/entity/PersonalRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSetTracking", "setTracking", "(Lcom/example/workouttracker/data/entity/SetTracking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserSettings", "userSettings", "(Lcom/example/workouttracker/data/entity/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutSession", "session", "(Lcom/example/workouttracker/data/entity/WorkoutSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutType", "workoutType", "(Lcom/example/workouttracker/data/entity/WorkoutType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExerciseLibrary", "updateUserSettings", "app_debug"})
@androidx.room.Dao
public abstract interface WorkoutDao {
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM workout_type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWorkoutTypeCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecentWorkoutSessions(int exerciseId, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.WorkoutSession>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM exercise WHERE id = :exerciseId LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExerciseById(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.Exercise> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM exercise_library")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExerciseLibraryCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExercises(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.workouttracker.data.entity.Exercise> exercises, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExerciseLibrary(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.ExerciseLibrary exerciseLibrary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM workout_type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllWorkoutTypes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.WorkoutType>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWorkoutType(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.WorkoutType workoutType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM exercise WHERE workoutTypeId = :workoutTypeId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExercisesByWorkoutType(int workoutTypeId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.Exercise>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExercise(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.Exercise exercise, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWorkoutSession(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.WorkoutSession session, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM workout_session WHERE exerciseId = :exerciseId ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLastSession(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.WorkoutSession> $completion);
    
    @androidx.room.Query(value = "SELECT time FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLastMetconTime(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COALESCE(time, 0) FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.lang.Long> getLastMetconTimeLiveData(int exerciseId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertSetTracking(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.SetTracking setTracking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM set_tracking WHERE exerciseId = :exerciseId ORDER BY id DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecentSets(int exerciseId, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.SetTracking>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM set_tracking WHERE workoutSessionId = :sessionId ORDER BY setNumber ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSetsForSession(int sessionId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.SetTracking>> $completion);
    
    @androidx.room.Query(value = "SELECT weight FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLastWeightForExercise(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT weight FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.lang.Double> getLastWeightForExerciseLiveData(int exerciseId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPersonalRecord(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.PersonalRecord personalRecord, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM personal_record WHERE exerciseId = :exerciseId AND recordType = :type ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPersonalRecord(int exerciseId, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.PersonalRecord> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM personal_record WHERE exerciseId = :exerciseId ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPersonalRecordHistory(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.PersonalRecord>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user_settings LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserSettings(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.UserSettings> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUserSettings(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.UserSettings userSettings, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUserSettings(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.UserSettings userSettings, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM exercise_library WHERE category = :category AND isActive = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getActiveExercisesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.ExerciseLibrary>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM exercise_library WHERE isActive = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllActiveExercises(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.ExerciseLibrary>> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateExerciseLibrary(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.ExerciseLibrary exercise, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}