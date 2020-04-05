package com.example.konovodov_hw_131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class ValuesActivity extends AppCompatActivity {
    Set<UserValues> userValues = new HashSet<UserValues>();
    private static final String TAG = "myLogs";
    Button buttonValues;
    Button buttonSave;

    EditText userWeight;
    EditText userSteps;

    //float value = new BigDecimal(str).floatValue(); //ввод значения с плавающей точкой
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values);
        init();

        buttonValuesClick();

        buttonSaveClick();


    }

    public void init() {

        Log.d(TAG, "найдем View элементы на экране ввода давления....");
        buttonValues = (Button) findViewById(R.id.buttonValues);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        userWeight = (EditText) findViewById(R.id.editText);
        userSteps = (EditText) findViewById(R.id.editText2);
        Log.d(TAG, "элементы View найдены");
    }

    public void buttonValuesClick() {
        buttonValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void buttonSaveClick() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int UserStepsValue;
                float weightUserValue;

                try {
                    UserStepsValue = Integer.parseInt(userSteps.getText().toString());
                    weightUserValue = Float.parseFloat(userWeight.getText().toString());
                    userValues.add(new UserValues(weightUserValue, UserStepsValue));
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Вес= " + Float.toString(weightUserValue) + "\n" + "Шаги= " + Integer.toString(UserStepsValue) + "\n" + "Объем коллекции= " + userValues.size(), Toast.LENGTH_SHORT);
                    toast.show();
                } catch (NumberFormatException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите корректные значения", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
