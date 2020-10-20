package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Company;

import java.util.List;

//TODO -- Move too verbose commands to service layer
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    List<Company> findByCompanyNameIgnoreCase(String companyName);
    //TODO List<Company>findByStreetNameLocationInformationStreetNameIgnoreCase(String streetName);
    //TODO List<Company>findByPostalCodeLocationInformationPostalCodeIgnoreCase(String postalCode);
    //TODO List<Company>findByCityLocationInformationCityNameIgnoreCase(String cityName);
    //TODO List<Company>findByCountryLocationInformationCountryNameIgnoreCase(String countryName);
    List<Company>findByEmailContactInformationEmailIgnoreCase(String email);
    List<Company>findByPhoneNrContractInformationPhoneNrIgnoreCase(String phoneNr);
    List<Company>findByActive(boolean active);

}
