package com.example.qcik_macair_01.sweetdiary;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class EventDiaryAdapter extends CursorAdapter {

    private final Date date = new Date();
    private  static final DateFormat FORMAT_DATE = DateFormat.getDateInstance();
    private static final DateFormat FORMAT_TIME = DateFormat.getTimeInstance();
    private LayoutInflater inflator;
    /**
     * anpassen an die eigene Datenbank!
     */

    private int colDateTime = 1, colEventDesc = 2, colMood = 3;

    public EventDiaryAdapter(Context context, Cursor cursor){
        super(context, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
                inflator = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflator.inflate(R.layout.activity_third,null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        // Hier gehts weiter

    }
}
