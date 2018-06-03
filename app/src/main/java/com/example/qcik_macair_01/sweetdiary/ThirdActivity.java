package com.example.qcik_macair_01.sweetdiary;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ThirdActivity extends AppCompatActivity {

    boolean stroneweek = false;
    boolean strtwoweek = false;
    boolean stronemonth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Button btn3to1 = (Button) findViewById(R.id.btn3to1);
        btn3to1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent threetooneAct = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(threetooneAct);
            }
        });

        Button btn3send = (Button)findViewById(R.id.btn3tosave);
        btn3send.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                /**
                 * Daten auslesen, formatieren, spreichern als PDF und senden per Mail.
                 */
            }
        });

        Button btnrecall = (Button) findViewById(R.id.btn3recall);
        btnrecall.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                /**
                 * Daten auslesen, und in ListView schreiben
                 * Anzahl wird gesteuert über den Wert aus RadioGroup
                 * über die Variablen onweek, twoweek, onemonth
                 */
            }
        });

    }
    public void onPeriod (View view) {

        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.rB1Week:
                if (checked)
                    stroneweek = true;
                break;
            case R.id.rB2Week:
                if (checked)
                    strtwoweek = true;
                break;
            case R.id.rB1Month:
                if (checked)
                    stronemonth = true;
                break;
        }
    }

}
