package se.lexicon.computer_cms_project.dto;

import java.time.LocalDate;

public class ComputerWhereaboutDto {
    private int computerWhereAboutId;
    private LocationInformationDto computerWhereAboutLocationInformation;
    private ContactInformationDto computerWhereAboutContactInformation;
    private LocalDate computerWhereAboutStartTime;
    private LocalDate computerWhereAboutEndTime;
    private NoteDto computerWhereAboutNote;

    public ComputerWhereaboutDto(int computerWhereAboutId, LocationInformationDto computerWhereAboutLocationInformation,
                                 ContactInformationDto computerWhereAboutContactInformation,
                                 LocalDate computerWhereAboutStartTime, LocalDate computerWhereAboutEndTime,
                                 NoteDto computerWhereAboutNote) {
        this.setComputerWhereAboutId(computerWhereAboutId);
        this.setComputerWhereAboutLocationInformation(computerWhereAboutLocationInformation);
        this.setComputerWhereAboutContactInformation(computerWhereAboutContactInformation);
        this.setComputerWhereAboutStartTime(computerWhereAboutStartTime);
        this.setComputerWhereAboutEndTime(computerWhereAboutEndTime);
        this.setComputerWhereAboutNote(computerWhereAboutNote);
    }

    public ComputerWhereaboutDto() {} //Needed by Hibernate

    public int getComputerWhereAboutId() {
        return computerWhereAboutId;
    }

    public void setComputerWhereAboutId(int computerWhereAboutId) {
        this.computerWhereAboutId = computerWhereAboutId;
    }

    public LocationInformationDto getComputerWhereAboutLocationInformation() {
        return computerWhereAboutLocationInformation;
    }

    public void setComputerWhereAboutLocationInformation(LocationInformationDto computerWhereAboutLocationInformation) {
        this.computerWhereAboutLocationInformation = computerWhereAboutLocationInformation;
    }

    public ContactInformationDto getComputerWhereAboutContactInformation() {
        return computerWhereAboutContactInformation;
    }

    public void setComputerWhereAboutContactInformation(ContactInformationDto computerWhereAboutContactInformation) {
        this.computerWhereAboutContactInformation = computerWhereAboutContactInformation;
    }

    public LocalDate getComputerWhereAboutStartTime() {
        return computerWhereAboutStartTime;
    }

    public void setComputerWhereAboutStartTime(LocalDate computerWhereAboutStartTime) {
        this.computerWhereAboutStartTime = computerWhereAboutStartTime;
    }

    public LocalDate getComputerWhereAboutEndTime() {
        return computerWhereAboutEndTime;
    }

    public void setComputerWhereAboutEndTime(LocalDate computerWhereAboutEndTime) {
        this.computerWhereAboutEndTime = computerWhereAboutEndTime;
    }

    public NoteDto getComputerWhereAboutNote() {
        return computerWhereAboutNote;
    }

    public void setComputerWhereAboutNote(NoteDto computerWhereAboutNote) {
        this.computerWhereAboutNote = computerWhereAboutNote;
    }
}


