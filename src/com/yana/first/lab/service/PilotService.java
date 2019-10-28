package com.yana.first.lab.service;

import com.yana.first.lab.beans.Crew;
import com.yana.first.lab.beans.Pilot;
import com.yana.first.lab.dao.PilotDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PilotService {
    private PilotDao pilotDao = new PilotDao();

    public List<Pilot> getAll() {
        return pilotDao.getAll();
    }

    public Pilot getById(Integer id) {
        return pilotDao.getById(id);
    }

    public void create(Pilot pilot) {
        pilotDao.create(pilot);
    }

    public void update(Pilot pilot) {
        pilotDao.update(pilot);
    }

    public void deleteById(Integer id) {
        pilotDao.deleteById(id);
    }

    public List<Pilot> sort() {
        List<Pilot> flightAttendantList = pilotDao.getAll();
        flightAttendantList.sort((Comparator.comparing(Crew::getFirstName)));
        return flightAttendantList;
    }

    public List<Pilot> filter(Pilot pilot) {
        List<Pilot> pilotList = pilotDao.getAll();
        return pilotList.stream().filter(item -> (pilot.getId() != null) && (item.getId().equals(pilot.getId())))
                .filter(item -> (pilot.getFirstName() != null) && (item.getFirstName().equals(pilot.getFirstName())))
                .filter(item -> (pilot.getLastName() != null) && (item.getLastName().equals(pilot.getLastName())))
                .filter(item -> (pilot.getPhoneNumber() != null) && (item.getPhoneNumber().equals(pilot.getPhoneNumber())))
                .filter(item -> (pilot.getAddress() != null) && (item.getAddress().equals(pilot.getAddress())))
                .filter(item -> (pilot.getRank() != null && (item.getRank().equals(pilot.getRank()))))
                .collect(Collectors.toList());

    }
}
