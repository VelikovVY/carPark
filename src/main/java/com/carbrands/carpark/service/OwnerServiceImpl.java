package com.carbrands.carpark.service;

import com.carbrands.carpark.entity.Car;
import com.carbrands.carpark.entity.Owner;
import com.carbrands.carpark.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceImpl implements OwnerService{


    private final OwnerRepository ownerRepository;
    private final CarService carService;


    public OwnerServiceImpl(final OwnerRepository ownerRepository, CarService carService) {
        this.ownerRepository = ownerRepository;
        this.carService = carService;
    }


    @Override
    public Owner save(Owner owner) {
        Set<Car> cars = owner.getCars();
        for(Car car : cars){
            carService.save(car);
        }
        return ownerRepository.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findAllByName(String name) {
        return ownerRepository.findAllByName(name);
    }
}
