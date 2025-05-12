package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType; // No longer needed for GenerationType.UUID
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator; // Import for Hibernate's UUID generator

/**
 * Represents a customer associated with an order.
 */
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID") // Use the name of the GenericGenerator
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator" // Hibernate's standard UUID string generator
    )
    @Column(name = "id", updatable = false, nullable = false, length = 36) // UUIDs as strings are typically 36 chars
    private String id;

    @NotBlank(message = "Customer name cannot be blank")
    private String name;

    @NotBlank(message = "Customer phone number cannot be blank")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    @NotNull(message = "Customer delivery address cannot be null")
    private Address deliveryAddress;

    // Constructors
    public Customer() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}

