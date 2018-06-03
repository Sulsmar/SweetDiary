package com.example.qcik_macair_01.sweetdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.qcik_macair_01.sweetdiary.R;

public class DbAcessSetting extends SQLiteOpenHelper {
    private static Context context;
    private static final String DB_NAME = "sweetdiary.db";
    private static final int DB_VERSION = 1;

    private static DbAcessSetting instance;

    public static final String TABLE_NAME_USER = "user";
    public static final String ROWIDUSER = "_iduser";
    public static final String COL_NAME_SURNAME = "surname";
    public static final String COL_NAME_FIRSTNAME = "firstname";
    public static final String COL_NAME_DATEOFBIRTH = "dateofbirth";
    public static final String COL_NAME_HEIGHT = "height";
    public static final String COL_NAME_SETTINGBODYWEIGHT = "settingbodyweight";

    /** oben Table user
     * ------------------------------------------------------------------------------------------
     * unten Table blood
     */

    public static final String TABLE_NAME_BLODD = "blood";
    public static final String ROWID = "_id";
    public static final String COL_NAME_BLOODLEVEL = "bloodlevel";
    public static final String COL_NAME_DATE = "date";
    public static final String COL_NAME_TIME = "time";
    public static final String COL_NAME_DRUGS = "drugs";
    public static final String COL_NAME_AMOFMEDICATION = "amofmedication";
    public static final String COL_NAME_BODYWEIGHT = "bodyweight";
    public static final String COL_NAME_MESURE = "mesure";
    public static final String COL_NAME_MEAL = "meal";
    public static final String COL_NAME_FEEL = "feel";

    /**
     * ----------------------TRENNER------------------------------------------------------------
     */


    public static final String CREATE_TABLE_EVENTS = "CREATE TABLE " + TABLE_NAME_USER + " ( "
            + ROWIDUSER + " INTEGER PRIMARY KEY NOT NULL,"
            + COL_NAME_SURNAME + "TEXT NOT NULL,"
            + COL_NAME_FIRSTNAME + "TEXT NOT NULL,"
            + COL_NAME_DATEOFBIRTH + "TEXT NOT NULL,"
            + COL_NAME_HEIGHT + "TEXT NOT NULL,"
            + COL_NAME_SETTINGBODYWEIGHT + "TEXT NOT NULL)";

    private static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS" + TABLE_NAME_USER + ";";

    /** oben Table user
     * ------------------------------------------------------------------------------------------
     * unten Table blood
     */

    public static final String CREATE_TABLE_EVENTS_BLOOD = "CREATE TABLE " + TABLE_NAME_BLODD + " ( "
            + ROWID + " INTEGER PRIMARY KEY NOT NULL,"
            + COL_NAME_BLOODLEVEL + "TEXT NOT NULL,"
            + COL_NAME_DATE + "TEXT NOT NULL,"
            + COL_NAME_TIME + "TEXT NOT NULL,"
            + COL_NAME_DRUGS + "TEXT NOT NULL"
            + COL_NAME_AMOFMEDICATION + "TEXT NOT NULL,"
            + COL_NAME_BODYWEIGHT + "TEXT NOT NULL,"
            + COL_NAME_MESURE + "TEXT NOT NULL,"
            + COL_NAME_MEAL + "TEXT NOT NULL,"
            + COL_NAME_FEEL +  "TEXT NOT NULL)";

    private static final String DROP_TABLE_BLOOD = "DROP TABLE IF EXISTS" + TABLE_NAME_BLODD + ";";





    public static synchronized DbAcessSetting getHelper(Context parcontext) {
        if (instance == null) {
            instance = new DbAcessSetting(parcontext);
        }
        return instance;
    }

    private DbAcessSetting(Context parContext) {
        super(parContext, DB_NAME, null, DB_VERSION);
        context = parContext;
    }

    

    public void insert(String surname, String firstname, String dateofbirth, String height, String settingbodyweight) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_NAME_SURNAME, surname);
            values.put(COL_NAME_FIRSTNAME, firstname);
            values.put(COL_NAME_DATEOFBIRTH, dateofbirth);
            values.put(COL_NAME_HEIGHT, height);
            values.put(COL_NAME_SETTINGBODYWEIGHT, settingbodyweight);
            db.insertOrThrow(TABLE_NAME_USER, null, values);
            Toast.makeText(context, R.string.inserted, Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(context, R.string.insert_failed, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  oben für die Stammdaten
     *  ----------------------------------------------------------------------------------------
     *  unten für die veränderlichen Daten der Messungen!
     */
    public void insertValues (String bloodlevel, String date, String time, String drugs, String amofmedication, String bodyweight, String mesure, String meal, String feel){
        try{
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_NAME_BLOODLEVEL, bloodlevel);
            values.put(COL_NAME_DATE, date);
            values.put(COL_NAME_TIME, time);
            values.put(COL_NAME_DRUGS, drugs);
            values.put(COL_NAME_AMOFMEDICATION, amofmedication);
            values.put(COL_NAME_BODYWEIGHT, bodyweight);
            values.put(COL_NAME_MESURE, mesure);
            values.put(COL_NAME_MEAL, meal);
            values.put(COL_NAME_FEEL, feel);

        }catch (SQLException e) {
            Toast.makeText(context, R.string.insert_failed, Toast.LENGTH_SHORT).show();
        }
    }




    public Cursor query(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NAME_USER, null,null, null, null, null, null);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EVENTS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**
         * Hier passiert nichts!
         */
    }
}
