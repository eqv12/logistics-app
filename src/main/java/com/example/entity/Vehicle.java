package com.example.entity;

import com.example.model.VehicleStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    private String registrationNumber;

    private String vehicleType;
    private Float capacity;
    private Float availableCapacity;

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Float getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Float availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Float getCapacity() {
        return capacity;
    }

    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;
}
