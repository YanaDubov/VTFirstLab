package com.yana.first.lab.service;

import com.yana.first.lab.beans.Luggage;
import com.yana.first.lab.dao.LuggageDao;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of service for luggage
 *
 * @see Service
 */
public class LuggageService {

    private LuggageDao luggageDao;

    {
        try {
            luggageDao = new LuggageDao();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Luggage> getAll() {
        return luggageDao.getAll();
    }

    public Luggage getById(Integer id) {
        return luggageDao.getById(id);
    }

    public void create(Luggage luggage) {
        luggageDao.create(luggage);
    }

    public void update(Luggage luggage) {
        luggageDao.update(luggage);
    }

    public void deleteById(Integer id) {
        luggageDao.deleteById(id);
    }

    public List<Luggage> sort() {
        List<Luggage> luggageList = luggageDao.getAll();
        luggageList.sort((Comparator.comparing(Luggage::getWeight)));
        return luggageList;
    }

    public List<Luggage> filter(Luggage luggage) {
        List<Luggage> luggageList = luggageDao.getAll();
        return luggageList.stream().filter(item -> (luggage.getId() == null) || (item.getId().equals(luggage.getId())))
                .filter(item -> (luggage.getWeight() == null) || (item.getWeight().equals(luggage.getWeight())))
                .collect(Collectors.toList());

    }
}
