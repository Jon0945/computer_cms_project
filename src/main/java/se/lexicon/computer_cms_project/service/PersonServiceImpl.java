package se.lexicon.computer_cms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.computer_cms_project.data.PersonRepository;
import se.lexicon.computer_cms_project.dto.PersonDto;
import se.lexicon.computer_cms_project.entity.Person;
import se.lexicon.computer_cms_project.exception.EntityNotFoundException;
import se.lexicon.computer_cms_project.exception.Exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepo;
    private DtoConversionService conversionService;

    @Autowired
    public void setPersonRepo(PersonRepository personRepo) { this.personRepo = personRepo; }

    @Autowired
    public void setConversionService(DtoConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public PersonDto createNewPerson(PersonDto newPersonDto) throws IllegalArgumentException {
        if(newPersonDto.getPersonId() !=0){
            throw new IllegalArgumentException("Person had invalid ID: " + newPersonDto.getPersonId());
        }
        Person newPerson = conversionService.dtoToPerson(newPersonDto);
        newPerson = personRepo.save(newPerson);
        return conversionService.personToDto(newPerson);
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) throws IllegalArgumentException,EntityNotFoundException {
        if(personDto.getPersonId() == 0){
            throw new IllegalArgumentException("Person had invalid ID: " + personDto.getPersonId());
        }
        Person person = personRepo.findById(personDto.getPersonId()).orElseThrow(Exceptions
                .entityNotFoundException("Requested Person could not be found"));
        person.setActive(personDto.isPersonActive());
        person.setContactInformation(
                conversionService.dtoToContactInformation(personDto.getPersonContactInformation())
        );
        person.setLocationInformation(
                conversionService.dtoToLocationInformation(personDto.getPersonLocationInformation())
        );
        person.setLastName(personDto.getPersonLastName());
        person.setFirstName(personDto.getPersonFirstName());
        personRepo.save(person);
        return personDto;
    }

    @Override
    public List<PersonDto> findByFirstName(String firstName) {
        List<Person> personList = personRepo.findByFirstNameContainingIgnoreCase(firstName);
        List<PersonDto> dtoList = new ArrayList<>();
        personList.forEach(person -> dtoList.add(conversionService.personToDto(person)));
        return dtoList;
    }

    @Override
    public List<PersonDto> findByLastName(String lastName) {
        List<Person> personList = personRepo.findByLastNameContainingIgnoreCase(lastName);
        List<PersonDto> dtoList = new ArrayList<>();
        personList.forEach(person -> dtoList.add(conversionService.personToDto(person)));
        return dtoList;
    }

    @Override
    public PersonDto findByEmail(String email) {
        Optional<Person> optionalPerson = personRepo.findByEmailContactInformationEmailIgnoreCase(email.trim());
        PersonDto dto = conversionService.personToDto(optionalPerson.orElseThrow(Exceptions
                .entityNotFoundException("Requested Person with email "+ email.trim() + " could not be found")));
        return dto;
    }


    @Override
    public PersonDto findByPhoneNr(String phoneNr) {
        Optional<Person> optionalPerson = personRepo.findByPhoneNrContactInformationPhoneNrIgnoreCase(phoneNr.trim());
        PersonDto dto = conversionService.personToDto(optionalPerson.orElseThrow(Exceptions
                .entityNotFoundException("Requested Person with phoneNr "+ phoneNr.trim() + " could not be found")));
        return dto;
    }

    @Override
    public PersonDto findById(int personId) {
        Optional<Person> optionalPerson = personRepo.findById(personId);
        Person person = optionalPerson.orElseThrow(Exceptions
                .entityNotFoundException("Requested Person could not be found"));
        return conversionService.personToDto(person);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> findByStreetName(String streetName) {
        List<Person> personList = personRepo.findByStreetNameLocationInformationStreetNameIgnoreCase(streetName);
        List<PersonDto> personDtos = new ArrayList<>();
        for(Person person : personList){
            personDtos.add(conversionService.personToDto(person));
        }
        return personDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> findByPostalCode(String postalCode) {
        List<Person> personList = personRepo.findByPostalCodeLocationInformationPostalCodeIgnoreCase(postalCode);
        List<PersonDto> personDtos = new ArrayList<>();
        for(Person person : personList){
            personDtos.add(conversionService.personToDto(person));
        }
        return personDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> findByCityName(String cityName) {
        List<Person> personList = personRepo.findByCityLocationInformationCityNameIgnoreCase(cityName);
        List<PersonDto> personDtos = new ArrayList<>();
        for(Person person : personList){
            personDtos.add(conversionService.personToDto(person));
        }
        return personDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> findByCountryName(String countryName) {
        List<Person> personList = personRepo.findByCountryLocationInformationCountryNameIgnoreCase(countryName);
        List<PersonDto> personDtos = new ArrayList<>();
        for(Person person : personList){
            personDtos.add(conversionService.personToDto(person));
        }
        return personDtos;
    }

    @Override
    public List<PersonDto> findAllByActiveStatus(boolean activeStatus) {
        List<Person> personList = personRepo.findByActive(activeStatus);
        return personList.stream()
                .map(person -> conversionService.personToDto(person))
                .collect(Collectors.toList());
    }
}
