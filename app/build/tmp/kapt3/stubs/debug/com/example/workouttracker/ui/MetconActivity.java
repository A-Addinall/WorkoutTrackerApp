package com.example.workouttracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0012\u0010&\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\"H\u0014J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/example/workouttracker/ui/MetconActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnComplete", "Landroid/widget/Button;", "btnReset", "btnStartStop", "isRunning", "", "layoutMetconExercises", "Landroid/widget/LinearLayout;", "metconExercises", "", "Lcom/example/workouttracker/data/entity/Exercise;", "startTime", "", "timeElapsedMs", "timer", "Landroid/os/CountDownTimer;", "tvLastTime", "Landroid/widget/TextView;", "tvTimer", "tvWorkoutTitle", "workoutName", "", "workoutTypeId", "", "workoutViewModel", "Lcom/example/workouttracker/ui/WorkoutViewModel;", "getWorkoutViewModel", "()Lcom/example/workouttracker/ui/WorkoutViewModel;", "workoutViewModel$delegate", "Lkotlin/Lazy;", "completeMetcon", "", "displayMetconExercises", "initViews", "loadMetconData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "resetTimer", "setupObservers", "startTimer", "stopTimer", "updateTimerDisplay", "app_debug"})
public final class MetconActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy workoutViewModel$delegate = null;
    private android.widget.LinearLayout layoutMetconExercises;
    private android.widget.TextView tvWorkoutTitle;
    private android.widget.TextView tvTimer;
    private android.widget.Button btnStartStop;
    private android.widget.Button btnReset;
    private android.widget.Button btnComplete;
    private android.widget.TextView tvLastTime;
    private int workoutTypeId = 1;
    @org.jetbrains.annotations.NotNull
    private java.lang.String workoutName = "";
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.workouttracker.data.entity.Exercise> metconExercises;
    @org.jetbrains.annotations.Nullable
    private android.os.CountDownTimer timer;
    private boolean isRunning = false;
    private long timeElapsedMs = 0L;
    private long startTime = 0L;
    
    public MetconActivity() {
        super();
    }
    
    private final com.example.workouttracker.ui.WorkoutViewModel getWorkoutViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setupObservers() {
    }
    
    private final void loadMetconData() {
    }
    
    private final void displayMetconExercises() {
    }
    
    private final void startTimer() {
    }
    
    private final void stopTimer() {
    }
    
    private final void resetTimer() {
    }
    
    private final void updateTimerDisplay() {
    }
    
    private final void completeMetcon() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}