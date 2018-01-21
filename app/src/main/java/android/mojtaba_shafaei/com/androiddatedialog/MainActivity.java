package android.mojtaba_shafaei.com.androiddatedialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.mojtaba_shafaei.android.DateDialog;
import com.mojtaba_shafaei.android.DateMode;
import com.mojtaba_shafaei.android.MyDate;
import com.mojtaba_shafaei.android.OnDateSelectListener;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.btn_selectDate).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        DateDialog.newBuilder(MainActivity.this)
            .withPositiveButton("OK", new OnDateSelectListener() {
              @Override
              public void onDateSelect(MyDate date) {
                Log.d("MAIN_ACTIVITY", "onDateSelect: " + date.getDate());
                Log.d("MAIN_ACTIVITY", "onDateSelect: " + date.getHumanDate());
              }
            })
            .withNegativeButton("CANCEL", new OnClickListener() {
              @Override
              public void onClick(View view) {
                Log.d("MAIN_ACTIVITY", "onClick:canceled ");
              }
            })
            .withMode(DateMode.SHORT_MODE)
            .withCancelable(false)
            .build()
            .show();
      }
    });
  }
}
