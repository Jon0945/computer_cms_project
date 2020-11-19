package se.lexicon.computer_cms_project.dto;

public class PersonDto {
    private int personId;
    private String personFirstName;
    private String personLastName;
    private LocationInformationDto personLocationInformation;
    private ContactInformationDto personContactInformation;
    private boolean personActive;

    public PersonDto(int personId, String personFirstName, String personLastName,
                     LocationInformationDto personLocationInformation, ContactInformationDto personContactInformation, boolean active) {
        this.setPersonId(personId);
        this.setPersonFirstName(personFirstName);
        this.setPersonLastName(personLastName);
        this.setPersonLocationInformation(personLocationInformation);
        this.setPersonContactInformation(personContactInformation);
        this.setPersonActive(active);
    }

    public PersonDto() {}

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public LocationInformationDto getPersonLocationInformation() {
        return personLocationInformation;
    }

    public void setPersonLocationInformation(LocationInformationDto personLocationInformation) {
        this.personLocationInformation = personLocationInformation;
    }

    public ContactInformationDto getPersonContactInformation() {
        return personContactInformation;
    }

    public void setPersonContactInformation(ContactInformationDto personContactInformation) {
        this.personContactInformation = personContactInformation;
    }

    public boolean isPersonActive() {
        return personActive;
    }

    public void setPersonActive(boolean personActive) {
        this.personActive = personActive;
    }
}

