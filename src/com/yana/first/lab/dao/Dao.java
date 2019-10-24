package com.yana.first.lab.dao;

import java.util.List;

public interface Dao<T> {
    public List<T> getAll();
    public T getById(int id);
    public void create(T t);
    public void update(T t);
    public void deleteById(int id);
}
