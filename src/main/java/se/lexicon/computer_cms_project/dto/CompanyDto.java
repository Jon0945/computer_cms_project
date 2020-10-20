package se.lexicon.computer_cms_project.dto;

public class CompanyDto {

    public class CompanyDTO {
        private int companyId;
        private String companyName;
        private LocationInformationDto companyLocationInformation;
        private ContactInformationDto companyContactInformation;
        private boolean companyActive;

        public CompanyDTO(int companyId, String companyName, LocationInformationDto companyLocationInformation,
                          ContactInformationDto companyContactInformation, boolean companyActive) {
            this.setCompanyId(companyId);
            this.setCompanyName(companyName);
            this.setCompanyLocationInformation(companyLocationInformation);
            this.setCompanyContactInformation(companyContactInformation);
            this.setCompanyActive(companyActive);
        }

        public CompanyDTO() {
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

        public LocationInformationDto getCompanyLocationInformation() {
            return companyLocationInformation;
        }

        public void setCompanyLocationInformation(LocationInformationDto companyLocationInformation) {
            this.companyLocationInformation = companyLocationInformation;
        }

        public ContactInformationDto getCompanyContactInformation() {
            return companyContactInformation;
        }

        public void setCompanyContactInformation(ContactInformationDto companyContactInformation) {
            this.companyContactInformation = companyContactInformation;
        }

        public boolean isCompanyActive() {
            return companyActive;
        }

        public void setCompanyActive(boolean companyActive) {
            this.companyActive = companyActive;
        }
    }
}
