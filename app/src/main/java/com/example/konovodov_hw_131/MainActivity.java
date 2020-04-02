package com.example.konovodov_hw_131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextAge;
    Button buttonSave;
    Button buttonPressure;
    Button buttonValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonPressure = (Button) findViewById(R.id.buttonPressure);
        buttonValues = (Button) findViewById(R.id.buttonValues);

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


    public void toPressure() {

    }
}