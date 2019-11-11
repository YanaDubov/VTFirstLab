package com.yana.first.lab.beans;

import javax.annotation.Resource;

@Resource(name = "Passenger")
public class Passenger {

    public Passenger() {
    }

    public Passenger(Integer id, String firstName, String lastName, String dateOfBirth, String passportNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String passportNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String toString() {
        return this.id + "/" + this.firstName + "/" + this.lastName + "/" + this.dateOfBirth + "/" + this.passportNumber;
    }
}
