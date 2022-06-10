// Generated by view binder compiler. Do not edit!
package com.example.main_dp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.main_dp.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFishMidBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button ClammidButton;

  @NonNull
  public final Button CrapmidButton;

  @NonNull
  public final Button FishetcButton;

  @NonNull
  public final Button FishmidButton;

  @NonNull
  public final Button HaejoryuButton;

  @NonNull
  public final ExtendedFloatingActionButton TorefButton;

  @NonNull
  public final LinearLayout fishMidview;

  private ActivityFishMidBinding(@NonNull CoordinatorLayout rootView, @NonNull Button ClammidButton,
      @NonNull Button CrapmidButton, @NonNull Button FishetcButton, @NonNull Button FishmidButton,
      @NonNull Button HaejoryuButton, @NonNull ExtendedFloatingActionButton TorefButton,
      @NonNull LinearLayout fishMidview) {
    this.rootView = rootView;
    this.ClammidButton = ClammidButton;
    this.CrapmidButton = CrapmidButton;
    this.FishetcButton = FishetcButton;
    this.FishmidButton = FishmidButton;
    this.HaejoryuButton = HaejoryuButton;
    this.TorefButton = TorefButton;
    this.fishMidview = fishMidview;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFishMidBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFishMidBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_fish_mid, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFishMidBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ClammidButton;
      Button ClammidButton = ViewBindings.findChildViewById(rootView, id);
      if (ClammidButton == null) {
        break missingId;
      }

      id = R.id.CrapmidButton;
      Button CrapmidButton = ViewBindings.findChildViewById(rootView, id);
      if (CrapmidButton == null) {
        break missingId;
      }

      id = R.id.FishetcButton;
      Button FishetcButton = ViewBindings.findChildViewById(rootView, id);
      if (FishetcButton == null) {
        break missingId;
      }

      id = R.id.FishmidButton;
      Button FishmidButton = ViewBindings.findChildViewById(rootView, id);
      if (FishmidButton == null) {
        break missingId;
      }

      id = R.id.HaejoryuButton;
      Button HaejoryuButton = ViewBindings.findChildViewById(rootView, id);
      if (HaejoryuButton == null) {
        break missingId;
      }

      id = R.id.TorefButton;
      ExtendedFloatingActionButton TorefButton = ViewBindings.findChildViewById(rootView, id);
      if (TorefButton == null) {
        break missingId;
      }

      id = R.id.fishMidview;
      LinearLayout fishMidview = ViewBindings.findChildViewById(rootView, id);
      if (fishMidview == null) {
        break missingId;
      }

      return new ActivityFishMidBinding((CoordinatorLayout) rootView, ClammidButton, CrapmidButton,
          FishetcButton, FishmidButton, HaejoryuButton, TorefButton, fishMidview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
