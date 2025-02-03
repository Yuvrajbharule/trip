package com.trip.trip.controller;

import com.trip.trip.payload.Property.PropertyRequestDto;
import com.trip.trip.payload.Property.PropertyResponseDto;
import com.trip.trip.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createNewProperty(@RequestBody PropertyRequestDto dto)
    {
        PropertyResponseDto response = propertyService.createNewProperty(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
