package com.yana.first.lab.beans;

import javax.annotation.Resource;

@Resource(name = "Ticket")
public class Ticket {
    public Ticket() {
    }

    public Ticket(Integer id, Passenger passenger, String number) {
        this.id = id;
        this.passenger = passenger;
        this.number = number;
    }

    private Integer id;
    private Passenger passenger;
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String toString() {
        return this.id + "/" + this.passenger.getId() + "/" + this.number;
    }
}
