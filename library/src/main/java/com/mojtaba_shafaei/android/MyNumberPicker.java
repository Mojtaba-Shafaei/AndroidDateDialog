package com.mojtaba_shafaei.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

class MyNumberPicker extends NumberPicker {

  private boolean showNumberAsPersian = false;

  public MyNumberPicker(Context context) {
    super(context);
  }

  public MyNumberPicker(Context context, AttributeSet attrs) {
    super(context, attrs);
    readAttrs(context, attrs);
  }

  public MyNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    readAttrs(context, attrs);
  }

  @TargetApi(21)
  public MyNumberPicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    readAttrs(context, attrs);
  }

  private void readAttrs(Context context, AttributeSet attrs) {
    showNumberAsPersian = true;
  }

  @Override
  public void addView(View child) {
    super.addView(child);
    updateView(child);
  }

  @Override
  public void addView(View child, int index) {
    super.addView(child, index);
    updateView(child);
  }

  @Override
  public void addView(View child, int index, ViewGroup.LayoutParams params) {
    super.addView(child, index, params);
    updateView(child);
  }

  @Override
  public void addView(View child, ViewGroup.LayoutParams params) {
    super.addView(child, params);
    updateView(child);
  }

  @Override
  public void addView(View child, int width, int height) {
    super.addView(child, width, height);
    updateView(child);
  }

  private void updateView(View v) {
    //todo
    /*if (!=null){
      if (v instanceof EditText) {
        EditText editText = ((EditText) v);
        editText.setTypeface(
            FontTypeFace.getInstance().getTypeface(getContext(), FontTypeFace.IRANSANS_BOLD));
        editText.setTextColor(getResources().getColor(R.color.textPrimaryColor));
        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX,
            getResources().getDimensionPixelSize(R.dimen.text_size_number_picker));
      }
    }*/
  }
}
