package com.mojtaba_shafaei.android.dateDialog;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.mojtaba_shafaei.android.dateDialog.calendar.CivilDate;
import com.mojtaba_shafaei.android.dateDialog.calendar.DateConverter;
import com.mojtaba_shafaei.android.dateDialog.calendar.PersianDate;
import com.mojtaba_shafaei.android.library.R;

/**
 * Created by mojtaba on 5/9/16.
 */

public class DateDialog extends AlertDialog implements OnClickListener {

  private final String TAG = "DateDialog";

  private MyNumberPicker year, month, day;
  private TextView title;

  private Params params;

  /*********************************************/
  public DateDialog(@NonNull Context context) {
    super(context);
  }

  /*********************************************/

  private void onCreated() {
    try {
      int currentYear;
      int currentMonth;
      Integer currentDay = null;

      if (params.defaultDate == null) {
        //String d = PersianDate.getPersianDate(new Date(), ';');
        PersianDate persianDate = DateConverter.civilToPersian(new CivilDate());
        currentYear = persianDate.getYear();
        currentMonth = persianDate.getMonth();
        currentDay = persianDate.getDayOfMonth();

      } else {
        currentYear = params.defaultDate.getYear();
        currentMonth = params.defaultDate.getMonth();
        if (params.defaultDate.getDay() != null) {
          currentDay = params.defaultDate.getDay();
        }
      }

      year.setMinValue(1300);
      year.setMaxValue(2040);
      year.setValue(currentYear);

      month.setMinValue(1);
      month.setMaxValue(12);
      month.setDisplayedValues(getContext().getResources().getStringArray(R.array.month_names));
      month.setValue(currentMonth);

      day.setMinValue(1);
      day.setMaxValue(31);

      if (currentDay != null) {
        day.setValue(currentDay);
      }

      if (params.mode == DateMode.SHORT) {
        day.setVisibility(View.GONE);
      }

    } catch (Exception e) {
      Log.e(TAG, "onCreated: ", e);
    }
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.btn_select) {
      MyDate date = new MyDate(year.getValue()
          , month.getValue()
          , DateMode.SHORT == params.mode ? null : day.getValue());

      if (params.positiveButtonListener != null) {
        params.positiveButtonListener.onDateSelect(date);
      }

      dismiss();

    } else if (v.getId() == R.id.btn_cancel) {
      if (params.negativeButtonListener != null) {
        params.negativeButtonListener.onClick(v);
      }
      dismiss();
    }
  }

  @Override
  public void show() {
    View root = LayoutInflater.from(getContext()).inflate(R.layout.dialog_date_picker, null);
    year = root.findViewById(R.id.year_picker);
    month = root.findViewById(R.id.month_picker);
    day = root.findViewById(R.id.dayPicker);

    title = root.findViewById(R.id.tv_title);
    if (params.title != null) {
      title.setText(params.title);
    }

    AppCompatButton positiveButton = root.findViewById(R.id.btn_select);
    if (params.positiveButtonTitle != null) {
      positiveButton.setText(params.positiveButtonTitle);
    }
    positiveButton.setOnClickListener(this);

    AppCompatButton negativeButton = root.findViewById(R.id.btn_cancel);
    negativeButton.setOnClickListener(this);
    if (params.negativeButtonTitle != null) {
      negativeButton.setText(params.negativeButtonTitle);
    }

    if (params.defaultTypeface != null) {
      title.setTypeface(params.defaultTypeface);

      positiveButton.setTypeface(params.defaultTypeface);
      negativeButton.setTypeface(params.defaultTypeface);
    }

    setCancelable(params.cancelable);
    setView(root);
    onCreated();

    super.show();
  }

  private static final class Params {

    private CharSequence title = null, message = null;
    private CharSequence positiveButtonTitle;
    private OnDateSelectListener positiveButtonListener;
    private CharSequence negativeButtonTitle;
    private View.OnClickListener negativeButtonListener;
    private boolean cancelable = true;
    private Typeface defaultTypeface = null;

    private MyDate defaultDate;
    private @DateMode
    int mode;
  }

  public static Builder newBuilder(Context context) {
    return new Builder(context);
  }

  public static class Builder {

    Params p = new Params();
    DateDialog dateDialog = null;

    private Builder(Context context) {
      dateDialog = new DateDialog(context);
    }

    public Builder withTitle(CharSequence title) {
      p.title = title;
      return this;
    }

    public Builder withMessage(CharSequence message) {
      p.message = message;
      return this;
    }

    public Builder withPositiveButton(CharSequence title,
        OnDateSelectListener positiveButtonListener) {
      p.positiveButtonTitle = title;
      p.positiveButtonListener = positiveButtonListener;
      return this;
    }

    public Builder withNegativeButton(CharSequence title,
        View.OnClickListener negativeButtonListener) {
      p.negativeButtonTitle = title;
      p.negativeButtonListener = negativeButtonListener;
      return this;
    }

    public Builder withCancelable(boolean cancelable) {
      p.cancelable = cancelable;
      return this;
    }

    public Builder withMode(@DateMode int mode) {
      p.mode = mode;
      return this;
    }

    public Builder withDefaultDate(MyDate defaultDate) {
      p.defaultDate = defaultDate;
      return this;
    }

    public Builder withDefaultTypeface(Typeface defaultTypeface) {
      p.defaultTypeface = defaultTypeface;
      return this;
    }

    public DateDialog build() {
      dateDialog.params = this.p;
      return dateDialog;
    }
  }
}

