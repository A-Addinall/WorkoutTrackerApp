package com.example.workouttracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ#\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0019\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!2\u0006\u0010\b\u001a\u00020\tH\'J\u001b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0018\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0!2\u0006\u0010\b\u001a\u00020\tH\'J\u001b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0!2\u0006\u0010\b\u001a\u00020\tH\'J#\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010,\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\'\u00100\u001a\b\u0012\u0004\u0012\u00020#0\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/J\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020.0\f2\u0006\u00102\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0013\u00103\u001a\u0004\u0018\u000104H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u00105\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\b\u00106\u001a\u00020\tH\'J\u0019\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u001f\u0010;\u001a\u00020\u00032\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J\u0019\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010@J\u0019\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020.H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010CJ\u0019\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u000204H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010FJ\u0019\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020#H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010IJ\u0019\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010LJ)\u0010M\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010OJ\u0019\u0010P\u001a\u00020\u00032\u0006\u00109\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010Q\u001a\u00020\u00032\u0006\u0010E\u001a\u000204H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010F\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/example/workouttracker/data/dao/WorkoutDao;", "", "deleteExercise", "", "exercise", "Lcom/example/workouttracker/data/entity/Exercise;", "(Lcom/example/workouttracker/data/entity/Exercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExerciseById", "exerciseId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveExercisesByCategory", "", "Lcom/example/workouttracker/data/entity/ExerciseLibrary;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveExercises", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPersonalRecords", "Lcom/example/workouttracker/data/entity/PersonalRecord;", "getAllWorkoutTypes", "Lcom/example/workouttracker/data/entity/WorkoutType;", "getExerciseById", "getExerciseByName", "workoutTypeId", "exerciseName", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExerciseLibraryCount", "getExercisesByWorkoutType", "getLastMetconTime", "", "getLastMetconTimeLiveData", "Landroidx/lifecycle/LiveData;", "getLastSession", "Lcom/example/workouttracker/data/entity/WorkoutSession;", "getLastSuccessfulWeightLiveData", "", "getLastWeightForExercise", "getLastWeightForExerciseLiveData", "getPersonalRecord", "type", "getPersonalRecordHistory", "getRecentPersonalRecords", "limit", "getRecentSets", "Lcom/example/workouttracker/data/entity/SetTracking;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentWorkoutSessions", "getSetsForSession", "sessionId", "getUserSettings", "Lcom/example/workouttracker/data/entity/UserSettings;", "getWorkoutTypeCount", "getWorkoutTypeCountSync", "insertExercise", "insertExerciseLibrary", "exerciseLibrary", "(Lcom/example/workouttracker/data/entity/ExerciseLibrary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExercises", "exercises", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPersonalRecord", "personalRecord", "(Lcom/example/workouttracker/data/entity/PersonalRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSetTracking", "setTracking", "(Lcom/example/workouttracker/data/entity/SetTracking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUserSettings", "userSettings", "(Lcom/example/workouttracker/data/entity/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutSession", "session", "(Lcom/example/workouttracker/data/entity/WorkoutSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWorkoutType", "workoutType", "(Lcom/example/workouttracker/data/entity/WorkoutType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDuplicateExercisesByName", "keepId", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExerciseLibrary", "updateUserSettings", "app_debug"})
@androidx.room.Dao
public abstract interface WorkoutDao {
    
    @androidx.room.Query(value = "SELECT * FROM workout_type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllWorkoutTypes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.workouttracker.data.entity.WorkoutType>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM workout_type")
    public abstract int getWorkoutTypeCountSync();
    
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
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExercise(@org.jetbrains.annotations.NotNull
    com.example.workouttracker.data.entity.Exercise exercise, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM exercise WHERE id = :exerciseId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExerciseById(int exerciseId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM exercise WHERE workoutTypeId = :workoutTypeId AND name = :exerciseName LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExerciseByName(int workoutTypeId, @org.jetbrains.annotations.NotNull
    java.lang.String exerciseName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.workouttracker.data.entity.Exercise> $completion);
    
    @androidx.room.Query(value = "DELETE FROM exercise WHERE workoutTypeId = :workoutTypeId AND name = :exerciseName AND id != :keepId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object removeDuplicateExercisesByName(int workoutTypeId, @org.jetbrains.annotations.NotNull
    java.lang.String exerciseName, int keepId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}