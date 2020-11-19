package se.lexicon.computer_cms_project.service;

import se.lexicon.computer_cms_project.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createNewPerson(PersonDto newPersonDto);
    PersonDto updatePerson(PersonDto personDto);
    List<PersonDto> findByFirstName(String firstName);
    List<PersonDto> findByLastName(String lastName);
    PersonDto findByEmail(String email);
    PersonDto findByPhoneNr(String phoneNr);
    PersonDto findById(int personId);
    List<PersonDto> findByStreetName(String streetName);
    List<PersonDto> findByCityName(String cityName);
    List<PersonDto> findByPostalCode(String postalCode);
    List<PersonDto> findByCountryName(String countryName);
    List<PersonDto> findAllByActiveStatus(boolean activeStatus);
}
