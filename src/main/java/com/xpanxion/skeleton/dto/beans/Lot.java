package com.xpanxion.skeleton.dto.beans;

import java.util.HashSet;
import java.util.Set;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.entity.CarEntity;
import com.xpanxion.skeleton.dto.entity.LotEntity;

public class Lot {

    private int id;
    private Set<Car> cars;

    public Lot() {

    }

    public Lot(LotEntity lot) {
        Set<Car> cars = new HashSet<Car>();
        for (CarEntity carEntity : lot.getCars()) {
            Car car = null;
            if (carEntity.getCarType() == CarType.FUNNYCAR) {
                car = new FunnyCar(carEntity);
            } else if (carEntity.getCarType() == CarType.PINTO) {
                car = new Pinto(carEntity);
            } else if (carEntity.getCarType() == CarType.SEMITRUCK) {
                car = new SemiTruck(carEntity);
            }
            cars.add(car);
        }
        this.cars = cars;
        this.id = lot.getId();
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public int getId() {
        return this.id;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public void setId(int id) {
        this.id = id;
    }
}
