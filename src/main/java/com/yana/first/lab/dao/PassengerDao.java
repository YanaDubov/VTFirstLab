package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of dao for passenger
 *
 * @see Dao
 */
public class PassengerDao implements Dao<Passenger> {
    private Map<Integer, Passenger> passengers = new HashMap<>();

    public PassengerDao() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Passenger.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Passenger passenger = new Passenger(Integer.parseInt(buffer[0]), buffer[1], buffer[2], buffer[3], buffer[4]);
                passengers.put(passenger.getId(), passenger);
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

    public List<Passenger> getAll() {
        return new ArrayList<>(passengers.values());
    }

    public Passenger getById(int id) {
        return passengers.get(id);
    }

    public void create(Passenger passenger) {
        try {
            passengers.put(passenger.getId(), passenger);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Passenger passenger) {
        try {
            passengers.put(passenger.getId(), passenger);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            passengers.remove(id);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Passenger.txt"));
            for (Passenger passenger : passengers.values()) {
                writer.write(passenger.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
