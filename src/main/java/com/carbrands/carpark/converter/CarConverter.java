package com.carbrands.carpark.converter;


import com.carbrands.carpark.dto.CarRequest;
import com.carbrands.carpark.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car convert(CarRequest carRequest){
        return Car.builder()
                .brand(carRequest.getBrand())
                .model(carRequest.getModel())
                .year(carRequest.getYear())

                .build();
    }


}
