package com.example.week;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import android.widget.TextView;


public class EventWeekView extends FrameLayout {

    protected Event mEvent;

    protected TextView mEventName;

    public EventWeekView(Context context) {
        super(context);
        init(null);
    }

    public EventWeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EventWeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    protected void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_event, this, true);

        mEventName = (TextView) findViewById(R.id.item_event_name);
    }


    public void setEvent(Event event) {
        this.mEvent = event;
    }

    public void setPosition(Rect rect, int topMargin, int bottomMargin, int seprateWidth){
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = rect.top + topMargin - getResources().getDimensionPixelSize(R.dimen.weekHeight) ;
        params.height = rect.height() + bottomMargin;
        params.leftMargin = rect.left + ((rect.right * 2) - 4);
        params.rightMargin = (rect.right * 4) +4;
        setLayoutParams(params);
    }

}
