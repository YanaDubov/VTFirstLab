package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerDao implements Dao<Passenger> {
    private Map<Integer, Passenger> passengers = new HashMap<>();

    public PassengerDao() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Passenger.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Passenger passenger = new Passenger(Integer.parseInt(buffer[0]), buffer[1], buffer[2], buffer[3], buffer[4]);
                passengers.put(passenger.getId(), passenger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> getAll() {
        return new ArrayList<>(passengers.values());
    }

    public Passenger getById(int id) {
        return passengers.get(id);
    }

    public void create(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
        writeToFile();
    }

    public void update(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
        writeToFile();
    }

    public void deleteById(int id) {
        passengers.remove(id);
        writeToFile();
    }

    private void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Passenger.txt"));
            for (Passenger passenger : passengers.values()) {
                writer.write(passenger.toString() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
