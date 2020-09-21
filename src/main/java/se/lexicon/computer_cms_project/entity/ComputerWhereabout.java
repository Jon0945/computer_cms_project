package se.lexicon.computer_cms_project.entity;

import java.time.LocalDate;
import java.util.Objects;

public class ComputerWhereabout {
    //Fields
    private int id;
    private LocationInformation locationInformation;
    private ContactInformation contactInformation;
    private LocalDate startTime;
    private LocalDate endTime;
    private Note note;

    //Getters & Setters
    public int getId() { return id; }
    public LocationInformation getLocationInformation() { return locationInformation; }
    public void setLocationInformation(LocationInformation locationInformation) { this.locationInformation =
            locationInformation; }
    public ContactInformation getContactInformation() { return contactInformation; }
    public void setContactInformation(ContactInformation contactInformation) { this.contactInformation =
            contactInformation; }
    public LocalDate getStartTime() { return startTime; }
    public void setStartTime(LocalDate startTime) { this.startTime = startTime; }
    public LocalDate getEndTime() { return endTime; }
    public void setEndTime(LocalDate endTime) { this.endTime = endTime; }
    public Note getNote() { return note; }
    public void setNote(Note note) { this.note = note; }

    //Constructor 1
    public ComputerWhereabout(int id, LocationInformation locationInformation, ContactInformation contactInformation,
                              LocalDate startTime, LocalDate endTime, Note note) {
        this.id = id;
        this.setLocationInformation(locationInformation);
        this.setContactInformation(contactInformation);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setNote(note);
    }

    //Constructor 2 (No ID)
    public ComputerWhereabout(LocationInformation locationInformation, ContactInformation contactInformation,
                              LocalDate startTime, LocalDate endTime, Note note) {
        this(0, locationInformation, contactInformation, startTime, endTime, note);
    }

    //Empty Constructor
    public ComputerWhereabout() {}

    //Equals & Hashcode Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerWhereabout that = (ComputerWhereabout) o;
        return id == that.id &&
                locationInformation.equals(that.locationInformation) &&
                contactInformation.equals(that.contactInformation) &&
                startTime.equals(that.startTime) &&
                endTime.equals(that.endTime) &&
                note.equals(that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationInformation, contactInformation, startTime, endTime, note);
    }

    //toString Override
    @Override
    public String toString() {
        return "ComputerWhereabout{" +
                "id=" + id +
                ", locationInformation=" + locationInformation +
                ", contactInformation=" + contactInformation +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", note=" + note +
                '}';
    }
}