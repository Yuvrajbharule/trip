package com.trip.trip.payload.Property;


public class PropertyRequestDto {

    private String name;
    private String noOfRooms;
    private String noOfBedrooms;
    private String noOfGuest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(String noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public String getNoOfGuest() {
        return noOfGuest;
    }

    public void setNoOfGuest(String noOfGuest) {
        this.noOfGuest = noOfGuest;
    }
}
