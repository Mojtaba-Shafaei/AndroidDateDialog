package com.mojtaba_shafaei.android.dateDialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

class MyNumberPicker extends NumberPicker {

  private Typeface typeface;

  private Typeface getTypeface(Context context) {
    if (typeface == null) {
      typeface = Typeface.createFromAsset(context.getAssets(), "iransans_medium.ttf");
    }
    return typeface;
  }

  public MyNumberPicker(Context context) {
    super(context);
    init(context);
  }

  public MyNumberPicker(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public MyNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  @TargetApi(21)
  public MyNumberPicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context);
  }


  private void init(Context context) {

  }

  private void setTypeface(Typeface typeface, final View v) {
    try {
      if (v instanceof ViewGroup) {
        ViewGroup vg = (ViewGroup) v;
        for (int i = 0; i < vg.getChildCount(); i++) {
          View child = vg.getChildAt(i);
          setTypeface(typeface, child);
        }
      } else if (v instanceof TextView) {
        TextView textView = (TextView) v;
        textView.setTypeface(typeface);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
      }
    } catch (Exception e) {
      Log.e("MyNumberPicker", "setTypeface: ", e);
    }
  }

  @Override
  public void addView(View child) {
    super.addView(child);
    setTypeface(getTypeface(child.getContext()), child);
  }

  @Override
  public void addView(View child, int index) {
    super.addView(child, index);
    setTypeface(getTypeface(child.getContext()), child);
  }

  @Override
  public void addView(View child, int width, int height) {
    super.addView(child, width, height);
    setTypeface(getTypeface(child.getContext()), child);
  }

  @Override
  public void addView(View child, ViewGroup.LayoutParams params) {
    super.addView(child, params);
    setTypeface(getTypeface(child.getContext()), child);
  }

  @Override
  public void addView(View child, int index, ViewGroup.LayoutParams params) {
    super.addView(child, index, params);
    setTypeface(getTypeface(child.getContext()), child);
  }
}
