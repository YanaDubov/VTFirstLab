package com.yana.first.lab.dao;

import com.yana.first.lab.beans.FlightAttendant;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of dao for flight attendant
 *
 * @see Dao
 */
public class FlightAttendantDao implements Dao<FlightAttendant> {
    private Map<Integer, FlightAttendant> flightAttendants = new HashMap<>();

    public FlightAttendantDao() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/FlightAttendant.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                FlightAttendant flightAttendant = new FlightAttendant(Integer.parseInt(buffer[0]), buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], Integer.parseInt(buffer[6]));
                flightAttendants.put(flightAttendant.getId(), flightAttendant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public List<FlightAttendant> getAll() {
        return new ArrayList<>(flightAttendants.values());
    }

    public FlightAttendant getById(int id) {
        return flightAttendants.get(id);
    }

    public void create(FlightAttendant flightAttendant) {
        try {
            flightAttendants.put(flightAttendant.getId(), flightAttendant);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(FlightAttendant flightAttendant) {
        try {
            flightAttendants.put(flightAttendant.getId(), flightAttendant);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            flightAttendants.remove(id);
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/FlightAttendant.txt"));
            for (FlightAttendant flightAttendant : flightAttendants.values()) {
                writer.write(flightAttendant.toString() + "\n");
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
