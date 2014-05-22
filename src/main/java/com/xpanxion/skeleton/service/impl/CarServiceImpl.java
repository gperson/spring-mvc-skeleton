package com.xpanxion.skeleton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dao.CarDao;
import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.FunnyCar;
import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.Pinto;
import com.xpanxion.skeleton.dto.beans.SemiTruck;
import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.entity.CarEntity;
import com.xpanxion.skeleton.service.CarService;

@Transactional
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    public static int MAX_CARLOT_SIZE = 25;

    @Override
    public Car addCar(Lot lot, CarType car, int fuelLevel, boolean isHybrid, boolean isOnSale) {
        if (lot.getCars().size() < MAX_CARLOT_SIZE || lot.getCars() == null) {
            Car newCar;
            if (car == CarType.FUNNYCAR) {
                newCar = new FunnyCar(isHybrid, isOnSale);
            } else if (car == CarType.PINTO) {
                newCar = new Pinto(isHybrid, isOnSale);
            } else {
                newCar = new SemiTruck(isHybrid, isOnSale);
            }
            newCar.setLotId(lot.getId());
            newCar.setFuelLevel(fuelLevel);
            newCar.setCarId(this.carDao.addCar(new CarEntity(newCar)));
            return newCar;
        }
        return null;
    }

    @Override
    public boolean driveCar(Car car) {
        if (car.getFuelLevel() < car.getFuelUsedToDrive()) {
            return false;
        } else {
            car.setFuelLevel(car.getFuelLevel() - car.getFuelUsedToDrive());
            this.carDao.udpateCar(new CarEntity(car));
            return true;
        }
    }

    @Override
    public void updateCar(Car car) {
        this.carDao.udpateCar(new CarEntity(car));
    }

    @Override
    public Car updateCar(Lot lot, String carId, int fuelLevel, boolean onSale) {
        Car car = lot.getCar(Integer.parseInt(carId));
        car.setFuelLevel(fuelLevel);
        car.setOnSale(onSale);
        this.carDao.udpateCar(new CarEntity(car));
        return car;
    }
}
