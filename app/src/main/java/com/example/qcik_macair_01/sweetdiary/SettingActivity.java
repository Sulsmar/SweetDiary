package com.example.qcik_macair_01.sweetdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final DbAcessSetting dbConnection = DbAcessSetting.getHelper(this);


        /**
         * beim klick auf speichern sollte er die Eingaben den Variablen zuweisen
         * vorher überprüfen ob alle Felder gefüllt wurden. Falls nicht Fehler ausgeben.
         * Falls alles passt soll er den Datenbankzugriff öffnen und die Daten in die vorhandene
         * Datenbank schreiben.
         */
        Button btnsettingsave = (Button) findViewById(R.id.btnsettingsave);
        btnsettingsave.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eingaben werden den Variablen zugewiesen
                Editable etsurname = ((EditText)findViewById(R.id.etsurname)).getText();
                String inputSurname = etsurname.toString();

                Editable etfirstname = ((EditText)findViewById(R.id.etfirstname)).getText();
                String inputFirstname = etfirstname.toString();

                Editable etdateofbirth = ((EditText)findViewById(R.id.etdateofbirth)).getText();
                String inputDateofBirth = etdateofbirth.toString();

                Editable etheight = ((EditText)findViewById(R.id.etheight)).getText();
                String inputHeight = etheight.toString();

                Editable etsettingbodyweight = ((EditText)findViewById(R.id.etsettingbodyweight)).getText();
                String inputSettingBodyweight = etsettingbodyweight.toString();

                /**
                 * Überprüfung der Eingaben fehlt noch
                 */

                dbConnection.insert(inputSurname, inputFirstname, inputDateofBirth, inputHeight, inputSettingBodyweight);
            }
        }));
    }
}
