package com.example.konovodov_hw_131;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;

public class PressureActivity extends AppCompatActivity {
    EditText upPressureField1;
    EditText downPressureField;
    EditText userPulse;
    CheckBox tachycardiaCheckBox;
    EditText datetimeOfMeasure;

    Button buttonSavePressure;
    Button buttonBack;
    //PressureClass pressOne = new PressureClass();

    private Map<LocalDateTime, PressureClass> pressure = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();

        //Get current date time
        LocalDateTime now = now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formatDateTime = now.format(formatter);
        datetimeOfMeasure.setText(/*formatDateTime.toString()*/now.toString());

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonSavePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int upPressureValue;
                int downPressureValue;
                int pulseValue;
                datetimeOfMeasure.setText(/*formatDateTime.toString()*/now().toString());
                try {
                    upPressureValue = Integer.parseInt(upPressureField1.getText().toString());
                    downPressureValue = Integer.parseInt(downPressureField.getText().toString());
                    pulseValue = Integer.parseInt(userPulse.getText().toString());

                    boolean check = tachycardiaCheckBox.isChecked();

                    //DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime lastTime = LocalDateTime.parse(/*"2020-04-03T21:46:01.778"*/datetimeOfMeasure.getText().toString()/*, formatterTime*/);
                    //LocalDateTime.parse(datetimeOfMeasure.getText().toString(), formatterTime);

                    //добавляем в коллекцию...
                    pressure.put(lastTime, new PressureClass(upPressureValue, downPressureValue, pulseValue, check, lastTime));
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Количество данных в коллекции: " + Integer.toString(pressure.size()), Toast.LENGTH_SHORT);
                    toast.show();

                }
                catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите допустимые значения!", Toast.LENGTH_SHORT);
                    toast.show();
                }




                //upPressureField1.setText(lastTime.toString());

                /*
                Pressure.put ()


                EditText upPressureField1;
                EditText downPressureField;
                EditText userPulse;
                CheckBox tachycardiaCheckBox;
                EditText datetimeOfMeasure;

                 */
            }
        });


    }


    public void init() {
        upPressureField1 = (EditText) findViewById(R.id.upPressureField);
        downPressureField = (EditText) findViewById(R.id.downPressureField);
        userPulse = (EditText) findViewById(R.id.userPulse);
        tachycardiaCheckBox = (CheckBox) findViewById(R.id.tachycardiaCheckBox);
        datetimeOfMeasure = (EditText) findViewById(R.id.datetimeOfMeasure);


        buttonSavePressure = (Button) findViewById(R.id.buttonSavePressure);
        buttonBack = (Button) findViewById(R.id.btnBack);
    }
}
