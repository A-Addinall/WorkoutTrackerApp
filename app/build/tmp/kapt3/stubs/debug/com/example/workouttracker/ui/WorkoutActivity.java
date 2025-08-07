package com.example.workouttracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0016\u0010\u001a\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\""}, d2 = {"Lcom/example/workouttracker/ui/WorkoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "layoutExercises", "Landroid/widget/LinearLayout;", "tvWorkoutTitle", "Landroid/widget/TextView;", "workoutName", "", "workoutTypeId", "", "workoutViewModel", "Lcom/example/workouttracker/ui/WorkoutViewModel;", "getWorkoutViewModel", "()Lcom/example/workouttracker/ui/WorkoutViewModel;", "workoutViewModel$delegate", "Lkotlin/Lazy;", "addExerciseCard", "", "exercise", "Lcom/example/workouttracker/data/entity/Exercise;", "addMetconCard", "exercises", "", "addSectionTitle", "title", "displayExercises", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupObservers", "startExerciseDetailActivity", "startMetconActivity", "app_debug"})
public final class WorkoutActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy workoutViewModel$delegate = null;
    private android.widget.LinearLayout layoutExercises;
    private android.widget.TextView tvWorkoutTitle;
    private int workoutTypeId = 1;
    @org.jetbrains.annotations.NotNull
    private java.lang.String workoutName = "";
    
    public WorkoutActivity() {
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
    
    private final void displayExercises(java.util.List<com.example.workouttracker.data.entity.Exercise> exercises) {
    }
    
    private final void addSectionTitle(java.lang.String title) {
    }
    
    private final void addExerciseCard(com.example.workouttracker.data.entity.Exercise exercise) {
    }
    
    private final void addMetconCard(java.util.List<com.example.workouttracker.data.entity.Exercise> exercises) {
    }
    
    private final void startExerciseDetailActivity(com.example.workouttracker.data.entity.Exercise exercise) {
    }
    
    private final void startMetconActivity() {
    }
}