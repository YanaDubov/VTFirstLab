package com.yana.first.lab.beans;

import javax.annotation.Resource;

@Resource(name = "Luggage")
public class Luggage {
    public Luggage() {
    }

    public Luggage(Integer id) {
        this.id = id;
    }

    public Luggage(Integer id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }

    private Integer id;
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String toString() {
        return this.id + "/" + this.weight;
    }
}
