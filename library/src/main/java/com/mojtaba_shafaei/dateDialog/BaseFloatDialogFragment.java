package com.mojtaba_shafaei.dateDialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.mojtaba_shafaei.com.library.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

/**
 * Created by mojtaba on 12/28/16.
 */
abstract class BaseFloatDialogFragment extends DialogFragment {

  boolean expanded = false;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }

  public void setExpanded(boolean expanded) {
    this.expanded = expanded;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Dialog d = super.onCreateDialog(savedInstanceState);
    setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogTheme);
    d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        d.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//        d.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    return d;
  }


  @Override
  public void onStart() {
    super.onStart();
    getDialog().getWindow()
        .setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
  }

  //public abstract void setListener(T listener);

  @Override
  abstract public void dismiss();
}
