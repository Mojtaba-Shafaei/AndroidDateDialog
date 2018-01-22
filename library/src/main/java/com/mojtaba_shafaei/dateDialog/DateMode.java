package com.mojtaba_shafaei.dateDialog;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by mojtaba on 1/21/18.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({DateMode.LONG, DateMode.SHORT})
public @interface DateMode {

  int LONG = 0;
  int SHORT = 1;

}
