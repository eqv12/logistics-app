package com.example.entity; // Assuming your entities are in this package

// Changed from jakarta.persistence to javax.persistence
import javax.persistence.Embeddable;
// Changed from jakarta.validation.constraints to javax.validation.constraints
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

/**
 * Represents the dimensions of a parcel.
 * This will be embedded within ParcelDetails.
 */
@Embeddable
public class ParcelDimensions {

    @NotNull(message = "Parcel length cannot be null")
    @Min(value = 0, message = "Parcel length must be non-negative")
    private Float length; // in cm

    @NotNull(message = "Parcel width cannot be null")
    @Min(value = 0, message = "Parcel width must be non-negative")
    private Float width;  // in cm

    @NotNull(message = "Parcel height cannot be null")
    @Min(value = 0, message = "Parcel height must be non-negative")
    private Float height; // in cm

    // Constructors
    public ParcelDimensions() {
    }

    public ParcelDimensions(Float length, Float width, Float height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Getters and Setters
    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * Calculates the volume based on the dimensions.
     * @return Volume in cubic centimeters (cm^3).
     */
    public Float calculateVolumeCm3() {
        if (length != null && width != null && height != null) {
            return length * width * height;
        }
        return 0.0f;
    }

    /**
     * Calculates the volume in cubic meters (m^3).
     * 1 m^3 = 1,000,000 cm^3
     * @return Volume in cubic meters (m^3).
     */
    public Float calculateVolumeM3() {
        return calculateVolumeCm3() / 1_000_000.0f;
    }
}