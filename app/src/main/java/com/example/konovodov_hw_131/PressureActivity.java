package com.example.konovodov_hw_131;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    private static final String TAG = "myLogs";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();

        //Get current date time
        LocalDateTime now = now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatDateTime = now.format(formatter);
        datetimeOfMeasure.setText(formatDateTime.toString()/*now.toString()*/);

        buttonBackClick();

        buttonSavePressureClick();


    }

    public void init() {
        Log.d(TAG, "найдем View элементы на экране пользовательских значений");
        upPressureField1 = (EditText) findViewById(R.id.upPressureField);
        downPressureField = (EditText) findViewById(R.id.downPressureField);
        userPulse = (EditText) findViewById(R.id.userPulse);
        tachycardiaCheckBox = (CheckBox) findViewById(R.id.tachycardiaCheckBox);
        datetimeOfMeasure = (EditText) findViewById(R.id.datetimeOfMeasure);


        buttonSavePressure = (Button) findViewById(R.id.buttonSavePressure);
        buttonBack = (Button) findViewById(R.id.btnBack);
        Log.d(TAG, "элементы View найдены");
    }

    public void buttonBackClick() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "нажата кнопка возврата на стартовый экран");
                finish();
            }
        });
    }
    public void buttonSavePressureClick() {
        buttonSavePressure.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d(TAG, "нажата кнопка сохранения пользовательских значений");
                int upPressureValue;
                int downPressureValue;
                int pulseValue;
                //datetimeOfMeasure.setText(/*formatDateTime.toString()*/now().toString());
                try {
                    upPressureValue = Integer.parseInt(upPressureField1.getText().toString());
                    downPressureValue = Integer.parseInt(downPressureField.getText().toString());
                    pulseValue = Integer.parseInt(userPulse.getText().toString());

                    boolean check = tachycardiaCheckBox.isChecked();
                    Log.d(TAG, "задание формата даты и времени");
                    DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    Log.d(TAG, "попытка считать введенные значения даты и времени");
                    //LocalDateTime lastTime = LocalDateTime.parse("2020-04-03T21:46:01.778");
                    //lastTime.format(formatterTime);
                    //lastTime = LocalDateTime.parse(/*"2020-04-03T21:46:01.778"*/datetimeOfMeasure.getText().toString(), formatterTime);
                    LocalDateTime lastTime = LocalDateTime.parse(/*"2020-04-03T21:46:01.778"*/datetimeOfMeasure.getText().toString(), formatterTime);
                    //LocalDateTime.from(formatterTime.ISO_LOCAL_DATE_TIME.parse(datetimeOfMeasure.getText().toString()));

                    //LocalDateTime.parse(datetimeOfMeasure.getText().toString(), formatterTime);
                    Log.d(TAG, "считывание данных о дате и времени - успешно!");

                    //добавляем в коллекцию...
                    Log.d(TAG, "добавление в коллекцию введенных значений");
                    int sizeLast = pressure.size();
                    pressure.put(lastTime, new PressureClass(upPressureValue, downPressureValue, pulseValue, check, lastTime));
                    if (sizeLast==pressure.size()) {
                        Log.d(TAG, "значения в коллекцию не добавлены!");
                        Log.d(TAG, "количество данных в коллекции: " + Integer.toString(pressure.size()));
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "введенная дата уже существует в коллекции!\n" + "введите другую дату!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        Log.d(TAG, "значения в коллекцию добавлены!");
                        Log.d(TAG, "количество данных в коллекции: " + Integer.toString(pressure.size()));
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "количество данных в коллекции: " + Integer.toString(pressure.size()), Toast.LENGTH_SHORT);
                        toast.show();


                    }

                }
                catch (NumberFormatException e) {
                    Log.d(TAG, "возникло исключение при преобразовании введенных значений", e);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "введите допустимые значения!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch (DateTimeParseException e) {
                    Log.d(TAG, "возникло исключение при преобразовании введенных значений даты и времени", e);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "введите допустимые значения даты и времени!", Toast.LENGTH_SHORT);
                    toast.show();

                }

                //upPressureField1.setText(lastTime.toString());

            }
        });
    }
}
