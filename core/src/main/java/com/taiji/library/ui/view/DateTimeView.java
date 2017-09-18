package com.taiji.library.ui.view;

import android.app.Activity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * 描述：日期时间控件
 * 创建人： panho
 * 创建时间： 2016-11-21
 */

public class DateTimeView implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener{

    public static final int DATE = 1;

    public static final int DATETIME = 2;

    private DatePickerDialog mDatePickerDialog;

    private TimePickerDialog mTimePickerDialog;

    private Activity mActivity;

    private int mType;

    private Calendar now = null;

    private String mTime;

    private OnSelectTimeListener mListener;

    public DateTimeView(Activity activity,int type){
        this.mActivity = activity;
        this.mType = type;
    }

    public void show(OnSelectTimeListener listener){
        this.mListener = listener;
        now = Calendar.getInstance();
        mDatePickerDialog = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        mDatePickerDialog.vibrate(true);
        mDatePickerDialog.show(mActivity.getFragmentManager(),"DatepickerDialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String monthStr = monthOfYear<10?"0"+monthOfYear:""+monthOfYear;
        String dayStr = dayOfMonth<10?"0"+dayOfMonth:""+dayOfMonth;
        mTime = year+"-"+monthStr+"-"+dayStr;
        if(mType==DATETIME){
            mTimePickerDialog = TimePickerDialog.newInstance(
                    this,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    true
            );
            mTimePickerDialog.vibrate(true);
            mTimePickerDialog.show(mActivity.getFragmentManager(),"TimepickerDialog");
        }else {
            if(mListener!=null){
                mListener.selectTime(mTime);
            }
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String hourStr = hourOfDay<10?"0"+hourOfDay:""+hourOfDay;
        String minuteStr = minute<10?"0"+minute:""+minute;
        String secondStr = second<10?"0"+second:""+second;
        mTime+=" "+hourStr+":"+minuteStr+":"+secondStr;
        if(mListener!=null){
            mListener.selectTime(mTime);
        }
    }

    public interface OnSelectTimeListener{

        void selectTime(String time);

    }

}
