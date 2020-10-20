package se.lexicon.computer_cms_project.dto;

public class LocationInformationDto {
    private int locationInformationId;
    private String locationStreetName;
    private String locationPostalCode;
    private String locationCityName;
    private String locationCountryName;

    public LocationInformationDto(int locationInformationId, String locationStreetName, String locationPostalCode,
                                  String locationCityName, String locationCountryName) {
        this.setLocationInformationId(locationInformationId);
        this.setLocationStreetName(locationStreetName);
        this.setLocationPostalCode(locationPostalCode);
        this.setLocationCityName(locationCityName);
        this.setLocationCountryName(locationCountryName);
    }

    public LocationInformationDto() {}

    public int getLocationInformationId() { return locationInformationId; }
    public void setLocationInformationId(int locationInformationId) {
        this.locationInformationId = locationInformationId; }

    public String getLocationStreetName() { return locationStreetName; }
    public void setLocationStreetName(String locationStreetName) {
        this.locationStreetName = locationStreetName;
    }

    public String getLocationPostalCode() { return locationPostalCode; }
    public void setLocationPostalCode(String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
    }

    public String getLocationCityName() { return locationCityName; }
    public void setLocationCityName(String locationCityName) {
        this.locationCityName = locationCityName;
    }

    public String getLocationCountryName() { return locationCountryName; }
    public void setLocationCountryName(String locationCountryName) {
        this.locationCountryName = locationCountryName;
    }
}
