// Generated by view binder compiler. Do not edit!
package com.example.show_recipes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.show_recipes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainRecommendBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CheckBox china;

  @NonNull
  public final GridLayout country;

  @NonNull
  public final CheckBox easy;

  @NonNull
  public final CheckBox etc;

  @NonNull
  public final CheckBox hard;

  @NonNull
  public final CheckBox japan;

  @NonNull
  public final CheckBox korea;

  @NonNull
  public final GridLayout level;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final CheckBox longTime;

  @NonNull
  public final CheckBox middleTime;

  @NonNull
  public final CheckBox normal;

  @NonNull
  public final Button rec2Btn;

  @NonNull
  public final RecyclerView recyclerViewRecipesList;

  @NonNull
  public final CheckBox shortTime;

  @NonNull
  public final GridLayout time;

  @NonNull
  public final TextView totalRecipeCntId;

  @NonNull
  public final CheckBox western;

  private ActivityMainRecommendBinding(@NonNull LinearLayout rootView, @NonNull CheckBox china,
      @NonNull GridLayout country, @NonNull CheckBox easy, @NonNull CheckBox etc,
      @NonNull CheckBox hard, @NonNull CheckBox japan, @NonNull CheckBox korea,
      @NonNull GridLayout level, @NonNull LinearLayout linearLayout, @NonNull CheckBox longTime,
      @NonNull CheckBox middleTime, @NonNull CheckBox normal, @NonNull Button rec2Btn,
      @NonNull RecyclerView recyclerViewRecipesList, @NonNull CheckBox shortTime,
      @NonNull GridLayout time, @NonNull TextView totalRecipeCntId, @NonNull CheckBox western) {
    this.rootView = rootView;
    this.china = china;
    this.country = country;
    this.easy = easy;
    this.etc = etc;
    this.hard = hard;
    this.japan = japan;
    this.korea = korea;
    this.level = level;
    this.linearLayout = linearLayout;
    this.longTime = longTime;
    this.middleTime = middleTime;
    this.normal = normal;
    this.rec2Btn = rec2Btn;
    this.recyclerViewRecipesList = recyclerViewRecipesList;
    this.shortTime = shortTime;
    this.time = time;
    this.totalRecipeCntId = totalRecipeCntId;
    this.western = western;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainRecommendBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainRecommendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_recommend, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainRecommendBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.china;
      CheckBox china = ViewBindings.findChildViewById(rootView, id);
      if (china == null) {
        break missingId;
      }

      id = R.id.country;
      GridLayout country = ViewBindings.findChildViewById(rootView, id);
      if (country == null) {
        break missingId;
      }

      id = R.id.easy;
      CheckBox easy = ViewBindings.findChildViewById(rootView, id);
      if (easy == null) {
        break missingId;
      }

      id = R.id.etc;
      CheckBox etc = ViewBindings.findChildViewById(rootView, id);
      if (etc == null) {
        break missingId;
      }

      id = R.id.hard;
      CheckBox hard = ViewBindings.findChildViewById(rootView, id);
      if (hard == null) {
        break missingId;
      }

      id = R.id.japan;
      CheckBox japan = ViewBindings.findChildViewById(rootView, id);
      if (japan == null) {
        break missingId;
      }

      id = R.id.korea;
      CheckBox korea = ViewBindings.findChildViewById(rootView, id);
      if (korea == null) {
        break missingId;
      }

      id = R.id.level;
      GridLayout level = ViewBindings.findChildViewById(rootView, id);
      if (level == null) {
        break missingId;
      }

      LinearLayout linearLayout = (LinearLayout) rootView;

      id = R.id.long_time;
      CheckBox longTime = ViewBindings.findChildViewById(rootView, id);
      if (longTime == null) {
        break missingId;
      }

      id = R.id.middle_time;
      CheckBox middleTime = ViewBindings.findChildViewById(rootView, id);
      if (middleTime == null) {
        break missingId;
      }

      id = R.id.normal;
      CheckBox normal = ViewBindings.findChildViewById(rootView, id);
      if (normal == null) {
        break missingId;
      }

      id = R.id.rec_2_Btn;
      Button rec2Btn = ViewBindings.findChildViewById(rootView, id);
      if (rec2Btn == null) {
        break missingId;
      }

      id = R.id.recyclerView_recipes_list;
      RecyclerView recyclerViewRecipesList = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewRecipesList == null) {
        break missingId;
      }

      id = R.id.short_time;
      CheckBox shortTime = ViewBindings.findChildViewById(rootView, id);
      if (shortTime == null) {
        break missingId;
      }

      id = R.id.time;
      GridLayout time = ViewBindings.findChildViewById(rootView, id);
      if (time == null) {
        break missingId;
      }

      id = R.id.total_recipe_cnt_id;
      TextView totalRecipeCntId = ViewBindings.findChildViewById(rootView, id);
      if (totalRecipeCntId == null) {
        break missingId;
      }

      id = R.id.western;
      CheckBox western = ViewBindings.findChildViewById(rootView, id);
      if (western == null) {
        break missingId;
      }

      return new ActivityMainRecommendBinding((LinearLayout) rootView, china, country, easy, etc,
          hard, japan, korea, level, linearLayout, longTime, middleTime, normal, rec2Btn,
          recyclerViewRecipesList, shortTime, time, totalRecipeCntId, western);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
