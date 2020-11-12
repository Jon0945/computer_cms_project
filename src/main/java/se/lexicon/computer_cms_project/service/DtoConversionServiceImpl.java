package se.lexicon.computer_cms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.computer_cms_project.data.*;
import se.lexicon.computer_cms_project.dto.*;
import se.lexicon.computer_cms_project.entity.*;

@Service
@Transactional(readOnly = true)
public class DtoConversionServiceImpl implements DtoConversionService {
    private CompanyRepository companyRepository;
    private ComputerRepository computerRepository;
    private ComputerWhereaboutRepository computerWhereaboutRepository;
    private ContactInformationRepository contactInformationRepository;
    private LocationInformationRepository locationInformationRepository;
    private NoteRepository noteRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    //FIXME @Autowired
    //FIXME public void setComputerRepository(ComputerRepository computerRepository) {
    //FIXME    this.computerRepository = computerRepository;
    //FIXME }

    @Autowired
    public void setComputerWhereaboutRepository(ComputerWhereaboutRepository computerWhereaboutRepository) {
        this.computerWhereaboutRepository = computerWhereaboutRepository;
    }

    @Autowired
    public void setContactInformationRepository(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }

    @Autowired
    public void setLocationInformationRepository(LocationInformationRepository locationInformationRepository) {
        this.locationInformationRepository = locationInformationRepository;
    }

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Company dtoToCompany(CompanyDto dto) {
        return new Company(
                dto.getCompanyId(),
                dto.getCompanyName(),
                dtoToLocationInformation(dto.getLocationInformation()),
                dtoToContactInformation(dto.getContactInformation()),
                dto.isCompanyActive());
    }

    @Override
    @Transactional(readOnly = true)
    public CompanyDto companyToDto(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getCompanyName(),
                locationInformationToDto(company.getLocationInformation()),
                contactInformationToDto(company.getContactInformation()),
                company.isActive());
    }

    @Override
    public Computer dtoToComputer(ComputerDto dto) {
        return new Computer(
                dto.getComputerId(),
                dto.getComputerBrand(),
                dto.getComputerModel(),
                dto.getComputerOsSerialKey(),
                dto.getComputerSerialNumber(),
                dto.getComputerCpuSpeed(),
                dto.getComputerGpuCard(),
                dto.getComputerRamSize(),
                dto.getComputerHddSize(),
                dto.getComputerScreenResolution(),
                dtoToNote(dto.getComputerSupportNote()),
                dtoToNote(dto.getComputerOtherNotes()),
                dto.isActiveStatus(),
                dtoToComputerWhereAbout(dto.getComputerWhereabout()));
    }

    @Override
    public ComputerDto computerToDto(Computer computer) {
        return new ComputerDto(
                computer.getId(),
                computer.getBrand(),
                computer.getModel(),
                computer.getOsSerialKey(),
                computer.getSerialNumber(),
                computer.getCpuSpeed(),
                computer.getGpuCard(),
                computer.getRamSize(),
                computer.getHddSize(),
                computer.getScreenResolution(),
                noteToDto(computer.getSupportNote()),
                noteToDto(computer.getOtherNotes()),
                computer.isActiveStatus(),
                computerWhereAboutToDto(computer.getComputerWhereabout()));
    }

    @Override
    public ComputerWhereabout dtoToComputerWhereAbout(ComputerWhereaboutDto dto) {
        return new ComputerWhereabout(
                dto.getComputerWhereAboutId(),
                dtoToLocationInformation(dto.getComputerWhereAboutLocationInformation()),
                dtoToContactInformation(dto.getComputerWhereAboutContactInformation()),
                dto.getComputerWhereAboutStartTime(),
                dto.getComputerWhereAboutEndTime(),
                dtoToNote(dto.getComputerWhereAboutNote()));
    }

    @Override
    public ComputerWhereaboutDto computerWhereAboutToDto(ComputerWhereabout computerWhereabout) {
        return new ComputerWhereaboutDto(
                computerWhereabout.getId(),
                locationInformationToDto(computerWhereabout.getLocationInformation()),
                contactInformationToDto(computerWhereabout.getContactInformation()),
                computerWhereabout.getStartTime(),
                computerWhereabout.getEndTime(),
                noteToDto(computerWhereabout.getNote()));
    }

    @Override
    public ContactInformation dtoToContactInformation(ContactInformationDto dto) {
        return new ContactInformation(
                dto.getContactInformationId(),
                dto.getContactInformationEmail(),
                dto.getContactInformationPhone());
    }

    @Override
    public ContactInformationDto contactInformationToDto(ContactInformation contactInformation) {
        return new ContactInformationDto(
                contactInformation.getId(),
                contactInformation.getEmail(),
                contactInformation.getPhoneNr());
    }

    @Override
    public LocationInformation dtoToLocationInformation(LocationInformationDto dto) {
        return new LocationInformation(
                dto.getLocationInformationId(),
                dto.getLocationStreetName(),
                dto.getLocationPostalCode(),
                dto.getLocationCityName(),
                dto.getLocationCountryName());
    }

    @Override
    public LocationInformationDto locationInformationToDto(LocationInformation locationInformation) {
        return new LocationInformationDto(
                locationInformation.getId(),
                locationInformation.getStreetName(),
                locationInformation.getPostalCode(),
                locationInformation.getCityName(),
                locationInformation.getCountryName());
    }

    @Override
    public Note dtoToNote(NoteDto dto) {
        return new Note(
                dto.getNoteId(),
                dto.getNoteTitle(),
                dto.getNoteFreeText());
    }

    @Override
    public NoteDto noteToDto(Note note) {
        return new NoteDto(
                note.getId(),
                note.getNoteTitle(),
                note.getNoteFreeText());
    }

    @Override
    public Person dtoToPerson(PersonDto dto) {
        return new Person(
                dto.getPersonId(),
                dto.getPersonFirstName(),
                dto.getPersonLastName(),
                dtoToLocationInformation(dto.getPersonLocationInformation()),
                dtoToContactInformation(dto.getPersonContactInformation()),
                dto.isPersonaActive());
    }

    @Override
    public PersonDto personToDto(Person person) {
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                locationInformationToDto(person.getLocationInformation()),
                contactInformationToDto(person.getContactInformation()),
                person.isActive());
    }
}
