package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Company;

import java.util.List;

public interface CompanyDAO extends CrudRepository<Company, Integer> {
    List<Company> findByCompanyNameIgnoreCase(String companyName);
    List<Company>findByStreetNameLocationInformationStreetNameIgnoreCase(String streetName);
    List<Company>findByPostalCodeLocationInformationPostalCodeIgnoreCase(String postalCode);
    List<Company>findByCityLocationInformationCityNameIgnoreCase(String cityName);
    List<Company>findByCountryLocationInformationCountryNameIgnoreCase(String countryName);
    List<Company>findByEmailContactInformationEmailIgnoreCase(String email);
    List<Company>findByPhoneNrContractInformationPhoneNrIgnoreCase(String phoneNr);

}
