package com.example.konovodov_hw_131;

public class UserValues {
    private float userWeight;
    private int usersteps;

    public UserValues(float userWeight, int usersteps) {
        this.userWeight = userWeight;
        this.usersteps = usersteps;
    }

    public float getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(float userWeight) {
        this.userWeight = userWeight;
    }

    public int getUsersteps() {
        return usersteps;
    }

    public void setUsersteps(int usersteps) {
        this.usersteps = usersteps;
    }

    @Override
    public String toString() {
        return "UserValues{" +
                "userWeight=" + userWeight +
                ", usersteps=" + usersteps +
                '}';
    }
}
