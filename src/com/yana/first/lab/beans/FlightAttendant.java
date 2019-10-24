package com.yana.first.lab.beans;
@Annotation(name = "Flight attendant")
public class FlightAttendant extends Crew{
    public FlightAttendant() {
    }

    public FlightAttendant(int id, String firstName, String lastName, String phoneNumber, String address, String contractNumber, int yearsOfExperience) {
        super(id, firstName, lastName, phoneNumber, address, contractNumber);
        this.yearsOfExperience = yearsOfExperience;
    }

    private int yearsOfExperience;

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperiance(int yearsOfExperiance) {
        this.yearsOfExperience = yearsOfExperiance;
    }

    public String toString(){
        return this.getId() + "/" + this.getFirstName() + "/" + this.getLastName() + "/" + this.getPhoneNumber() + "/" + this.getAddress() + "/" + this.getContractNumber() + "/" + this.getYearsOfExperience();
    }
}
