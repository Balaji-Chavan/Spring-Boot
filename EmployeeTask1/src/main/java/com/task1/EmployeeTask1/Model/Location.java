package com.task1.EmployeeTask1.Model;

public class Location {
    private String locationId;
    private String locationName;
    private String locationCountry;





    public Location(String locationId, String locationName, String locationCountry) {
        super();
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationCountry = locationCountry;
    }

    public String getLocationId() {
        return locationId;
    }
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    public String getLocationName() {
        return locationName;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public String getLocationCountry() {
        return locationCountry;
    }
    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationCountry='" + locationCountry + '\'' +
                '}';
    }
}
