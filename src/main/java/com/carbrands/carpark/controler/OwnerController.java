package com.carbrands.carpark.controler;


import com.carbrands.carpark.converter.OwnerConverter;
import com.carbrands.carpark.dto.OwnerRequest;
import com.carbrands.carpark.dto.OwnerResponse;
import com.carbrands.carpark.entity.Owner;
import com.carbrands.carpark.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@AllArgsConstructor
@RestController
public class OwnerController {

    private final OwnerService ownerService;
    private final OwnerConverter ownerConverter;

    @PostMapping
    public ResponseEntity<OwnerResponse>save(@RequestBody final OwnerRequest ownerRequest){
        final Owner owner = ownerConverter.convert(ownerRequest);
        final Owner saved =ownerService.save(owner);

        return null;

    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus>findById(@PathVariable Long id) {
        Owner owner = ownerService.findById(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
