package com.example.repository; // Assuming your repositories are in this package

import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for Customer entities.
 *
 * Since Customer entities are created and managed as part of an Order
 * (due to @OneToOne(cascade = CascadeType.ALL) in Order),
 * you might not need many custom methods here initially.
 * JpaRepository provides standard CRUD operations.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> { // String is the type of Customer's @Id

    // You can add custom query methods here if needed in the future, for example:
    // Optional<Customer> findByPhoneNumber(String phoneNumber);
    // List<Customer> findByNameContainingIgnoreCase(String nameFragment);
}