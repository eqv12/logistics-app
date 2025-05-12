package com.example.entity;

// Changed from jakarta.persistence to javax.persistence
import javax.persistence.Embedded;
import javax.persistence.Embeddable;
// Changed from jakarta.validation.constraints to javax.validation.constraints
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

/**
 * Represents the details of a parcel, including weight and dimensions.
 * This will be embedded within the Order entity.
 */
@Embeddable
public class ParcelDetails {

    @NotNull(message = "Parcel weight cannot be null")
    @Min(value = 0, message = "Parcel weight must be non-negative")
    private Float weight; // in kg

    @Embedded
    @NotNull(message = "Parcel dimensions cannot be null")
    private ParcelDimensions dimensions;

    // Constructors
    public ParcelDetails() {
    }

    public ParcelDetails(Float weight, ParcelDimensions dimensions) {
        this.weight = weight;
        this.dimensions = dimensions;
    }

    // Getters and Setters
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public ParcelDimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(ParcelDimensions dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Gets the calculated volume in cubic meters.
     * This is for convenience and matches the readOnly 'volume' field in your OpenAPI spec.
     * @return Volume in cubic meters (m^3), or 0.0f if dimensions are not set.
     */
    public Float getVolumeM3() {
        if (this.dimensions != null) {
            return this.dimensions.calculateVolumeM3();
        }
        return 0.0f;
    }
}