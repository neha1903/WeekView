package com.example.week.Decorations;

import android.content.Context;
import android.graphics.Rect;

import com.example.week.WeekView;
import com.example.week.Event;
import com.example.week.EventWeekView;


public class CwVDecorationDefault implements CwVDecoration {

    protected Context mContext;

    public CwVDecorationDefault(Context context) {
        this.mContext = context;
    }

    @Override
    public EventWeekView getEventView(Event event, Rect eventBound, int hourHeight, int separateHeight, int separateWidth) {
        EventWeekView eventWeekView = new EventWeekView(mContext);
        eventWeekView.setEvent(event);
        eventWeekView.setPosition(eventBound, -hourHeight, hourHeight - separateHeight, separateWidth);
        return eventWeekView;
    }
    @Override
    public WeekView getDayView(int hour) {
        WeekView weekView = new WeekView(mContext);
        weekView.setText(String.format("%1$2s:00", hour));
        return weekView;
    }

}
