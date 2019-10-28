package com.yana.first.lab.service;

import com.yana.first.lab.beans.Ticket;
import com.yana.first.lab.dao.TicketDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService implements Service<Ticket> {
    private TicketDao ticketDao = new TicketDao();

    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    public Ticket getById(Integer id) {
        return ticketDao.getById(id);
    }

    public void create(Ticket ticket) {
        ticketDao.create(ticket);
    }

    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteById(Integer id) {
        ticketDao.deleteById(id);
    }

    public List<Ticket> sort() {
        List<Ticket> ticketList = ticketDao.getAll();
        ticketList.sort((Comparator.comparing(Ticket::getNumber)));
        return ticketList;
    }

    public List<Ticket> filter(Ticket ticket) {
        List<Ticket> ticketList = ticketDao.getAll();
        return ticketList.stream().filter(item -> (ticket.getId() != null) && (item.getId().equals(ticket.getId())))
                .filter(item -> (ticket.getNumber() != null) && (item.getNumber().equals(ticket.getNumber())))
                .filter(item -> (ticket.getPassenger() != null) && (item.getPassenger().equals(ticket.getPassenger())))
                .collect(Collectors.toList());

    }
}
