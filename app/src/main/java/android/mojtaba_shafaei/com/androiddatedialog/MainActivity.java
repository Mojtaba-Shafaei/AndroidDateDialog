package android.mojtaba_shafaei.com.androiddatedialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.mojtaba_shafaei.dateDialog.DateDialog;
import com.mojtaba_shafaei.dateDialog.DateMode;
import com.mojtaba_shafaei.dateDialog.MyDate;
import com.mojtaba_shafaei.dateDialog.OnDateSelectListener;
import com.mojtaba_shafaei.persianFont.PersianFont;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.btn_selectDate).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        DateDialog.newBuilder(getContext())
            .withPositiveButton("OK", new OnDateSelectListener() {
              @Override
              public void onDateSelect(MyDate date) {
                Log.d("MAIN_ACTIVITY", "onDateSelect: " + date.getDate());
                Log.d("MAIN_ACTIVITY", "onDateSelect: " + date.getHumanDate());
                Log.d("MAIN_ACTIVITY", "onDateSelect: " + date.getNumericDate());
              }
            })
            .withNegativeButton("CANCEL", new OnClickListener() {
              @Override
              public void onClick(View view) {
                Log.d("MAIN_ACTIVITY", "onClick:canceled ");
              }
            })
            .withMode(DateMode.LONG)
            .withCancelable(false)
            .withDefaultDate(new MyDate(1390, 1, 1))
            .withDefaultTypeface(PersianFont.IRANSANS_BOLD(getContext()))
            .build()
            .show();
      }
    });
  }

  private Context getContext() {
    return this;
  }
}
