package com.yana.first.lab.dao;

import com.yana.first.lab.beans.Passenger;
import com.yana.first.lab.beans.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketDao implements Dao<Ticket> {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private PassengerDao passengerDao = new PassengerDao();

    public TicketDao() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/yana/Projects/VTFirstLab/resources/Ticket.txt"));
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
        writeToFile();
    }

    public void update(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
        writeToFile();
    }

    public void deleteById(int id) {
        tickets.remove(id);
        writeToFile();
    }

    private void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/yana/Projects/VTFirstLab/resources/Ticket.txt"));
            for (Ticket ticket : tickets.values()) {
                writer.write(ticket.toString() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
