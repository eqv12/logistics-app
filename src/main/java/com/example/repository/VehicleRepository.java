package com.example.repository;
import com.example.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    // Add custom query methods if needed
}

