package com.xpanxion.skeleton.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.enums.CarType;

@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column
    private int lotId;

    @Column
    private int fuelLevel;

    @Column
    private int price;

    @Column
    private boolean isHybrid;

    @Column
    private boolean isOnSale;

    @Column
    @Enumerated(EnumType.STRING)
    private CarType carType;

    public CarEntity() {

    }

    public CarEntity(Car car) {
        this.fuelLevel = car.getFuelLevel();
        this.price = car.getPrice();
        this.isHybrid = car.isHybrid();
        this.isOnSale = car.isOnSale();
        this.carType = car.getCarType();
        this.lotId = car.getLotId();
        this.carId = car.getCarId();
    }

    public int getCarId() {
        return this.carId;
    }

    public CarType getCarType() {
        return this.carType;
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public int getLotId() {
        return this.lotId;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isHybrid() {
        return this.isHybrid;
    }

    public boolean isOnSale() {
        return this.isOnSale;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setHybrid(boolean isHybrid) {
        this.isHybrid = isHybrid;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public void setOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("CarId: " + this.carId + " LotId: " + this.lotId + " FuelLevel: " + this.fuelLevel + " Price: " + this.price + " HasHybrid: " + this.isHybrid + " CarType: "
                + this.carType + " IsOnSale: " + this.isOnSale);
    }
}
