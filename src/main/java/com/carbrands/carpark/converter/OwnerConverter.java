package com.carbrands.carpark.converter;

import com.carbrands.carpark.dto.OwnerRequest;
import com.carbrands.carpark.entity.Owner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OwnerConverter {

    private CarConverter carConverter;

    public Owner convert(OwnerRequest ownerRequest){
        return Owner.builder()
                .name(ownerRequest.getName())
                .lastName(ownerRequest.getLastName())
                .EGN(ownerRequest.getEGN())
                .cars(ownerRequest.getCarRequests().stream().map(carRequest -> carConverter.convert(carRequest))
                        .collect(Collectors.toSet()))
                .build();
    }


}
