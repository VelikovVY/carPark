package com.carbrands.carpark.service;

import com.carbrands.carpark.entity.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    List<Car> findAll();
}
