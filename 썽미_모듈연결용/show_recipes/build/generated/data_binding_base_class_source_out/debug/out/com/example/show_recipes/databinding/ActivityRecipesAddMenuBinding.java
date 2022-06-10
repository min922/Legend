// Generated by view binder compiler. Do not edit!
package com.example.show_recipes.databinding;

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
import com.example.show_recipes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRecipesAddMenuBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton btnSelector;

  @NonNull
  public final ImageView dateGreen;

  @NonNull
  public final ImageView dateRed;

  @NonNull
  public final ImageView dateYellow;

  @NonNull
  public final FrameLayout menu;

  @NonNull
  public final TextView menuCountry;

  @NonNull
  public final TextView menuId;

  @NonNull
  public final ImageButton menuImage;

  @NonNull
  public final TextView menuLevel;

  @NonNull
  public final TextView menuName;

  @NonNull
  public final TextView menuTime;

  private ActivityRecipesAddMenuBinding(@NonNull LinearLayout rootView,
      @NonNull ImageButton btnSelector, @NonNull ImageView dateGreen, @NonNull ImageView dateRed,
      @NonNull ImageView dateYellow, @NonNull FrameLayout menu, @NonNull TextView menuCountry,
      @NonNull TextView menuId, @NonNull ImageButton menuImage, @NonNull TextView menuLevel,
      @NonNull TextView menuName, @NonNull TextView menuTime) {
    this.rootView = rootView;
    this.btnSelector = btnSelector;
    this.dateGreen = dateGreen;
    this.dateRed = dateRed;
    this.dateYellow = dateYellow;
    this.menu = menu;
    this.menuCountry = menuCountry;
    this.menuId = menuId;
    this.menuImage = menuImage;
    this.menuLevel = menuLevel;
    this.menuName = menuName;
    this.menuTime = menuTime;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRecipesAddMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRecipesAddMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_recipes_add_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRecipesAddMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_selector;
      ImageButton btnSelector = ViewBindings.findChildViewById(rootView, id);
      if (btnSelector == null) {
        break missingId;
      }

      id = R.id.date_green;
      ImageView dateGreen = ViewBindings.findChildViewById(rootView, id);
      if (dateGreen == null) {
        break missingId;
      }

      id = R.id.date_red;
      ImageView dateRed = ViewBindings.findChildViewById(rootView, id);
      if (dateRed == null) {
        break missingId;
      }

      id = R.id.date_yellow;
      ImageView dateYellow = ViewBindings.findChildViewById(rootView, id);
      if (dateYellow == null) {
        break missingId;
      }

      id = R.id.menu;
      FrameLayout menu = ViewBindings.findChildViewById(rootView, id);
      if (menu == null) {
        break missingId;
      }

      id = R.id.menu_country;
      TextView menuCountry = ViewBindings.findChildViewById(rootView, id);
      if (menuCountry == null) {
        break missingId;
      }

      id = R.id.menu_id;
      TextView menuId = ViewBindings.findChildViewById(rootView, id);
      if (menuId == null) {
        break missingId;
      }

      id = R.id.menu_image;
      ImageButton menuImage = ViewBindings.findChildViewById(rootView, id);
      if (menuImage == null) {
        break missingId;
      }

      id = R.id.menu_level;
      TextView menuLevel = ViewBindings.findChildViewById(rootView, id);
      if (menuLevel == null) {
        break missingId;
      }

      id = R.id.menu_name;
      TextView menuName = ViewBindings.findChildViewById(rootView, id);
      if (menuName == null) {
        break missingId;
      }

      id = R.id.menu_time;
      TextView menuTime = ViewBindings.findChildViewById(rootView, id);
      if (menuTime == null) {
        break missingId;
      }

      return new ActivityRecipesAddMenuBinding((LinearLayout) rootView, btnSelector, dateGreen,
          dateRed, dateYellow, menu, menuCountry, menuId, menuImage, menuLevel, menuName, menuTime);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
