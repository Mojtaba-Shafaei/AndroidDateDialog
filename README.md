# AndroidDateDialog


## Sample code
```java
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
```

## Installation    
[![](https://jitpack.io/v/Mojtaba-Shafaei/AndroidDateDialog.svg)](https://jitpack.io/#Mojtaba-Shafaei/AndroidDateDialog)
