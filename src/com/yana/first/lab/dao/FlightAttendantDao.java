package com.yana.first.lab.dao;

import com.yana.first.lab.beans.FlightAttendant;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightAttendantDao implements Dao<FlightAttendant>{
    Map<Integer, FlightAttendant> flightAttendants = new HashMap<>();

    public FlightAttendantDao() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/FlightAttendant.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                FlightAttendant flightAttendant = new FlightAttendant(Integer.parseInt(buffer[0]), buffer[1], buffer[2], buffer[3], buffer[4],buffer[5],Integer.parseInt(buffer[6]));
                flightAttendants.put(flightAttendant.getId(), flightAttendant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<FlightAttendant> getAll() {
        return new ArrayList<>(flightAttendants.values());
    }

    public FlightAttendant getById(int id) {
        return flightAttendants.get(id);
    }

    public void create(FlightAttendant flightAttendant) {
        flightAttendants.put(flightAttendant.getId(), flightAttendant);
        writeToFile();
    }

    public void update(FlightAttendant flightAttendant) {
        flightAttendants.put(flightAttendant.getId(), flightAttendant);
        writeToFile();
    }

    public void deleteById(int id) {
        flightAttendants.remove(id);
        writeToFile();
    }

    private void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/FlightAttendant.txt"));
            for (FlightAttendant flightAttendant : flightAttendants.values()) {
                writer.write(flightAttendant.toString() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
