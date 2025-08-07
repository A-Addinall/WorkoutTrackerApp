package com.example.workouttracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/workouttracker/ui/ExerciseDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnAddSet", "Landroid/widget/Button;", "btnCompleteExercise", "currentSets", "", "Lcom/example/workouttracker/ui/ExerciseDetailActivity$SetData;", "etNotes", "Landroid/widget/EditText;", "exerciseId", "", "exerciseName", "", "layoutSets", "Landroid/widget/LinearLayout;", "repRange", "tvExerciseName", "Landroid/widget/TextView;", "tvLastWeight", "tvSuggestedWeight", "workoutViewModel", "Lcom/example/workouttracker/ui/WorkoutViewModel;", "getWorkoutViewModel", "()Lcom/example/workouttracker/ui/WorkoutViewModel;", "workoutViewModel$delegate", "Lkotlin/Lazy;", "addNewSet", "", "completeExercise", "extractTargetReps", "initViews", "loadInitialData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupObservers", "SetData", "app_debug"})
public final class ExerciseDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy workoutViewModel$delegate = null;
    private android.widget.TextView tvExerciseName;
    private android.widget.TextView tvLastWeight;
    private android.widget.TextView tvSuggestedWeight;
    private android.widget.LinearLayout layoutSets;
    private android.widget.Button btnAddSet;
    private android.widget.Button btnCompleteExercise;
    private android.widget.EditText etNotes;
    private int exerciseId = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String exerciseName = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String repRange = "";
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.workouttracker.ui.ExerciseDetailActivity.SetData> currentSets;
    
    public ExerciseDetailActivity() {
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
    
    private final void loadInitialData() {
    }
    
    private final void addNewSet() {
    }
    
    private final void completeExercise() {
    }
    
    private final int extractTargetReps(java.lang.String repRange) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/example/workouttracker/ui/ExerciseDetailActivity$SetData;", "", "setNumber", "", "etWeight", "Landroid/widget/EditText;", "etReps", "isSuccessful", "", "(ILandroid/widget/EditText;Landroid/widget/EditText;Ljava/lang/Boolean;)V", "getEtReps", "()Landroid/widget/EditText;", "getEtWeight", "()Ljava/lang/Boolean;", "setSuccessful", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSetNumber", "()I", "component1", "component2", "component3", "component4", "copy", "(ILandroid/widget/EditText;Landroid/widget/EditText;Ljava/lang/Boolean;)Lcom/example/workouttracker/ui/ExerciseDetailActivity$SetData;", "equals", "other", "hashCode", "toString", "", "app_debug"})
    public static final class SetData {
        private final int setNumber = 0;
        @org.jetbrains.annotations.NotNull
        private final android.widget.EditText etWeight = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.EditText etReps = null;
        @org.jetbrains.annotations.Nullable
        private java.lang.Boolean isSuccessful;
        
        public SetData(int setNumber, @org.jetbrains.annotations.NotNull
        android.widget.EditText etWeight, @org.jetbrains.annotations.NotNull
        android.widget.EditText etReps, @org.jetbrains.annotations.Nullable
        java.lang.Boolean isSuccessful) {
            super();
        }
        
        public final int getSetNumber() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.EditText getEtWeight() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.EditText getEtReps() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Boolean isSuccessful() {
            return null;
        }
        
        public final void setSuccessful(@org.jetbrains.annotations.Nullable
        java.lang.Boolean p0) {
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.EditText component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.EditText component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Boolean component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.workouttracker.ui.ExerciseDetailActivity.SetData copy(int setNumber, @org.jetbrains.annotations.NotNull
        android.widget.EditText etWeight, @org.jetbrains.annotations.NotNull
        android.widget.EditText etReps, @org.jetbrains.annotations.Nullable
        java.lang.Boolean isSuccessful) {
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