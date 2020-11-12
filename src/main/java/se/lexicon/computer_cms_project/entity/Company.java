package se.lexicon.computer_cms_project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Company {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    @Column(unique = true)
    private String companyName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationInformation_id")
    private LocationInformation locationInformation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactInformation_id")
    private ContactInformation contactInformation;
    private boolean active;

    //Constructor 1
    public Company(int companyId, String companyName, LocationInformation locationInformation,
                   ContactInformation contactInformation, Boolean active) {
        this.companyId = companyId;
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
    public int getId() { return companyId; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public LocationInformation getLocationInformation() { return locationInformation; }
    public void setLocationInformation(LocationInformation locationInformation) { this.locationInformation = locationInformation; }
    public ContactInformation getContactInformation() { return contactInformation; }
    public void setContactInformation(ContactInformation contactInformation) { this.contactInformation = contactInformation; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    //Equals & Hashcode Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyId == company.companyId &&
                active == company.active &&
                companyName.equals(company.companyName) &&
                locationInformation.equals(company.locationInformation) &&
                contactInformation.equals(company.contactInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, locationInformation, contactInformation, active);
    }

    //toString Override
    @Override
    public String toString() {
        return "Company{" +
                "id=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", locationInformation=" + locationInformation +
                ", contactInformation=" + contactInformation +
                ", active=" + active +
                '}';
    }
}