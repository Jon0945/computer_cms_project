package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Company;

import java.util.List;
import java.util.Optional;

//TODO -- Move too verbose commands to service layer
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    List<Company> findByCompanyNameIgnoreCase(String companyName);
    List<Company>findByStreetNameLocationInformationStreetNameIgnoreCase(String streetName);
    List<Company>findByPostalCodeLocationInformationPostalCodeIgnoreCase(String postalCode);
    List<Company>findByCityLocationInformationCityNameIgnoreCase(String cityName);
    List<Company>findByCountryLocationInformationCountryNameIgnoreCase(String countryName);
    Optional<Company>findByEmailContactInformationEmailIgnoreCase(String email);
    Optional<Company>findByPhoneNrContractInformationPhoneNrIgnoreCase(String phoneNr);
    List<Company>findByActive(boolean active);

}
