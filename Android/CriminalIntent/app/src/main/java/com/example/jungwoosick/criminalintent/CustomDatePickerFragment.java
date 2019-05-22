package com.example.jungwoosick.criminalintent;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class CustomDatePickerFragment extends DialogFragment {
    public static final String EXTRA_DATE =
            "com.bignerdranch.android.criminalintent.date";
    private static final String ARG_DATE = "date";
    private static final String ARG_CAPTION = "caption";
    private Date mCurrentSelectedDate;
    private Date mCurrentMonthDate; // year, month, 1

    //private TextView mCaptionTextView;
    private TextView mSelectedDateTextView;
    private ImageButton mPrevButton;
    private TextView mCurrentMonthTextView;
    private ImageButton mNextButton;
    private RecyclerView mRecyclerView;
    //private Button mCancelButton;
    //private Button mOkButton;
    private TextView prevClickedTextView;
    private TimePicker mTimePicker;

    public static CustomDatePickerFragment newInstance(Date date, String caption) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        args.putSerializable(ARG_CAPTION, caption);
        CustomDatePickerFragment fragment = new CustomDatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Helpers
    private void updateCurrentSelectedDate(Date date) {
        mSelectedDateTextView.setText(Crime.getDateString(date));
    }
    private void updatedCurrentMonthDate(Date date) {
        mCurrentMonthTextView.setText(Crime.getDateString(date, "yyyyMMM"));
    }
    //endregion

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Date date = (Date) getArguments().getSerializable(ARG_DATE);
        mCurrentSelectedDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        calendar.set(year, month, 1);
        mCurrentMonthDate = calendar.getTime();

        String caption = (String)getArguments().getSerializable(ARG_CAPTION);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.custom_dialog_date, null);
//        TextView captionView = v.findViewById(R.id.cdd_caption);
//        captionView.setText(caption);

        mSelectedDateTextView = v.findViewById(R.id.cdd_selected_date);
        updateCurrentSelectedDate(mCurrentSelectedDate);

        //요일 하드코딩 => 변경
        int dayOfWeekIdArray[] = new int[] {R.id.sunday, R.id.monday, R.id.tuesday, R.id.wednesday, R.id.thursday, R.id.friday, R.id.saturday};
        TextView dayOfWeekTextView = null;

        for(int i=0; i<7; i++) {
            calendar.set(Calendar.DAY_OF_WEEK, (getFirstDayOfWeek()+i)%7);
            dayOfWeekTextView = v.findViewById(dayOfWeekIdArray[i]);
            dayOfWeekTextView.setText(Crime.getDateString(calendar.getTime(), "EEE"));
        }

        mPrevButton = v.findViewById(R.id.cdd_button_left);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveMonth(-1);
            }
        });
        mNextButton = v.findViewById(R.id.cdd_button_right);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveMonth(1);
            }
        });
        mCurrentMonthTextView = v.findViewById(R.id.cdd_current_month);
        updatedCurrentMonthDate(mCurrentMonthDate);

        mRecyclerView = v.findViewById(R.id.cdd_recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 7));

//        Button cancelButton = v.findViewById(R.id.cdd_cancel);
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        Button okButton = v.findViewById(R.id.cdd_ok);
//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        setupAdapter(mCurrentMonthDate);

        mTimePicker = v.findViewById(R.id.cdd_time_picker);
        if(DateFormat.is24HourFormat(getActivity())) mTimePicker.setIs24HourView(true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setHour(hour);
            mTimePicker.setMinute(min);
        }else {
            mTimePicker.setCurrentHour(hour);
            mTimePicker.setCurrentMinute(min);
        }
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(caption)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                .create();
        //return super.onCreateDialog(savedInstanceState);
    }

    private void moveMonth(int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mCurrentMonthDate);
        calendar.add(Calendar.MONTH, count);
        mCurrentMonthDate = calendar.getTime();

        setupAdapter(mCurrentMonthDate);
        updatedCurrentMonthDate(mCurrentMonthDate);
    }

    //region RecyclerView Date
    private class WeekHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView mTextView;

        public WeekHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView;
            mTextView.setGravity(Gravity.CENTER);
            mTextView.setBackgroundResource(R.color.colorWhite);
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView nowClickedTextView = (TextView)v;
                    Date nowDate = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(nowDate);
                    int nowYear = calendar.get(Calendar.YEAR);
                    int nowMonth = calendar.get(Calendar.MONTH);
                    int nowDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


                    calendar.setTime(mCurrentMonthDate);
                    int clickedYear = calendar.get(Calendar.YEAR);
                    int clickedMonth = calendar.get(Calendar.MONTH);
                    String clickedText =  nowClickedTextView.getText().toString();

                    if(clickedText.equals("")) return;

                    calendar.set(clickedYear, clickedMonth, Integer.parseInt(clickedText));
                    v.setBackgroundResource(R.color.colorPink);
                    nowClickedTextView.setTextColor(Color.WHITE);

                    //recovery prevTextView color
                    if(prevClickedTextView != null) {
                        prevClickedTextView.setBackgroundResource(R.color.colorWhite);
                        if(nowYear==clickedYear && nowMonth==clickedMonth &&
                                Integer.toString(nowDayOfMonth).equals(prevClickedTextView.getText().toString()))
                            prevClickedTextView.setTextColor(Color.RED);
                        else
                            prevClickedTextView.setTextColor(Color.GRAY);
                    }

                    prevClickedTextView = (TextView)v;
                    updateCurrentSelectedDate(calendar.getTime());
                }
            });
        }

        public void bind(String monthDay) {
            mTextView.setText(monthDay);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(mCurrentMonthDate);
            int calMonth = calendar.get(Calendar.MONTH);
            calendar.setTime(new Date());
            int nowMonth = calendar.get(Calendar.MONTH);
            int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

            if(!monthDay.equals("") && calMonth==nowMonth && Integer.parseInt(monthDay)==nowDay) {
                mTextView.setTextColor(Color.RED);
                mTextView.setPaintFlags(mTextView.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
            }
        }

        @Override
        public void onClick(View v) {

        }
    }


    private class WeekAdapter extends RecyclerView.Adapter<WeekHolder> {

        private String[] mMonthDays;

        public WeekAdapter(String[] monthDays) {
            mMonthDays = monthDays;
        }

        @NonNull
        @Override
        public WeekHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            TextView view = new TextView(getActivity());
            view.setText("");
            return new WeekHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WeekHolder weekHolder, int i) {
            String monthDay = mMonthDays[i];
            weekHolder.bind(monthDay);
        }

        @Override
        public int getItemCount() {
            return mMonthDays.length;
        }
    }

    private void setupAdapter(Date firstDayOfMonth) {
        // 2019.05.01 => 2019.04.28
        Date startDate = getFirstDateOfMonthCalendar(firstDayOfMonth);
        /*int rowCount = getRowCountOfWeeksInMonth(firstDayOfMonth);*/ //UPDATE
        int rowCount = 6;
        String[] days = new String[7 * rowCount];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMonth);
        int thisMonth = calendar.get(Calendar.MONTH);

        calendar.setTime(startDate);
        for (int index = 0; index < 7 * rowCount; index++) {
            //Date date = calendar.getTime();
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            if (month == thisMonth) {
                days[index] = Integer.toString(day);
            } else {
                days[index] = "";
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        mRecyclerView.setAdapter(new WeekAdapter(days));
    }
    //endregion

    private int getFirstDayOfWeek() {
        int d = 0;
        Calendar calendar = Calendar.getInstance();
        d = calendar.getFirstDayOfWeek();
        return d;
    }

    private int getTotalDaysOfMonth(Date date) {
        int totalDays = 31;

        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        totalDays = calendar.getMaximum(Calendar.DAY_OF_MONTH);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        //int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, 1); // first day of this month
        calendar.add(Calendar.MONTH, 1);    // first day of next month
        calendar.add(Calendar.DAY_OF_MONTH, -1); // last day of this month
        int lastDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        totalDays = lastDayOfMonth;

        return totalDays;
    }

    private int getPrevMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.get(Calendar.MONTH);
    }

    private int getNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.get(Calendar.MONTH);
    }

    private int getStartIndexInWeekOfFirstDayOfMonth(Date firstDayOfMont) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMont);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = getFirstDayOfWeek();
        int startIndexInWeekOfFirstDayOfMonth = (7 + dayOfWeek - firstDayOfWeek) % 7;
        return startIndexInWeekOfFirstDayOfMonth;
    }

    private int getRowCountOfWeeksInMonth(Date date) {
        int rowCount = 5;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(year, month, 1); // first day of this month
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        int firstDayOfWeek = getFirstDayOfWeek();
        int startIndexInWeekOfFirstDayOfMonth = getStartIndexInWeekOfFirstDayOfMonth(calendar.getTime());
        int totalDaysOfMonth = getTotalDaysOfMonth(date);
        assert startIndexInWeekOfFirstDayOfMonth < 7;
        int remainDays = (totalDaysOfMonth  - (7 - startIndexInWeekOfFirstDayOfMonth));
        rowCount = 1 + remainDays / 7 + (remainDays % 7 > 0 ? 1 : 0);

        return rowCount;
    }

    // 2019.05 => 2019.04.28
    private Date getFirstDateOfMonthCalendar(Date firstDayOfMonth) {
        int startIndexInWeekOfFirstDayOfMonth = getStartIndexInWeekOfFirstDayOfMonth(firstDayOfMonth);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMonth);
        calendar.add(Calendar.DAY_OF_MONTH, -startIndexInWeekOfFirstDayOfMonth);

        return calendar.getTime();
    }

    // 04.28 => 4.28, 4.29, 4.20, 5.01, 5.02, 5.03, 5.04
    private Date[] getDatesInWeekRow(Date firstDate) {
        Date[] dates = new Date[7];
        //
        return dates;
    }

    /**
     *      Caption from caller
     *      Selected Date: Year Month Day
     *      <   Year Month  >
     *      weekday header
     *      week rows 0
     *      week rows 1
     *      ...
     *      Cancel  OK
     */
}