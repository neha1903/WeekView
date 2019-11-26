package com.example.week;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    CalendarWeekView dayView;
    ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dayView = (CalendarWeekView) findViewById(R.id.calendar);
        dayView.setLimitTime(0, 23);

        events = new ArrayList<>();
        {
            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, 0);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, 2);
            timeEnd.set(Calendar.MINUTE, 0);
            Event event = new Event( timeStart, timeEnd, "0 - 2 Event", "Hockaido");
            events.add(event);
        }

        {
            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, 12);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, 12);
            timeEnd.set(Calendar.MINUTE, 30);
            Event event = new Event( timeStart, timeEnd, " 12 - 12:30 Event", "Hockaido");
            events.add(event);
        }

        {
            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, 16);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, 16);
            timeEnd.set(Calendar.MINUTE, 45);
            Event event = new Event(timeStart, timeEnd, "16 - 16:45 Event", "Hockaido");
            events.add(event);
        }

        {
            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, 20);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, 22);
            timeEnd.set(Calendar.MINUTE, 0);
            Event event = new Event( timeStart, timeEnd, "20 - 22 Event", "Hockaido");
            events.add(event);
        }

        dayView.setEvents(events);
    }
}
