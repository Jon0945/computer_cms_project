package se.lexicon.computer_cms_project.service;

import se.lexicon.computer_cms_project.dto.*;
import se.lexicon.computer_cms_project.entity.*;

public interface DtoConversionService {
    Company dtoToCompany(CompanyDto dto);
    CompanyDto companyToDto (Company company);
    Computer dtoToComputer(ComputerDto dto);
    ComputerDto computerToDto (Computer computer);
    ComputerWhereabout dtoToComputerWhereAbout(ComputerWhereaboutDto dto);
    ComputerWhereaboutDto computerWhereAboutToDto(ComputerWhereabout computerWhereabout);
    ContactInformation dtoToContactInformation(ContactInformationDto dto);
    ContactInformationDto contactInformationToDto(ContactInformation contactInformation);
    LocationInformation dtoToLocationInformation(LocationInformationDto dto);
    LocationInformationDto locationInformationToDto(LocationInformation locationInformation);
    Note dtoToNote(NoteDto dto);
    NoteDto noteToDto(Note note);
    Person dtoToPerson(PersonDto dto);
    PersonDto personToDto (Person person);
}
