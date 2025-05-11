package com.example.controller;

import com.example.entity.Vehicle;
import com.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Get all vehicles
    @GetMapping
    public List<Vehicle> listVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Add a new vehicle
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle saved = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(saved);
    }

    // Get vehicle by ID
    @GetMapping("/{registrationNumber}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String registrationNumber) {
        Vehicle vehicle = vehicleService.getVehicleById(registrationNumber);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }

    // Delete vehicle by ID
    @DeleteMapping("/{registrationNumber}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String registrationNumber) {
        vehicleService.deleteVehicleById(registrationNumber);
        return ResponseEntity.noContent().build();
    }
}
