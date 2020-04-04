package com.example.konovodov_hw_131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextAge;
    Button buttonSave;
    Button buttonPressure;
    Button buttonValues;
    Set<StartUserInfo> userInfo = new HashSet<StartUserInfo>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    userInfo.add(new StartUserInfo(editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString())));
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите возраст пациента", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        buttonPressure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentFirst = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intentFirst);
            }
        });

        buttonValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecond = new Intent(MainActivity.this, ValuesActivity.class);
                startActivity(intentSecond);
            }
        });
    }

    public void init() {
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonPressure = (Button) findViewById(R.id.buttonPressure);
        buttonValues = (Button) findViewById(R.id.buttonValues);

    }

    public void toPressure() {

    }
}