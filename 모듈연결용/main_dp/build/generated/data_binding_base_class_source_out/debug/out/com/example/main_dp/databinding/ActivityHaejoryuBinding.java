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

public final class ActivityHaejoryuBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button DashimaButton;

  @NonNull
  public final Button GimButton;

  @NonNull
  public final Button HaechoButton;

  @NonNull
  public final LinearLayout Haejoview;

  @NonNull
  public final Button ParaeButton;

  @NonNull
  public final Button SeaweedButton;

  @NonNull
  public final ExtendedFloatingActionButton TorefButton;

  @NonNull
  public final Button womukButton;

  private ActivityHaejoryuBinding(@NonNull CoordinatorLayout rootView,
      @NonNull Button DashimaButton, @NonNull Button GimButton, @NonNull Button HaechoButton,
      @NonNull LinearLayout Haejoview, @NonNull Button ParaeButton, @NonNull Button SeaweedButton,
      @NonNull ExtendedFloatingActionButton TorefButton, @NonNull Button womukButton) {
    this.rootView = rootView;
    this.DashimaButton = DashimaButton;
    this.GimButton = GimButton;
    this.HaechoButton = HaechoButton;
    this.Haejoview = Haejoview;
    this.ParaeButton = ParaeButton;
    this.SeaweedButton = SeaweedButton;
    this.TorefButton = TorefButton;
    this.womukButton = womukButton;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHaejoryuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHaejoryuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_haejoryu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHaejoryuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.DashimaButton;
      Button DashimaButton = ViewBindings.findChildViewById(rootView, id);
      if (DashimaButton == null) {
        break missingId;
      }

      id = R.id.GimButton;
      Button GimButton = ViewBindings.findChildViewById(rootView, id);
      if (GimButton == null) {
        break missingId;
      }

      id = R.id.HaechoButton;
      Button HaechoButton = ViewBindings.findChildViewById(rootView, id);
      if (HaechoButton == null) {
        break missingId;
      }

      id = R.id.Haejoview;
      LinearLayout Haejoview = ViewBindings.findChildViewById(rootView, id);
      if (Haejoview == null) {
        break missingId;
      }

      id = R.id.ParaeButton;
      Button ParaeButton = ViewBindings.findChildViewById(rootView, id);
      if (ParaeButton == null) {
        break missingId;
      }

      id = R.id.SeaweedButton;
      Button SeaweedButton = ViewBindings.findChildViewById(rootView, id);
      if (SeaweedButton == null) {
        break missingId;
      }

      id = R.id.TorefButton;
      ExtendedFloatingActionButton TorefButton = ViewBindings.findChildViewById(rootView, id);
      if (TorefButton == null) {
        break missingId;
      }

      id = R.id.womukButton;
      Button womukButton = ViewBindings.findChildViewById(rootView, id);
      if (womukButton == null) {
        break missingId;
      }

      return new ActivityHaejoryuBinding((CoordinatorLayout) rootView, DashimaButton, GimButton,
          HaechoButton, Haejoview, ParaeButton, SeaweedButton, TorefButton, womukButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
