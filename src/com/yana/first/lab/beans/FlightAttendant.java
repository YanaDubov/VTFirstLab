package com.yana.first.lab.beans;

import java.io.Serializable;

public class FlightAttendant implements Serializable {
    public FlightAttendant() {
    }
    private int yearsOfExperiance;

    public int getYearsOfExperiance() {
        return yearsOfExperiance;
    }

    public void setYearsOfExperiance(int yearsOfExperiance) {
        this.yearsOfExperiance = yearsOfExperiance;
    }
}
