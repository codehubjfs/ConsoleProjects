package com.hallbookingsystem.halldetails;

/**
 * The Amenity class represents an amenity available in a hall.
 * It contains the amenity's ID and type.
 * @author Sanjai
 * @since 10-May-2024
 */
public class Amenity {
    private int amenityId;
    private String amenityType;

    public Amenity(int amenityId, String amenityType) {
        this.amenityId = amenityId;
        this.amenityType = amenityType;
    }

    public int getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(int amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityType() {
        return amenityType;
    }

    public void setAmenityType(String amenityType) {
        this.amenityType = amenityType;
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId=" + amenityId +
                ", amenityType='" + amenityType + '\'' +
                '}';
    }
}
