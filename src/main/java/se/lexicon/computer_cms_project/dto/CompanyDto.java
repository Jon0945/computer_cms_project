package se.lexicon.computer_cms_project.dto;

public class CompanyDto {
    private int companyId;
        private String companyName;
        private LocationInformationDto locationInformation;
        private ContactInformationDto contactInformation;
        private boolean companyActive;

        public CompanyDto(int companyId, String companyName, LocationInformationDto locationInformation,
                          ContactInformationDto contactInformation, boolean companyActive) {
            this.setCompanyId(companyId);
            this.setCompanyName(companyName);
            this.setLocationInformation(locationInformation);
            this.setContactInformation(contactInformation);
            this.setCompanyActive(companyActive);
        }

        public CompanyDto() {
        } //Needed by Hibernate

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public LocationInformationDto getLocationInformation() {
            return locationInformation;
        }

        public void setLocationInformation(LocationInformationDto companyLocationInformation) {
            this.locationInformation = companyLocationInformation;
        }

        public ContactInformationDto getContactInformation() {
            return contactInformation;
        }

        public void setContactInformation(ContactInformationDto companyContactInformation) {
            this.contactInformation = companyContactInformation;
        }

        public boolean isCompanyActive() {
            return companyActive;
        }

        public void setCompanyActive(boolean companyActive) {
            this.companyActive = companyActive;
        }
    }

