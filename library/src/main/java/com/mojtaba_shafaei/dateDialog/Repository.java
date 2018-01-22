package com.mojtaba_shafaei.dateDialog;

import android.util.SparseArray;

/**
 * Created by mojtaba on 1/21/18.
 */

final class Repository {

  private static Repository INSTANCE = null;
  private static final Object lock = new Object();
  private SparseArray<String> months;

  private Repository() {
    months = new SparseArray<>();
    months.put(0, "فروردین");
    months.put(1, "اردیبهشت");
    months.put(2, "خرداد");
    months.put(3, "تیر");
    months.put(4, "مرداد");
    months.put(5, "شهریور");
    months.put(6, "مهر");
    months.put(7, "آبان");
    months.put(8, "آذر");
    months.put(9, "دی");
    months.put(10, "بهمن");
    months.put(11, "اسفند");
  }

  static Repository getInstance() {
    if (INSTANCE == null) {
      synchronized (lock) {
        if (INSTANCE == null) {
          INSTANCE = new Repository();
        }
      }
    }
    return INSTANCE;
  }

  public SparseArray<String> getMonths() {
    return months;
  }
}
