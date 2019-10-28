package com.yana.first.lab.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();

    T getById(int id);

    void create(T t);

    void update(T t);

    void deleteById(int id);
}
