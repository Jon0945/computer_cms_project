package se.lexicon.computer_cms_project.entity;

import javax.persistence.*;
import java.util.Objects;

public class Company {
    //Fields
    private int id;
    private String companyName;
    private LocationInformation locationInformation;
    private ContactInformation contactInformation;
    private Boolean active;

    //Constructor 1
    public Company(int id, String companyName, LocationInformation locationInformation,
                   ContactInformation contactInformation, Boolean active) {
        this.id = id;
        this.setCompanyName(companyName);
        this.setLocationInformation(locationInformation);
        this.setContactInformation(contactInformation);
        this.setActive(active);
    }

    //Constructor 2;
    public Company(String companyName, LocationInformation locationInformation,
                   ContactInformation contactInformation, Boolean active) {
        this(0,companyName,locationInformation,contactInformation,active);
    }

    //Empty Constructor
    public Company() {
    }

    //Getters & Setters
    public int getId() { return id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public LocationInformation getLocationInformation() { return locationInformation; }
    public void setLocationInformation(LocationInformation locationInformation) { this.locationInformation = locationInformation; }
    public ContactInformation getContactInformation() { return contactInformation; }
    public void setContactInformation(ContactInformation contactInformation) { this.contactInformation = contactInformation; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    //Equals & Hashcode Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getId() == company.getId() &&
                getCompanyName().equals(company.getCompanyName()) &&
                getLocationInformation().equals(company.getLocationInformation()) &&
                getContactInformation().equals(company.getContactInformation()) &&
                getActive().equals(company.getActive());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompanyName(), getLocationInformation(), getContactInformation(), getActive());
    }

    //toString Override
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locationInformation=" + locationInformation +
                ", contactInformation=" + contactInformation +
                ", active=" + active +
                '}';
    }
}