package com.example.qcik_macair_01.sweetdiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondaryActivity extends AppCompatActivity{

    String strmeasure = "no value";
    String strmeal = "no value";
    String strfeel = "no value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        final DbAcessSetting dbConnection = DbAcessSetting.getHelper(this);

        /**
         * --------------------------------------------------------------------------------
         * Übergabe der Strings aus Activity 1 an neue Variablen.
         */

        Bundle extras = getIntent().getExtras();

        final String inputBlood = extras.getString(MainActivity.EXTRA_MESS1);
        final String inputDrugs = extras.getString(MainActivity.EXTRA_MESS2);
        final String inputAmofmedication = extras.getString(MainActivity.EXTRA_MESS3);
        final String inputDate = extras.getString(MainActivity.EXTRA_MESS4);
        final Integer date = Integer.parseInt(inputDate); // wird extra auf Int gecastet für die Datenbank
        final String inputTime = extras.getString(MainActivity.EXTRA_MESS5);
        final Integer time = Integer.parseInt(inputTime); // wird extra auf Int gecastet für die Datenbank
        final String inputBodyweight = extras.getString(MainActivity.EXTRA_MESS6);



        Button btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbConnection.insertValues(inputBlood, date, time, inputDrugs, inputAmofmedication, inputBodyweight, strmeasure, strmeal, strfeel);
            }
        });
    }

    public void onklickmeasure(View view) {

        boolean checked = ((RadioButton)view).isChecked();

        switch(view.getId()) {
            case R.id.rbsober:
                if (checked)
                    strmeasure =  getString(R.string.sober);
                break;
            case R.id.rbbefore:
                if (checked)
                    strmeasure = getString(R.string.before);
                    break;
            case R.id.rbafter:
                if (checked)
                    strmeasure = getString(R.string.after);
                    break;
        }
    }

    public void onklickmeal(View view) {

        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.rbsnack:
                if (checked)
                    strmeal = getString(R.string.snack);
                break;
            case R.id.rbbrekfast:
                if (checked)
                    strmeal = getString(R.string.breakfast);
                break;
            case R.id.rbdinner:
                if (checked)
                    strmeal = getString(R.string.dinner);
                break;
            case R.id.rblunch:
                strmeal = getString(R.string.lunch);
                break;
        }
    }

    public void onklickfeel(View view) {

        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()) {
            case R.id.rbgood:
                if (checked)
                    strfeel = getString(R.string.good);
                break;
            case R.id.rbnormal:
                if (checked)
                strfeel = getString(R.string.normal);
                break;
            case R.id.rbbad:
                if (checked)
                    strfeel = getString(R.string.bad);
                break;
        }
    }
}
