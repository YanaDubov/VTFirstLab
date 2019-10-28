package com.yana.first.lab.beans;

import javax.annotation.Resource;

@Resource(name = "Plane")
public class Plane {
    public Plane() {
    }

    public Plane(Integer id, String model, Integer numberOfSeats) {
        this.id = id;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    private Integer id;
    private String model;
    private Integer numberOfSeats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String toString() {
        return this.id + "/" + this.model + "/" + this.numberOfSeats;
    }
}
