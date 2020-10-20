package se.lexicon.computer_cms_project.dto;

public class ContactInformationDto {
    private int contactInformationId;
    private String contactInformationEmail;
    private String contactInformationPhone;

    public ContactInformationDto(int contactInformationId, String email, String phone) {
        this.setContactInformationId(contactInformationId);
        this.setContactInformationEmail(email);
        this.setContactInformationPhone(phone);
    }

    public ContactInformationDto() {}

    public int getContactInformationId() { return contactInformationId; }
    public void setContactInformationId(int contactInformationId) {
        this.contactInformationId = contactInformationId;
    }
    public String getContactInformationEmail() { return contactInformationEmail; }
    public void setContactInformationEmail(String email) { this.contactInformationEmail = email; }
    public String getContactInformationPhone() { return contactInformationPhone; }
    public void setContactInformationPhone(String phone) { this.contactInformationPhone = phone; }
}
