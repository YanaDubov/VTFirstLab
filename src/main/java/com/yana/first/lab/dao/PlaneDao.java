package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Plane;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of dao for plane
 *
 * @see Dao
 */
public class PlaneDao implements Dao<Plane> {
    private Map<Integer, Plane> planes = new HashMap<>();

    public PlaneDao() throws IOException {
        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Plane.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                Plane plane = new Plane(Integer.parseInt(buffer[0]), buffer[1], Integer.parseInt(buffer[2]));
                planes.put(plane.getId(), plane);
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

    public List<Plane> getAll() {
        return new ArrayList<>(planes.values());
    }

    public Plane getById(int id) {
        return planes.get(id);
    }

    public void create(Plane plane) {
        planes.put(plane.getId(), plane);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Plane plane) {
        planes.put(plane.getId(), plane);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        planes.remove(id);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer = null;
        try {

            writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Plane.txt"));
            for (Plane plane : planes.values()) {
                writer.write(plane.toString() + "\n");
            }
            writer.flush();
            writer.close();
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
