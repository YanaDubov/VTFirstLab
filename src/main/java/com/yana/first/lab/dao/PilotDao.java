package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Pilot;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of dao for pilot
 *
 * @see Dao
 */
public class PilotDao implements Dao<Pilot> {
    private Map<Integer, Pilot> pilots = new HashMap<>();

    public PilotDao() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Pilot.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Pilot pilot = new Pilot(Integer.parseInt(buffer[0]), buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], buffer[6]);
                pilots.put(pilot.getId(), pilot);
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

    public List<Pilot> getAll() {
        return new ArrayList<>(pilots.values());
    }

    public Pilot getById(int id) {
        return pilots.get(id);
    }

    public void create(Pilot pilot) {
        pilots.put(pilot.getId(), pilot);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Pilot pilot) {
        pilots.put(pilot.getId(), pilot);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        pilots.remove(id);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer = null;
        try {

            writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Pilot.txt"));
            for (Pilot pilot : pilots.values()) {
                writer.write(pilot.toString() + "\n");
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
