package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

/**
 * Represents a physical address.
 * This will be embedded for source and delivery locations.
 * It stores the location as a JTS Point for PostGIS,
 * and provides transient getters for latitude/longitude.
 */
@Embeddable
public class Address {

    @NotBlank(message = "Street cannot be blank")
    private String street;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Pin code cannot be blank")
    @Column(name = "pin_code")
    private String pinCode;

    // Optional: Add country if it's consistently needed and not implied
    // private String country;

    @Column(name = "location_coordinates", columnDefinition = "geometry(Point,4326)")
    private Point location; // From org.locationtech.jts.geom

    // Constructors
    public Address() {
    }

    // Getters and Setters for standard fields
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    // Getter and Setter for the JTS Point
    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    @Transient
    public Double getLatitude() {
        if (this.location != null) {
            return this.location.getY();
        }
        return null;
    }

    @Transient
    public Double getLongitude() {
        if (this.location != null) {
            return this.location.getX();
        }
        return null;
    }

    public void setLocationFromDoubles(Double latitude, Double longitude) {
        if (latitude != null && longitude != null) {
            // SRID 4326 is for WGS84 standard lat/lon
            GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
            // JTS Coordinate constructor is (x, y) which means (longitude, latitude)
            this.location = geometryFactory.createPoint(new Coordinate(longitude, latitude));
            // Explicitly set SRID on the geometry object itself for robustness
            if (this.location != null) {
                this.location.setSRID(4326);
            }
        } else {
            this.location = null;
        }
    }
}