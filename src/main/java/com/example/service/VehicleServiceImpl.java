package com.example.service;

import com.example.entity.Vehicle;
import com.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(String id) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        return vehicleOpt.orElse(null);
    }

    @Override
    public void deleteVehicleById(String id) {
        vehicleRepository.deleteById(id);
    }
}

