package com.yana.first.lab.dao;

import java.util.List;

/**
 * <code>Dao</code> objects provide operations with data.
 *
 * @param <T>
 */
public interface Dao<T> {
    /**
     * Get all T beans from the source
     *
     * @return List of T
     */
    List<T> getAll();

    /**
     * Get T bean by id from the source
     *
     * @param id
     * @return T bean
     */
    T getById(int id);

    /**
     * Write T bean to the source
     *
     * @param t new T bean
     */
    void create(T t);

    /**
     * Update information about T bean in the source
     *
     * @param t
     */
    void update(T t);

    /**
     * Delete T bean in the source
     *
     * @param id
     */
    void deleteById(int id);
}
