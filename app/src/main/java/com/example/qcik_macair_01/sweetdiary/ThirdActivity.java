package com.example.qcik_macair_01.sweetdiary;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ThirdActivity extends AppCompatActivity {


    static final String EXTRA_MESS7 = "mess7";
    String peroiodtime = "";


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



        Button btnrecall = (Button) findViewById(R.id.btn3recall);
        btnrecall.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // hier soll dann die Auswertung stattfinden!
            }
        });

    }
    public void onPeriod (View view) {

        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.rB1Week:
                if (checked)
                peroiodtime = "7";
                break;
            case R.id.rB2Week:
                if (checked)
                    peroiodtime = "14";
                break;
            case R.id.rB1Month:
                if (checked)
                    peroiodtime = "31";
                break;
        }
    }

}
