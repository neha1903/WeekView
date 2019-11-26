package com.example.week;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WeekView extends FrameLayout{

    private TextView mTextHour;

    private RelativeLayout mSeparateHour;

    private int width;


    public WeekView(Context context) {
        super(context);
        init(null);
    }

    public WeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_week, this, true);

        mTextHour = (TextView) findViewById(R.id.text_hour);
        mSeparateHour = (RelativeLayout) findViewById(R.id.separate_hour);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;

    }

    public void setText(String text) {
        mTextHour.setText(text);
    }

    public float getHourTextWidth() {
        LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) mTextHour.getLayoutParams();
        float measureTextWidth = mTextHour.getPaint().measureText("12:00".toString());
        float f = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            f = Math.max(measureTextWidth, param.width) + param.getMarginEnd() + param.getMarginStart();
        }
        return f;
    }

    public float getSeparateHeight() {
        return mSeparateHour.getLayoutParams().height;
    }

    public float getSeparateWidth() {
        return width;
    }

    public void setHourSeparatorAsInvisible() {
        mSeparateHour.setVisibility(INVISIBLE);
    }

    public void setHourSeparatorAsVisible() {
        mSeparateHour.setVisibility(VISIBLE);
    }

    public void setHourSeparatorIsVisible(boolean b) {
        if (b) {
            setHourSeparatorAsVisible();
        } else {
            setHourSeparatorAsInvisible();
        }

    }

}
