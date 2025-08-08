package com.example.workouttracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0015\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\'J#\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010%\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\'\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\'\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020\'0\u00032\u0006\u0010+\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010,\u001a\u0004\u0018\u00010-H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010.\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0019\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J\u001f\u00106\u001a\u0002002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J\u0019\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J\u0019\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020\'H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J\u0019\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020-H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ\u0019\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010GJ\u0019\u0010H\u001a\u0002002\u0006\u00104\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J\u0019\u0010I\u001a\u0002002\u0006\u0010@\u001a\u00020-H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010A\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006J"}, d2 = {"Lcom/example/workouttracker/data/dao/WorkoutDao;", "", "getActiveExercisesByCategory", "", "Lcom/example/workouttracker/data/entity/ExerciseLibrary;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveExercises", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPersonalRecords", "Lcom/example/workouttracker/data/entity/PersonalRecord;", "getAllWorkoutTypes", "Lcom/example/workouttracker/data/entity/WorkoutType;", "getExerciseById", "Lcom/example/workouttracker/data/entity/Exercise;", "exerciseId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExerciseLibraryCount", "getExercisesByWorkoutType", "workoutTypeId", "getLastMetconTime", "", "getLastMetconTimeLiveData", "Landroidx/lifecycle/LiveData;", "getLastSession", "Lcom/example/workouttracker/data/entity/WorkoutSession;", "getLastSuccessfulWeightLiveData", "", "getLastWeightForExercise", "getLastWeightForExerciseLiveData", "getPersonalRecord", "type", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPersonalRecordHistory", "getRecentPersonalRecords", "limit", "getRecentSets", "Lcom/example/workouttracker/data/entity/SetTracking;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentWorkoutSessions", "getSetsForSession", "sessionId", "getUserSettings", "Lcom/example/workouttracker/data/entity/UserSettings;", "getWorkoutTypeCount", "insertExercise", "", "exercise", "(Lcom/example/workouttracker/data/entity/Exercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExerciseLibrary", "exerciseLibrary", "(Lcom/example/workouttracker/data/entity/ExerciseLibrary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExercises", "exercises", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPersonalRecord", "personalRecord", "(Lcom/example/workouttracker/data/entity/PersonalRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSetTracking", "setTracking", "(Lcom/example/workouttracker/data/entity/SetTracking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserSettings", "userSettings", "(Lcom/example/workouttracker/data/entity/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutSession", "session", "(Lcom/example/workouttracker/data/entity/WorkoutSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutType", "workoutType", "(Lcom/example/workouttracker/data/entity/WorkoutType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExerciseLibrary", "updateUserSettings", "app_debug"})
@androidx.room.Dao
public abstract interface WorkoutDao {
    
    @androidx.room.Query(value = "SELECT * FROM workout_type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllWorkoutTypes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.WorkoutType>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM workout_type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getWorkoutTypeCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
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
    public abstract java.lang.Object insertExercises(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.workouttracker.data.entity.Exercise> exercises, @org.jetbrains.annotations.NotNull
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
    
    @androidx.room.Query(value = "SELECT time FROM workout_session WHERE exerciseId = :exerciseId AND time IS NOT NULL ORDER BY date DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.lang.Long> getLastMetconTimeLiveData(int exerciseId);
    
    @androidx.room.Query(value = "SELECT * FROM workout_session WHERE exerciseId = :exerciseId AND weight IS NOT NULL ORDER BY date DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecentWorkoutSessions(int exerciseId, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.WorkoutSession>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertSetTracking(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.SetTracking setTracking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM set_tracking WHERE exerciseId = :exerciseId ORDER BY id DESC LIMIT :limit")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecentSets(int exerciseId, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.SetTracking>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM set_tracking WHERE workoutSessionId = :sessionId")
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
    
    @androidx.room.Query(value = "SELECT * FROM personal_record WHERE exerciseId = :exerciseId AND recordType = :type ORDER BY value DESC LIMIT 1")
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
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM exercise_library")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExerciseLibraryCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExerciseLibrary(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.ExerciseLibrary exerciseLibrary, @org.jetbrains.annotations.NotNull
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
    com.example.workouttracker.data.entity.ExerciseLibrary exerciseLibrary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT weight FROM set_tracking WHERE exerciseId = :exerciseId AND isSuccessful = 1 AND weight IS NOT NULL ORDER BY weight DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.lang.Double> getLastSuccessfulWeightLiveData(int exerciseId);
    
    @androidx.room.Query(value = "SELECT pr.* FROM personal_record pr\n    INNER JOIN (\n        SELECT exerciseId, MAX(value) as maxValue \n        FROM personal_record \n        WHERE recordType = \'max_weight\'\n        GROUP BY exerciseId\n    ) latest ON pr.exerciseId = latest.exerciseId AND pr.value = latest.maxValue\n    WHERE pr.recordType = \'max_weight\'\n    ORDER BY pr.date DESC \n    LIMIT :limit")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecentPersonalRecords(int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.PersonalRecord>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM personal_record ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllPersonalRecords(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.PersonalRecord>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM exercise WHERE id = :exerciseId LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExerciseById(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.Exercise> $completion);
}