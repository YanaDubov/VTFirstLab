package com.yana.first.lab.service;

import com.yana.first.lab.beans.FlightAttendant;
import com.yana.first.lab.dao.FlightAttendantDao;

import java.util.List;

public class FlightAttendantService implements Service<FlightAttendant> {

    private FlightAttendantDao flightAttendantDao = new FlightAttendantDao();

    public List<FlightAttendant> getAll() {
        return flightAttendantDao.getAll();
    }

    public FlightAttendant getById(int id) {
        return flightAttendantDao.getById(id);
    }

    public void create(FlightAttendant flightAttendant) {
        flightAttendantDao.create(flightAttendant);
    }

    public void update(FlightAttendant flightAttendant) {
        flightAttendantDao.update(flightAttendant);
    }

    public void deleteById(int id) {
        flightAttendantDao.deleteById(id);
    }

    public List<FlightAttendant> sortById(){
        List<FlightAttendant> flightAttendantList = flightAttendantDao.getAll();
        flightAttendantList.sort(((o1, o2) -> new Integer(o1.getId()).compareTo(o2.getId())));
        return flightAttendantList;
    }
}
