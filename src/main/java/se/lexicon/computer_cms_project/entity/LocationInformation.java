package se.lexicon.computer_cms_project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class LocationInformation {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationInformationId;
    private String streetName;
    private String postalCode;
    private String cityName;
    private String countryName;

    //Getters & Setters
    public int getId() { return locationInformationId; }
    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }
    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }

    //Constructor 1
    public LocationInformation(int id, String streetName, String postalCode, String cityName, String countryName) {
        this.locationInformationId = id;
        this.setStreetName(streetName);
        this.setPostalCode(postalCode);
        this.setCityName(cityName);
        this.setCountryName(countryName);
    }

    //Constructor 2
    public LocationInformation(String streetName, String postalCode, String cityName, String countryName) {
        this(0, streetName, postalCode, cityName, countryName);
    }

    //Empty Constructor
    public LocationInformation() {}

    //Equals & Hashcode Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationInformation that = (LocationInformation) o;
        return locationInformationId == that.locationInformationId &&
                streetName.equals(that.streetName) &&
                postalCode.equals(that.postalCode) &&
                cityName.equals(that.cityName) &&
                countryName.equals(that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationInformationId, streetName, postalCode, cityName, countryName);
    }

    //toString Override
    @Override
    public String toString() {
        return "LocationInformation{" +
                "id=" + locationInformationId +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
