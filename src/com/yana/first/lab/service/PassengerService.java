package com.yana.first.lab.service;

import com.yana.first.lab.beans.Passenger;
import com.yana.first.lab.dao.PassengerDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PassengerService {
    private PassengerDao passengerDao = new PassengerDao();

    public List<Passenger> getAll() {
        return passengerDao.getAll();
    }

    public Passenger getById(Integer id) {
        return passengerDao.getById(id);
    }

    public void create(Passenger passenger) {
        passengerDao.create(passenger);
    }

    public void update(Passenger passenger) {
        passengerDao.update(passenger);
    }

    public void deleteById(Integer id) {
        passengerDao.deleteById(id);
    }

    public List<Passenger> sort() {
        List<Passenger> passengerList = passengerDao.getAll();
        passengerList.sort((Comparator.comparing(Passenger::getFirstName)));
        return passengerList;
    }

    public List<Passenger> filter(Passenger passenger) {
        List<Passenger> passengerList = passengerDao.getAll();
        return passengerList.stream().filter(item -> (passenger.getId() != null) && (item.getId().equals(passenger.getId())))
                .filter(item -> (passenger.getFirstName() != null) && (item.getFirstName().equals(passenger.getFirstName())))
                .filter(item -> (passenger.getLastName() != null) && (item.getLastName().equals(passenger.getLastName())))
                .filter(item -> (passenger.getDateOfBirth() != null) && (item.getDateOfBirth().equals(passenger.getDateOfBirth())))
                .filter(item -> (passenger.getPassportNumber() != null) && (item.getPassportNumber().equals(passenger.getPassportNumber())))
                .collect(Collectors.toList());

    }
}
