package com.example.konovodov_hw_131;

import java.time.LocalDateTime;

public class PressureClass {
    private int upPressureValue;
    private int downPressureValue;
    private int pulseValue;
    private boolean tachycardiaValue;
    private LocalDateTime  dataTimeValue;

    public PressureClass(){}

    public PressureClass(int upPressureValue, int downPressureValue, int pulseValue, boolean tachycardiaValue, LocalDateTime dataTimeValue) {
        this.upPressureValue = upPressureValue;
        this.downPressureValue = downPressureValue;
        this.pulseValue = pulseValue;
        this.tachycardiaValue = tachycardiaValue;
        this.dataTimeValue = dataTimeValue;
    }

    public int getUpPressureValue() {
        return upPressureValue;
    }

    public void setUpPressureValue(int upPressureValue) {
        this.upPressureValue = upPressureValue;
    }

    public int getDownPressureValue() {
        return downPressureValue;
    }

    public void setDownPressureValue(int downPressureValue) {
        this.downPressureValue = downPressureValue;
    }

    public int getPulseValue() {
        return pulseValue;
    }

    public void setPulseValue(int pulseValue) {
        this.pulseValue = pulseValue;
    }

    public boolean isTachycardiaValue() {
        return tachycardiaValue;
    }

    public void setTachycardiaValue(boolean tachycardiaValue) {
        this.tachycardiaValue = tachycardiaValue;
    }

    public LocalDateTime getDataTimeValue() {
        return dataTimeValue;
    }

    public void setDataTimeValue(LocalDateTime dataTimeValue) {
        this.dataTimeValue = dataTimeValue;
    }

    @Override
    public String toString() {
        return "PressureClass{" +
                "upPressureValue=" + upPressureValue +
                ", downPressureValue=" + downPressureValue +
                ", pulseValue=" + pulseValue +
                ", tachycardiaValue=" + tachycardiaValue +
                ", dataTimeValue=" + dataTimeValue +
                '}';
    }
}

