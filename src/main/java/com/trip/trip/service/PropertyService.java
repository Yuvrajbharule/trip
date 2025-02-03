package com.trip.trip.service;

import com.trip.trip.entity.Property;
import com.trip.trip.payload.Property.PropertyRequestDto;
import com.trip.trip.payload.Property.PropertyResponseDto;
import com.trip.trip.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;
    private ModelMapper modelMapper;

    public PropertyService(PropertyRepository propertyRepository, ModelMapper modelMapper) {
        this.propertyRepository = propertyRepository;
        this.modelMapper = modelMapper;
    }

    public PropertyResponseDto createNewProperty(PropertyRequestDto dto) {

         Property property = mapToEntity(dto);
         property.setCreateAt(LocalDateTime.now());
         return mapToDto(propertyRepository.save(property));

    }

    public Property mapToEntity(PropertyRequestDto dto)
    {
        return modelMapper.map(dto,Property.class);
    }

    public PropertyResponseDto mapToDto(Property property)
    {
        return modelMapper.map(property,PropertyResponseDto.class);
    }
}
