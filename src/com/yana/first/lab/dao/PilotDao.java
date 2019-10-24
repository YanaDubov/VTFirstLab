package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Pilot;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PilotDao {
    Map<Integer, Pilot> pilots = new HashMap<>();

    public PilotDao() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Pilot.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Pilot pilot = new Pilot(Integer.parseInt(buffer[0]), buffer[1], buffer[2], buffer[3], buffer[4],buffer[5],buffer[6]);
                pilots.put(pilot.getId(), pilot);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pilot> getAll() {
        return new ArrayList<>(pilots.values());
    }

    public Pilot getById(int id) {
        return pilots.get(id);
    }

    public void create(Pilot pilot) {
        pilots.put(pilot.getId(), pilot);
        writeToFile();
    }

    public void update(Pilot pilot) {
        pilots.put(pilot.getId(), pilot);
        writeToFile();
    }

    public void deleteById(int id) {
        pilots.remove(id);
        writeToFile();
    }

    private void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Pilot.txt"));
            for (Pilot pilot : pilots.values()) {
                writer.write(pilot.toString() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
