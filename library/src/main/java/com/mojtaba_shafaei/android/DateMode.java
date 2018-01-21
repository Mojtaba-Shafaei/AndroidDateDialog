package com.mojtaba_shafaei.android;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by mojtaba on 1/21/18.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({DateMode.LONG_MODE, DateMode.SHORT_MODE})
public @interface DateMode {

  int LONG_MODE = 0;
  int SHORT_MODE = 1;

}
