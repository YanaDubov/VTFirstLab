package com.yana.first.lab.service;

import java.util.List;

public interface Service<T> {
    public List<T> getAll();
    public T getById(int id);
    public void create(T t);
    public void update(T t);
    public void deleteById(int id);
}
