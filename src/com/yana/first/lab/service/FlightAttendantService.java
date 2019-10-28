package com.yana.first.lab.service;

import com.yana.first.lab.beans.Crew;
import com.yana.first.lab.beans.FlightAttendant;
import com.yana.first.lab.dao.FlightAttendantDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlightAttendantService implements Service<FlightAttendant> {

    private FlightAttendantDao flightAttendantDao = new FlightAttendantDao();

    public List<FlightAttendant> getAll() {
        return flightAttendantDao.getAll();
    }

    public FlightAttendant getById(Integer id) {
        return flightAttendantDao.getById(id);
    }

    public void create(FlightAttendant flightAttendant) {
        flightAttendantDao.create(flightAttendant);
    }

    public void update(FlightAttendant flightAttendant) {
        flightAttendantDao.update(flightAttendant);
    }

    public void deleteById(Integer id) {
        flightAttendantDao.deleteById(id);
    }

    public List<FlightAttendant> sort() {
        List<FlightAttendant> flightAttendantList = flightAttendantDao.getAll();
        flightAttendantList.sort((Comparator.comparing(Crew::getFirstName)));
        return flightAttendantList;
    }

    public List<FlightAttendant> filter(FlightAttendant flightAttendant) {
        List<FlightAttendant> flightAttendantList = flightAttendantDao.getAll();
        return flightAttendantList.stream().filter(item -> (flightAttendant.getId() != null) && (item.getId().equals(flightAttendant.getId())))
                .filter(item -> (flightAttendant.getFirstName() != null) && (item.getFirstName().equals(flightAttendant.getFirstName())))
                .filter(item -> (flightAttendant.getLastName() != null) && (item.getLastName().equals(flightAttendant.getLastName())))
                .filter(item -> (flightAttendant.getPhoneNumber() != null) && (item.getPhoneNumber().equals(flightAttendant.getPhoneNumber())))
                .filter(item -> (flightAttendant.getAddress() != null) && (item.getAddress().equals(flightAttendant.getAddress())))
                .filter(item -> (flightAttendant.getYearsOfExperience() != null && (item.getYearsOfExperience().equals(flightAttendant.getYearsOfExperience()))))
                .collect(Collectors.toList());

    }
}
