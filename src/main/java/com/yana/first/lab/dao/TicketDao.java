package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Passenger;
import com.yana.first.lab.beans.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of dao for ticket
 *
 * @see Dao
 */
public class TicketDao implements Dao<Ticket> {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private PassengerDao passengerDao;

    {
        try {
            passengerDao = new PassengerDao();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TicketDao() throws IOException {
        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Ticket.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buffer = line.split("/");
                int id = Integer.parseInt(buffer[0]);
                Passenger passenger = passengerDao.getById(Integer.parseInt(buffer[1]));
                String number = buffer[2];
                Ticket ticket = new Ticket(id, passenger, number);
                tickets.put(ticket.getId(), ticket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }
    }

    public List<Ticket> getAll() {
        return new ArrayList<>(tickets.values());
    }

    public Ticket getById(int id) {
        return tickets.get(id);
    }

    public void create(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        tickets.remove(id);
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() throws IOException {
        BufferedWriter writer=null;
        try {

            writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Ticket.txt"));
            for (Ticket ticket : tickets.values()) {
                writer.write(ticket.toString() + "\n");
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
