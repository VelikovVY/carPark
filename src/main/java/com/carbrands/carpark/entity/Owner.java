package com.carbrands.carpark.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "Owners")

public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private Integer EGN;

    @JsonManagedReference
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "owners_cars",
            joinColumns = { @JoinColumn(name = "owner_id")},
            inverseJoinColumns = { @JoinColumn(name = "cars_id")}
    )
    private Set<Car> cars;


}
