package com.example.recipe_dt;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/recipe_dt/RecipeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "explainlist", "Ljava/util/ArrayList;", "Lcom/example/recipe_dt/Recipe;", "getExplainlist", "()Ljava/util/ArrayList;", "inputEditText", "Landroid/widget/EditText;", "getInputEditText", "()Landroid/widget/EditText;", "setInputEditText", "(Landroid/widget/EditText;)V", "isRunning", "", "minTextView", "Landroid/widget/TextView;", "getMinTextView", "()Landroid/widget/TextView;", "setMinTextView", "(Landroid/widget/TextView;)V", "secTextView", "getSecTextView", "setSecTextView", "time", "", "timerSettingButton", "Landroid/widget/Button;", "getTimerSettingButton", "()Landroid/widget/Button;", "setTimerSettingButton", "(Landroid/widget/Button;)V", "timerTask", "Ljava/util/Timer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "recipe_dt_debug"})
public final class RecipeActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.recipe_dt.Recipe> explainlist = null;
    private int time = 0;
    private java.util.Timer timerTask;
    private boolean isRunning = false;
    public android.widget.TextView minTextView;
    public android.widget.TextView secTextView;
    public android.widget.Button timerSettingButton;
    public android.widget.EditText inputEditText;
    private java.util.HashMap _$_findViewCache;
    
    public RecipeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.recipe_dt.Recipe> getExplainlist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getMinTextView() {
        return null;
    }
    
    public final void setMinTextView(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getSecTextView() {
        return null;
    }
    
    public final void setSecTextView(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getTimerSettingButton() {
        return null;
    }
    
    public final void setTimerSettingButton(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getInputEditText() {
        return null;
    }
    
    public final void setInputEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
}