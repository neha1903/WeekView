package com.example.week.Decorations;

import android.graphics.Rect;

import com.example.week.WeekView;
import com.example.week.Event;
import com.example.week.EventWeekView;

public interface CwVDecoration {

    EventWeekView getEventView(Event event, Rect eventBound, int hourHeight, int seperateHeight, int seprateWidth);
    WeekView getDayView(int hour);
}
