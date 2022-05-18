package com.carbrands.carpark.service.service;

import com.carbrands.carpark.entity.Owner;
import com.carbrands.carpark.repository.OwnerRepository;
import com.carbrands.carpark.service.CarService;
import com.carbrands.carpark.service.OwnerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private OwnerServiceImpl ownerService;
    @Mock
    private CarService carService;

    @BeforeEach
    public void setUp () {
        ownerService = new OwnerServiceImpl(ownerRepository,carService);
    }

    @Test
    public void verifyFindAll() {

        ownerService.findAll();
        Mockito.verify(ownerRepository,Mockito.times(1)).findAll();
    }
    @Test
    public void verifySave(){

        Owner owner = Owner.builder()
                .id(1L)
                .name("Dimo")
                .build();
        Mockito.when(ownerRepository.save(any(Owner.class)))
                .thenReturn(Owner.builder().id(1L).name("Dimo").build());
        Owner saveOwner = ownerService.save(owner);

        Mockito.verify(ownerRepository, Mockito.times(1)).save(owner);
        assertEquals(owner.getId(),saveOwner.getId());
        assertEquals(owner.getName(),saveOwner.getName());
    }

    @Test
    public void verifyFindAllByName(){

        Mockito.when((ownerRepository.findAllByName(any(String.class))))
                .thenReturn(Collections.singletonList(Owner.builder().build()));

        List<Owner> owner = ownerService.findAllByName("");

        Mockito.verify(ownerRepository,Mockito.times(1)).findAllByName(any(String.class));
        assertEquals(1,owner.size());


    }
}