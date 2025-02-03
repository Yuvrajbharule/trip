package com.trip.trip.payload.Property;

import java.time.LocalDateTime;

public class PropertyResponseDto {

    private String name;
    private LocalDateTime CreatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
}
