package com.yana.first.lab.service;

import java.util.List;

/**
 * <code>Service</code> objects provide the crud and sort/filter operations for beans.
 *
 * @param <T>
 */
public interface Service<T> {
    /**
     * Get all beans of T from dao
     *
     * @return List of all T objects
     */
    public List<T> getAll();

    /**
     * Get bean from dao by id
     *
     * @param id id of bean
     * @return bean
     */
    public T getById(Integer id);

    /**
     * Create a new instance of T
     *
     * @param t new bean
     */
    public void create(T t);

    /**
     * Update all information about bean
     *
     * @param t bean
     */
    public void update(T t);

    /**
     * Delete bean by id
     *
     * @param id id of bean
     */
    public void deleteById(Integer id);

    /**
     * Sort all beans
     *
     * @return Sorted list
     */
    public List<T> sort();

    /**
     * Filter all beans by bean
     *
     * @param t bean
     * @return Filtered list
     */
    public List<T> filter(T t);
}
