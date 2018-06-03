package com.example.qcik_macair_01.sweetdiary;

import android.app.DatePickerDialog;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * TODO:
 * Werte von DatePicker noch in Variablen speichern und in Textview den Wert anzeigen,
 * weiterhin soll der Wert inder Variable in die Datenbank gespeichert werden.
 * Alternativ wird erstmal eine früherer Zustand genommen, so das das aktuele Datum und Zeit
 * angezeigt und übergeben wird, eine Änderung aber so nicht möglich ist!
 */


public class MainActivity extends AppCompatActivity{



    /**
     * nötig damit die Variablen auf eine andere Activity übergeben werden kann.
     */

    static final String EXTRA_MESS1 = "mess1";
    static final String EXTRA_MESS2 = "mess2";
    static final String EXTRA_MESS3 = "mess3";
    static final String EXTRA_MESS4 = "mess4";
    static final String EXTRA_MESS5 = "mess5";
    static final String EXTRA_MESS6 = "mess6";



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



        SimpleDateFormat date_format;
        if(Locale.getDefault().getLanguage() == "de")
        {
            date_format = new SimpleDateFormat("dd.MM.yyyy");
        }
        else
        {
            date_format = new SimpleDateFormat("yyyy.MM.dd");
        }

        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm");

        //etdatetime.setText(kalender.getTime().toString());
        etdate.setText(date_format.format(kalender.getTime()));
        ettime.setText(timeformat.format(kalender.getTime()));

        /**
         * dient nur für die korrekte Formatübergabe an die DB zur spätreb Sortierung
         */
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        final String datetoDb = dateFormat.format(kalender.getTime());


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

                //TextView input_Date = (TextView) findViewById(R.id.tvdate);
                String inputDate = datetoDb;

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

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }
}

