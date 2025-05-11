package com.example.service;


import com.example.entity.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(String id);

    void deleteVehicleById(String id);
}

