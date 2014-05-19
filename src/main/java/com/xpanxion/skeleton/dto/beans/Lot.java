package com.xpanxion.skeleton.dto.beans;

import java.util.ArrayList;
import java.util.List;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.entity.CarEntity;
import com.xpanxion.skeleton.dto.entity.LotEntity;

public class Lot {

    private int id;
    private List<Car> cars;

    public Lot() {

    }

    public Lot(LotEntity lot) {
        List<Car> cars = new ArrayList<Car>();
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

    public Car getCar(int carId) {
        for (Car car : this.cars) {
            if (car.getCarId() == carId) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getId() {
        return this.id;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setId(int id) {
        this.id = id;
    }
}
