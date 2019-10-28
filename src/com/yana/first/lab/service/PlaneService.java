package com.yana.first.lab.service;

import com.yana.first.lab.beans.Plane;
import com.yana.first.lab.dao.PlaneDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlaneService {
    private PlaneDao planeDao = new PlaneDao();

    public List<Plane> getAll() {
        return planeDao.getAll();
    }

    public Plane getById(Integer id) {
        return planeDao.getById(id);
    }

    public void create(Plane plane) {
        planeDao.create(plane);
    }

    public void update(Plane plane) {
        planeDao.update(plane);
    }

    public void deleteById(Integer id) {
        planeDao.deleteById(id);
    }

    public List<Plane> sort() {
        List<Plane> planeList = planeDao.getAll();
        planeList.sort((Comparator.comparing(Plane::getModel)));
        return planeList;
    }

    public List<Plane> filter(Plane plane) {
        List<Plane> planeList = planeDao.getAll();
        return planeList.stream().filter(item -> (plane.getId() != null) && (item.getId().equals(plane.getId())))
                .filter(item -> (plane.getModel() != null) && (item.getModel().equals(plane.getModel())))
                .filter(item -> (plane.getNumberOfSeats() != null) && (item.getNumberOfSeats().equals(plane.getNumberOfSeats())))
                .collect(Collectors.toList());

    }
}
