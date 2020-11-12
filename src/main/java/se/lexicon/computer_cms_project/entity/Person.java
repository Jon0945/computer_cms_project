package se.lexicon.computer_cms_project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    private String firstName;
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationInformation_id")
    private LocationInformation locationInformation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactInformation_id")
    private ContactInformation contactInformation;
    private boolean active;

    //Constructor 1
    public Person(int personId, String firstName, String lastName, LocationInformation locationInformation, ContactInformation contactInformation, Boolean active) {
        this.personId = personId;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLocationInformation(locationInformation);
        this.setContactInformation(contactInformation);
        this.setActive(active);
    }

    //Constructor 2
    public Person(String firstName, String lastName, LocationInformation locationInformation, ContactInformation contactInformation, Boolean active) {
        this(0, firstName, lastName, locationInformation, contactInformation, active);
    }

    //Empty Constructor
    public Person() {}

    //Getters & Setters
    public int getId() { return personId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
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
        Person person = (Person) o;
        return personId == person.personId &&
                active == person.active &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                locationInformation.equals(person.locationInformation) &&
                contactInformation.equals(person.contactInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstName, lastName, locationInformation, contactInformation, active);
    }

    //toString Override
    @Override
    public String toString() {
        return "Person{" +
                "id=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locationInformation=" + locationInformation +
                ", contactInformation=" + contactInformation +
                ", active=" + active +
                '}';
    }
}