package com.carbrands.carpark.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerRequest {

    private String name;

    private String lastName;

    private Integer EGN;

    private Set<CarRequest> carRequests;
}
