package com.yana.first.lab.beans;

import javax.annotation.Resource;

@Resource(name = "Pilot")
public class Pilot extends Crew {
    public Pilot() {
    }

    public Pilot(Integer id, String firstName, String lastName, String phoneNumber, String address, String contractNumber, String rank) {
        super(id, firstName, lastName, phoneNumber, address, contractNumber);
        this.rank = rank;
    }

    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString() {
        return this.getId() + "/" + this.getFirstName() + "/" + this.getLastName() + "/" + this.getPhoneNumber() + "/" + this.getAddress() + "/" + this.getContractNumber() + "/" + this.getRank();
    }
}
