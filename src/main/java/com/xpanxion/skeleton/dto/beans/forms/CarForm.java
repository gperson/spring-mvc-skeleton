package com.xpanxion.skeleton.dto.beans.forms;

import java.util.HashMap;
import java.util.Map;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.enums.CarType;

public class CarForm {

    private static final String SELECT_PINTO = "pinto";
    private static final String SELECT_SEMI = "semi";
    private static final String SELECT_FUNNY = "funny";

    private String carId;

    private String carType;

    private int fuelLevel;

    private int price;

    private boolean hybrid;

    private boolean onSale;

    private Map<String, String> options;

    public CarForm() {
        this.setOptions();
    }

    public CarForm(Car car) {
        this.setOptions();
        this.carType = this.convertEnumToSelect(car.getCarType());
        this.fuelLevel = car.getFuelLevel();
        this.price = car.getPrice();
        this.hybrid = car.isHybrid();
        this.onSale = car.isOnSale();
        this.carId = car.getCarId() + "";
    }

    private String convertEnumToSelect(CarType type) {
        if (type == CarType.SEMITRUCK) {
            return SELECT_SEMI;
        } else if (type == CarType.PINTO) {
            return SELECT_PINTO;
        } else if (type == CarType.FUNNYCAR) {
            return SELECT_FUNNY;
        } else {
            return null;
        }
    }

    public String getCarId() {
        return this.carId;
    }

    public String getCarType() {
        return this.carType;
    }

    public CarType getCarTypeEnum() {
        if (this.carType.equals(SELECT_SEMI)) {
            return CarType.SEMITRUCK;
        } else if (this.carType.equals(SELECT_PINTO)) {
            return CarType.PINTO;
        } else if (this.carType.equals(SELECT_FUNNY)) {
            return CarType.FUNNYCAR;
        } else {
            return null;
        }
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public boolean getHybrid() {
        return this.hybrid;
    }

    public boolean getOnSale() {
        return this.onSale;
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public int getPrice() {
        return this.price;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setHybrid(boolean hybrid) {
        this.hybrid = hybrid;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    private void setOptions() {
        this.options = new HashMap<String, String>();
        this.options.put("", "Select a Type");
        this.options.put("pinto", "Pinto");
        this.options.put("semi", "Semi Truck");
        this.options.put("funny", "Funny Car");
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car Type: " + this.carType.toString() + " Fuel Level: " + this.fuelLevel + " Price: " + this.price + " Is hybrid: " + this.hybrid + " Is on Sale: " + this.onSale;
    }
}
