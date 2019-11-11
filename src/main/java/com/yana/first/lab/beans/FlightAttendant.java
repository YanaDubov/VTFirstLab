package com.yana.first.lab.beans;

import javax.annotation.Resource;

@Resource(name = "Flight attendant")
public class FlightAttendant extends Crew {
    public FlightAttendant() {
    }

    public FlightAttendant(Integer id, String firstName, String lastName, String phoneNumber, String address, String contractNumber, Integer yearsOfExperience) {
        super(id, firstName, lastName, phoneNumber, address, contractNumber);
        this.yearsOfExperience = yearsOfExperience;
    }

    private Integer yearsOfExperience;

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperiance(Integer yearsOfExperiance) {
        this.yearsOfExperience = yearsOfExperiance;
    }

    public String toString() {
        return this.getId() + "/" + this.getFirstName() + "/" + this.getLastName() + "/" + this.getPhoneNumber() + "/" + this.getAddress() + "/" + this.getContractNumber() + "/" + this.getYearsOfExperience();
    }
}
