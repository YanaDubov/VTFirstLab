package com.yana.first.lab.dao;

import com.yana.first.lab.beans.FlightAttendant;
import com.yana.first.lab.beans.Luggage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuggageDao {
    Map<Integer, Luggage> luggageMap = new HashMap<>();

    public LuggageDao() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Luggage.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Luggage luggage = new Luggage(Integer.parseInt(buffer[0]), Integer.parseInt(buffer[1]));
                luggageMap.put(luggage.getId(), luggage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Luggage> getAll() {
        return new ArrayList<>(luggageMap.values());
    }

    public Luggage getById(int id) {
        return luggageMap.get(id);
    }

    public void create(Luggage luggage) {
        luggageMap.put(luggage.getId(), luggage);
        writeToFile();
    }

    public void update(Luggage luggage) {
        luggageMap.put(luggage.getId(), luggage);
        writeToFile();
    }

    public void deleteById(int id) {
        luggageMap.remove(id);
        writeToFile();
    }

    private void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Luggage.txt"));
            for (Luggage luggage : luggageMap.values()) {
                writer.write(luggage.toString() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
