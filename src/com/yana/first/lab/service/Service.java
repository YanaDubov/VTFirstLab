package com.yana.first.lab.service;

import java.util.List;

public interface Service<T> {
    public List<T> getAll();

    public T getById(Integer id);

    public void create(T t);

    public void update(T t);

    public void deleteById(Integer id);

    public List<T> sort();

    public List<T> filter(T t);
}
