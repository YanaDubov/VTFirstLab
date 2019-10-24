package com.yana.first.lab.beans;

import java.io.Serializable;

public class FlightAttendant extends Crew{
    public FlightAttendant() {
    }

    public FlightAttendant(int id, String firstName, String lastName, String phoneNumber, String address, String contractNumber, int yearsOfExperiance) {
        super(id, firstName, lastName, phoneNumber, address, contractNumber);
        this.yearsOfExperiance = yearsOfExperiance;
    }

    private int yearsOfExperiance;

    public int getYearsOfExperiance() {
        return yearsOfExperiance;
    }

    public void setYearsOfExperiance(int yearsOfExperiance) {
        this.yearsOfExperiance = yearsOfExperiance;
    }

    public String toString(){
        return this.getId() + "/" + this.getFirstName() + "/" + this.getLastName() + "/" + this.getPhoneNumber() + "/" + this.getAddress() + "/" + this.getContractNumber() + "/" + this.getYearsOfExperiance();
    }
}
