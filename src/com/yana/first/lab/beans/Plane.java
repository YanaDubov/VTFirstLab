package com.yana.first.lab.beans;

import java.util.Date;

public class Plane {
    public Plane() {
    }

    public Plane(int id, String model, int numberOfSeats) {
        this.id = id;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    private int id;
    private String model;
    private int numberOfSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String toString(){
        return this.id + "/" + this.model + "/" + this.numberOfSeats;
    }
}
