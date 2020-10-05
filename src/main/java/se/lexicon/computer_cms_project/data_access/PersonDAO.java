package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Person;

import java.util.List;

public interface PersonDAO extends CrudRepository<Person, Integer> {
    List<Person>findByFirstNameIgnoreCase(String firstname);
    List<Person>findByLastNameIgnoreCase(String lastname);
    List<Person>findByStreetNameLocationInformationStreetNameIgnoreCase(String streetName);
    List<Person>findByPostalCodeLocationInformationPostalCodeIgnoreCase(String postalCode);
    List<Person>findByCityLocationInformationCityNameIgnoreCase(String cityName);
    List<Person>findByCountryLocationInformationCountryNameIgnoreCase(String countryName);
    List<Person>findByEmailContactInformationEmailIgnoreCase(String email);
    List<Person>findByPhoneNrContractInformationPhoneNrIgnoreCase(String phoneNr);
}
