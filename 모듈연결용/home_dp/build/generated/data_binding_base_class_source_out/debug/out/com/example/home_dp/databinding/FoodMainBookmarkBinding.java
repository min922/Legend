// Generated by view binder compiler. Do not edit!
package com.example.home_dp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.home_dp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FoodMainBookmarkBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout ClickLayout;

  @NonNull
  public final TextView foodId;

  @NonNull
  public final TextView foodName;

  @NonNull
  public final ImageView foodPhotoImg;

  @NonNull
  public final TextView foodTime;

  @NonNull
  public final ImageButton starbutton;

  private FoodMainBookmarkBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout ClickLayout,
      @NonNull TextView foodId, @NonNull TextView foodName, @NonNull ImageView foodPhotoImg,
      @NonNull TextView foodTime, @NonNull ImageButton starbutton) {
    this.rootView = rootView;
    this.ClickLayout = ClickLayout;
    this.foodId = foodId;
    this.foodName = foodName;
    this.foodPhotoImg = foodPhotoImg;
    this.foodTime = foodTime;
    this.starbutton = starbutton;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FoodMainBookmarkBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FoodMainBookmarkBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.food_main_bookmark, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FoodMainBookmarkBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ClickLayout;
      LinearLayout ClickLayout = ViewBindings.findChildViewById(rootView, id);
      if (ClickLayout == null) {
        break missingId;
      }

      id = R.id.foodId;
      TextView foodId = ViewBindings.findChildViewById(rootView, id);
      if (foodId == null) {
        break missingId;
      }

      id = R.id.foodName;
      TextView foodName = ViewBindings.findChildViewById(rootView, id);
      if (foodName == null) {
        break missingId;
      }

      id = R.id.foodPhotoImg;
      ImageView foodPhotoImg = ViewBindings.findChildViewById(rootView, id);
      if (foodPhotoImg == null) {
        break missingId;
      }

      id = R.id.foodTime;
      TextView foodTime = ViewBindings.findChildViewById(rootView, id);
      if (foodTime == null) {
        break missingId;
      }

      id = R.id.starbutton;
      ImageButton starbutton = ViewBindings.findChildViewById(rootView, id);
      if (starbutton == null) {
        break missingId;
      }

      return new FoodMainBookmarkBinding((FrameLayout) rootView, ClickLayout, foodId, foodName,
          foodPhotoImg, foodTime, starbutton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
