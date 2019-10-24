package com.yana.first.lab.beans;

@Annotation(name = "Luggage")
public class Luggage {
    public Luggage() {
    }

    public Luggage(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    private int id;
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString(){
        return this.id + "/" + this.weight;
    }
}
