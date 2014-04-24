package com.xpanxion.skeleton.dto.beans;

import java.util.ArrayList;
import java.util.List;

public class Lot {

    private final List<Car> cars;

    public Lot() {
        this.cars = new ArrayList<Car>();
    }
}
