# AndroidDateDialog


## Sample code
```java
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
```
