package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person>findByFirstNameContainingIgnoreCase(String firstname);
    List<Person>findByLastNameContainingIgnoreCase(String lastname);
    List<Person>findByStreetNameLocationInformationStreetNameIgnoreCase(String streetName);
    List<Person>findByPostalCodeLocationInformationPostalCodeIgnoreCase(String postalCode);
    List<Person>findByCityLocationInformationCityNameIgnoreCase(String cityName);
    List<Person>findByCountryLocationInformationCountryNameIgnoreCase(String countryName);
    Optional<Person>findByEmailContactInformationEmailIgnoreCase(String email);
    Optional<Person> findByPhoneNrContractInformationPhoneNrIgnoreCase(String phoneNr);
    List<Person>findByActive(boolean active);
}
