package com.yana.first.lab.beans;

public class Ticket{
    public Ticket() {
    }

    public Ticket(int id, Passenger passenger, String number) {
        this.id = id;
        this.passenger = passenger;
        this.number = number;
    }

    private int id;
    private Passenger passenger;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString(){
        return this.id + "/" + this.passenger.getId() + "/" + this.number;
    }
}
