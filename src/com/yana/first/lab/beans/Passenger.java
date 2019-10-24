package com.yana.first.lab.beans;

@Annotation(name = "Passenger")
public class Passenger {

    public Passenger() {
    }

    public Passenger(int id, String firstName, String lastName, String dateOfBirth, String pasportNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.pasportNumber = pasportNumber;
    }

    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String pasportNumber;

    public int getId() {
        return id;
    }


    public void setId(int id) {
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

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public String toString(){
        return this.id + "/" + this.firstName + "/" + this.lastName + "/" + this.dateOfBirth + "/" + this.pasportNumber;
    }
}
