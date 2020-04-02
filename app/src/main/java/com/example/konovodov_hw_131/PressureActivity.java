package com.example.konovodov_hw_131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PressureActivity extends AppCompatActivity {
    Button backButtonPressure1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        backButtonPressure1 = (Button) findViewById(R.id.backButtonPressure);
        backButtonPressure1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
