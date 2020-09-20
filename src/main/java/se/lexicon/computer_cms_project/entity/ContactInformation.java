package se.lexicon.computer_cms_project.entity;

import java.util.Objects;

public class ContactInformation {
    //Fields
    private int id;
    private String email;
    private String phoneNr;

    //Constructor 1
    public ContactInformation(int id, String email, String phoneNr) {
        this.id = id;
        this.setEmail(email);
        this.setPhoneNr(phoneNr);
    }
    //Constructor 2
    public ContactInformation(String email, String phoneNr) { this(0,email,phoneNr); }

    //Constructor 3
    public ContactInformation() {}

    //Getters & Setters
    public int getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNr() { return phoneNr; }
    public void setPhoneNr(String phoneNr) { this.phoneNr = phoneNr; }

    //Equals & Hashcode Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation contactInformation = (ContactInformation) o;
        return id == contactInformation.id &&
                email.equals(contactInformation.email) &&
                phoneNr.equals(contactInformation.phoneNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phoneNr);
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                '}';
    }
}
