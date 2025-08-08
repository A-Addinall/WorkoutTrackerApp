package com.example.workouttracker.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/workouttracker/ui/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnSaveSettings", "Landroid/widget/Button;", "etRestTime", "Landroid/widget/EditText;", "etWeightIncrement", "repository", "Lcom/example/workouttracker/data/repository/WorkoutRepository;", "getRepository", "()Lcom/example/workouttracker/data/repository/WorkoutRepository;", "repository$delegate", "Lkotlin/Lazy;", "spinnerUnits", "Landroid/widget/Spinner;", "switchDarkTheme", "Landroid/widget/Switch;", "switchShowPR", "initViews", "", "loadCurrentSettings", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveSettings", "setupClickListeners", "app_debug"})
public final class SettingsActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.Switch switchDarkTheme;
    private android.widget.EditText etWeightIncrement;
    private android.widget.EditText etRestTime;
    private android.widget.Spinner spinnerUnits;
    private android.widget.Switch switchShowPR;
    private android.widget.Button btnSaveSettings;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy repository$delegate = null;
    
    public SettingsActivity() {
        super();
    }
    
    private final com.example.workouttracker.data.repository.WorkoutRepository getRepository() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void loadCurrentSettings() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void saveSettings() {
    }
}