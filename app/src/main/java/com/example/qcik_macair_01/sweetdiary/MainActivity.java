package com.example.qcik_macair_01.sweetdiary;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.widget.DatePicker;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * TODO:
 * Datepicker funktioniert
 * Timepicker muss noch implementiert werden
 *
 * Format der Variable imputtime die an die DB übergeben wird muss noch auf Format (yyyy.MM.dd)
 * geändert werden bevor sie übergeben wird.
 *
 * Datenbankabfrage erstellen und über Listview ausgeben
 *
 * Datensätze aus Db direkt oder aus ListView aufbereiten und im Format PDF speichern über Dialog
 */


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{



    /**
     * nötig damit die Variablen auf eine andere Activity übergeben werden kann.
     */

    static final String EXTRA_MESS1 = "mess1";
    static final String EXTRA_MESS2 = "mess2";
    static final String EXTRA_MESS3 = "mess3";
    static final String EXTRA_MESS4 = "mess4";
    static final String EXTRA_MESS5 = "mess5";
    static final String EXTRA_MESS6 = "mess6";

    private int hour;
    private int minute;


    /**
     * ---------------------------------------------------------------------------
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * holt die Zeit und Datum automatisch und setzt es als String in das Eingabefeld beim laden der App
         */

        Calendar kalender = Calendar.getInstance();
        TextView etdate = (TextView) findViewById(R.id.tvdate);
        TextView ettime = (TextView) findViewById(R.id.tvtime);



        final SimpleDateFormat date_format;
        if(Locale.getDefault().getLanguage() == "de")
        {
            date_format = new SimpleDateFormat("dd.MM.yyyy");
        }
        else
        {
            date_format = new SimpleDateFormat("yyyy.MM.dd");
        }

        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm");

        etdate.setText(date_format.format(kalender.getTime()));
        ettime.setText(timeformat.format(kalender.getTime()));



        /**
         * wechsel durch klick auf den SettingButton auf die Setting Activity
         */
        Button btnSetting = (Button) findViewById(R.id.btnsetting);
        btnSetting.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v){
                Intent settingAct =new Intent(MainActivity.this, SettingActivity.class);
                startActivity(settingAct);
            }
        });


        /**
         * wechsel auf die 3. Activity zurAuswertung und weiteren Optionen
         */
        Button btnevaluation = (Button) findViewById(R.id.btnevaluation);
        btnevaluation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent thirdAct = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(thirdAct);
            }
        });

        /**
         * Button durch den Klick Variablen gesetzt werden und die nächste Activity geladen wird
         */
        Button btnmainweiter = (Button) findViewById(R.id.btnmainweiter);
        btnmainweiter.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secAct = new Intent(MainActivity.this, SecondaryActivity.class);

                /**
                 * Werte werden ausgelesen und in Variablen gepackt.
                 */

                EditText input_Blood = (EditText) findViewById(R.id.etblood);
                String inputBlood = input_Blood.getText().toString();

                EditText input_Drugs =(EditText) findViewById(R.id.etdrugs);
                String inputDrugs = input_Drugs.getText().toString();

                EditText input_Amofmedication = (EditText) findViewById(R.id.etamofmedication);
                String inputAmofmedication = input_Amofmedication.getText().toString();

                TextView input_Date = (TextView) findViewById(R.id.tvdate);
                String inputDate = input_Date.getText().toString();


                TextView input_Time = (TextView) findViewById(R.id.tvtime);
                String inputTime = input_Time.getText().toString();

                EditText input_Bodyweight = (EditText) findViewById(R.id.etbodyweight);
                String inputBodyweight = input_Bodyweight.getText().toString();


                /**
                 * Inhalt der Variablen wird zusätzlich verpackt und an eine andere Activity mit übergeben.
                 */
                secAct.putExtra(EXTRA_MESS1, inputBlood);
                secAct.putExtra(EXTRA_MESS2, inputDrugs);
                secAct.putExtra(EXTRA_MESS3, inputAmofmedication);
                secAct.putExtra(EXTRA_MESS4, inputDate);
                secAct.putExtra(EXTRA_MESS5, inputTime);
                secAct.putExtra(EXTRA_MESS6, inputBodyweight);


                startActivity(secAct);
            }
        }));
    }

    /**
     * DatePickerDialog
     * @param view
     * @param year
     * @param month
     * @param day
     */

    public void datePicker(View view){
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }

    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.tvdate)).setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }


public static class DatePickerFragment extends DialogFragment{
        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
}



}

