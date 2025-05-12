//package com.example.entity;
//
//import javax.persistence.*; // For all JPA annotations
//import javax.validation.constraints.NotNull;
//import java.time.OffsetDateTime; // For date-time fields
//import org.hibernate.annotations.GenericGenerator; // Import for Hibernate's UUID generator
//
///**
// * Represents a delivery order.
// */
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(generator = "UUID") // Use the name of the GenericGenerator
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator" // Hibernate's standard UUID string generator
//    )
//    @Column(name = "id", updatable = false, nullable = false, length = 36) // UUIDs as strings are typically 36 chars
//    private String id;
//
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    @NotNull(message = "Order customer cannot be null")
//    private Customer customer;
//
//    @NotNull(message = "Order date cannot be null")
//    @Column(name = "order_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
//    private OffsetDateTime orderDate;
//
//    @NotNull(message = "Delivery type cannot be null")
//    @Column(name = "delivery_type")
//    private Integer deliveryType;
//
//    @Embedded
//    @NotNull(message = "Parcel details cannot be null")
//    private ParcelDetails parcelDetails;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "source_street")),
//            @AttributeOverride(name = "city", column = @Column(name = "source_city")),
//            @AttributeOverride(name = "state", column = @Column(name = "source_state")),
//            @AttributeOverride(name = "pinCode", column = @Column(name = "source_pin_code")),
//            @AttributeOverride(name = "location", column = @Column(name = "source_location_coordinates", columnDefinition = "geometry(Point,4326)"))
//    })
//    @NotNull(message = "Source location cannot be null")
//    private Address sourceLocation;
//
//    @Column(name = "logistics_status")
//    private String logisticsStatus;
//
//    @Column(name = "internal_processing_status")
//    private String internalProcessingStatus;
//
//    @Column(name = "delivery_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
//    private OffsetDateTime deliveryDate;
//
//    @Column(name = "assigned_vehicle_id")
//    private String assignedVehicleId;
//
//    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
//    private OffsetDateTime createdAt;
//
//    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
//    private OffsetDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = OffsetDateTime.now();
//        updatedAt = OffsetDateTime.now();
//        if (this.logisticsStatus == null) {
//            this.logisticsStatus = "Pending";
//        }
//        if (this.internalProcessingStatus == null) {
//            this.internalProcessingStatus = "Processing";
//        }
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = OffsetDateTime.now();
//    }
//
//    // Constructors
//    public Order() {
//    }
//
//    // Getters and Setters
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public OffsetDateTime getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(OffsetDateTime orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public Integer getDeliveryType() {
//        return deliveryType;
//    }
//
//    public void setDeliveryType(Integer deliveryType) {
//        this.deliveryType = deliveryType;
//    }
//
//    public ParcelDetails getParcelDetails() {
//        return parcelDetails;
//    }
//
//    public void setParcelDetails(ParcelDetails parcelDetails) {
//        this.parcelDetails = parcelDetails;
//    }
//
//    public Address getSourceLocation() {
//        return sourceLocation;
//    }
//
//    public void setSourceLocation(Address sourceLocation) {
//        this.sourceLocation = sourceLocation;
//    }
//
//    public String getLogisticsStatus() {
//        return logisticsStatus;
//    }
//
//    public void setLogisticsStatus(String logisticsStatus) {
//        this.logisticsStatus = logisticsStatus;
//    }
//
//    public String getInternalProcessingStatus() {
//        return internalProcessingStatus;
//    }
//
//    public void setInternalProcessingStatus(String internalProcessingStatus) {
//        this.internalProcessingStatus = internalProcessingStatus;
//    }
//
//    public OffsetDateTime getDeliveryDate() {
//        return deliveryDate;
//    }
//
//    public void setDeliveryDate(OffsetDateTime deliveryDate) {
//        this.deliveryDate = deliveryDate;
//    }
//
//    public String getAssignedVehicleId() {
//        return assignedVehicleId;
//    }
//
//    public void setAssignedVehicleId(String assignedVehicleId) {
//        this.assignedVehicleId = assignedVehicleId;
//    }
//
//    public OffsetDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(OffsetDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public OffsetDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(OffsetDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//}

package com.example.entity;

import javax.persistence.*; // For all JPA annotations
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime; // For date-time fields
import org.hibernate.annotations.GenericGenerator; // Import for Hibernate's UUID generator

/**
 * Represents a delivery order.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID") // Use the name of the GenericGenerator
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator" // Hibernate's standard UUID string generator
    )
    @Column(name = "id", updatable = false, nullable = false, length = 36) // UUIDs as strings are typically 36 chars
    private String id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @NotNull(message = "Order customer cannot be null")
    private Customer customer;

    @NotNull(message = "Order date cannot be null")
    @Column(name = "order_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime orderDate;

    @NotNull(message = "Delivery type cannot be null")
    @Column(name = "delivery_type")
    private Integer deliveryType;

    @Embedded
    @NotNull(message = "Parcel details cannot be null")
    private ParcelDetails parcelDetails;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "source_street")),
            @AttributeOverride(name = "city", column = @Column(name = "source_city")),
            @AttributeOverride(name = "state", column = @Column(name = "source_state")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "source_pin_code")),
            @AttributeOverride(name = "location", column = @Column(name = "source_location_coordinates", columnDefinition = "geometry(Point,4326)"))
    })
    @NotNull(message = "Source location cannot be null")
    private Address sourceLocation;

    @Column(name = "logistics_status")
    private String logisticsStatus;

    @Column(name = "internal_processing_status")
    private String internalProcessingStatus;

    @Column(name = "delivery_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime deliveryDate;

    // --- Changed from String assignedVehicleId to a ManyToOne relationship ---
    @ManyToOne(fetch = FetchType.LAZY) // An order belongs to one vehicle (or null if unassigned)
    @JoinColumn(name = "assigned_vehicle_registration_number", referencedColumnName = "registrationNumber", nullable = true)
    private Vehicle assignedVehicle; // Vehicle entity provided by user

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now();
        updatedAt = OffsetDateTime.now();
        if (this.logisticsStatus == null) {
            this.logisticsStatus = "Pending";
        }
        if (this.internalProcessingStatus == null) {
            this.internalProcessingStatus = "Processing";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now();
    }

    // Constructors
    public Order() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OffsetDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OffsetDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public ParcelDetails getParcelDetails() {
        return parcelDetails;
    }

    public void setParcelDetails(ParcelDetails parcelDetails) {
        this.parcelDetails = parcelDetails;
    }

    public Address getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(Address sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getInternalProcessingStatus() {
        return internalProcessingStatus;
    }

    public void setInternalProcessingStatus(String internalProcessingStatus) {
        this.internalProcessingStatus = internalProcessingStatus;
    }

    public OffsetDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(OffsetDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    // Updated getter and setter for assignedVehicle
    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(Vehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

