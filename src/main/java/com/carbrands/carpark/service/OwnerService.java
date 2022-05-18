package com.carbrands.carpark.service;

import com.carbrands.carpark.entity.Owner;

import java.util.List;

public interface OwnerService {

    Owner save(Owner owner);

    Owner findById(Long id);

    List<Owner>findAll();

    List<Owner> findAllByName(String name);
}
