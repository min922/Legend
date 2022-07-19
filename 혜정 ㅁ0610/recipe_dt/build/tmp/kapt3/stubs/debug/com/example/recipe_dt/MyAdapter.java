package com.example.recipe_dt;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/example/recipe_dt/MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/recipe_dt/MyAdapter$Holder;", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lcom/example/recipe_dt/Ingre;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "recipe_dt_debug"})
public final class MyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.recipe_dt.MyAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.recipe_dt.Ingre> list = null;
    
    public MyAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.recipe_dt.Ingre> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.recipe_dt.Ingre> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.recipe_dt.MyAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.recipe_dt.MyAdapter.Holder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/example/recipe_dt/MyAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/recipe_dt/MyAdapter;Landroid/view/View;)V", "db_firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDb_firestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "foodId", "Landroid/widget/TextView;", "getFoodId", "()Landroid/widget/TextView;", "ingreId", "getIngreId", "ingreName", "getIngreName", "ingrePhoto", "Landroid/widget/ImageView;", "getIngrePhoto", "()Landroid/widget/ImageView;", "starButton", "Landroid/widget/ImageButton;", "getStarButton", "()Landroid/widget/ImageButton;", "bind", "", "ingre", "Lcom/example/recipe_dt/Ingre;", "context", "Landroid/content/Context;", "recipe_dt_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private final android.widget.ImageView ingrePhoto = null;
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView ingreName = null;
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView ingreId = null;
        @org.jetbrains.annotations.Nullable()
        private final android.widget.ImageButton starButton = null;
        @org.jetbrains.annotations.NotNull()
        private final com.google.firebase.firestore.FirebaseFirestore db_firestore = null;
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView foodId = null;
        
        public Holder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageView getIngrePhoto() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getIngreName() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getIngreId() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.recipe_dt.Ingre ingre, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageButton getStarButton() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.firebase.firestore.FirebaseFirestore getDb_firestore() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getFoodId() {
            return null;
        }
    }
}