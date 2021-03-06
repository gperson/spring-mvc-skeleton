package com.xpanxion.skeleton.dao;

import com.xpanxion.skeleton.dto.entity.CarEntity;

public interface CarDao {

    /**
     * Adds a car entity
     * 
     * @param car
     *            a car
     */
    public int addCar(CarEntity car);

    /**
     * Update a car entity
     * 
     * @param car
     *            a car
     */
    public void udpateCar(CarEntity car);
}
