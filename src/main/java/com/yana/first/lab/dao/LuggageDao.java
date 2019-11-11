package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Luggage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of dao for luggage
 *
 * @see Dao
 */
public class LuggageDao implements Dao<Luggage> {
    private Map<Integer, Luggage> luggageMap = new HashMap<>();

    public LuggageDao() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Luggage.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Luggage luggage = new Luggage(Integer.parseInt(buffer[0]), Integer.parseInt(buffer[1]));
                luggageMap.put(luggage.getId(), luggage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public List<Luggage> getAll() {
        return new ArrayList<>(luggageMap.values());
    }

    public Luggage getById(int id) {
        return luggageMap.get(id);
    }

    public void create(Luggage luggage) {
        try {
            luggageMap.put(luggage.getId(), luggage);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Luggage luggage) {
        try {
            luggageMap.put(luggage.getId(), luggage);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            luggageMap.remove(id);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer= null;
        try {
            writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Luggage.txt"));
            for (Luggage luggage : luggageMap.values()) {
                writer.write(luggage.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
