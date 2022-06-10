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

public final class ActivityCrapBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button CocktailshirimpButton;

  @NonNull
  public final Button CrapButton;

  @NonNull
  public final LinearLayout Crapview;

  @NonNull
  public final Button DaehaButton;

  @NonNull
  public final Button FlowercrapButton;

  @NonNull
  public final Button ShirimpButton;

  @NonNull
  public final ExtendedFloatingActionButton TorefButton;

  private ActivityCrapBinding(@NonNull CoordinatorLayout rootView,
      @NonNull Button CocktailshirimpButton, @NonNull Button CrapButton,
      @NonNull LinearLayout Crapview, @NonNull Button DaehaButton, @NonNull Button FlowercrapButton,
      @NonNull Button ShirimpButton, @NonNull ExtendedFloatingActionButton TorefButton) {
    this.rootView = rootView;
    this.CocktailshirimpButton = CocktailshirimpButton;
    this.CrapButton = CrapButton;
    this.Crapview = Crapview;
    this.DaehaButton = DaehaButton;
    this.FlowercrapButton = FlowercrapButton;
    this.ShirimpButton = ShirimpButton;
    this.TorefButton = TorefButton;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCrapBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCrapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_crap, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCrapBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CocktailshirimpButton;
      Button CocktailshirimpButton = ViewBindings.findChildViewById(rootView, id);
      if (CocktailshirimpButton == null) {
        break missingId;
      }

      id = R.id.CrapButton;
      Button CrapButton = ViewBindings.findChildViewById(rootView, id);
      if (CrapButton == null) {
        break missingId;
      }

      id = R.id.Crapview;
      LinearLayout Crapview = ViewBindings.findChildViewById(rootView, id);
      if (Crapview == null) {
        break missingId;
      }

      id = R.id.DaehaButton;
      Button DaehaButton = ViewBindings.findChildViewById(rootView, id);
      if (DaehaButton == null) {
        break missingId;
      }

      id = R.id.FlowercrapButton;
      Button FlowercrapButton = ViewBindings.findChildViewById(rootView, id);
      if (FlowercrapButton == null) {
        break missingId;
      }

      id = R.id.ShirimpButton;
      Button ShirimpButton = ViewBindings.findChildViewById(rootView, id);
      if (ShirimpButton == null) {
        break missingId;
      }

      id = R.id.TorefButton;
      ExtendedFloatingActionButton TorefButton = ViewBindings.findChildViewById(rootView, id);
      if (TorefButton == null) {
        break missingId;
      }

      return new ActivityCrapBinding((CoordinatorLayout) rootView, CocktailshirimpButton,
          CrapButton, Crapview, DaehaButton, FlowercrapButton, ShirimpButton, TorefButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
