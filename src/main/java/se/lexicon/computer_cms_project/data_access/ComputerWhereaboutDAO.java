package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.ComputerWhereabout;

import java.time.LocalDate;
import java.util.List;


public interface ComputerWhereaboutDAO extends CrudRepository<ComputerWhereabout, Integer> {
    List<ComputerWhereabout> findByStreetNameLocationInformationStreetNameIgnoreCase(String streetName);
    List<ComputerWhereabout>findByPostalCodeLocationInformationPostalCodeIgnoreCase(String postalCode);
    List<ComputerWhereabout>findByCityLocationInformationCityNameIgnoreCase(String cityName);
    List<ComputerWhereabout>findByCountryLocationInformationCountryNameIgnoreCase(String countryName);
    List<ComputerWhereabout>findByEmailContactInformationEmailIgnoreCase(String email);
    List<ComputerWhereabout>findByPhoneNrContractInformationPhoneNrIgnoreCase(String phoneNr);
    List<ComputerWhereabout>findByDateTimeBetween(LocalDate start, LocalDate end);
    List<ComputerWhereabout>findByNoteTitleIgnoreCase(String noteTitle);
    List<ComputerWhereabout>findByNoteFreeTextContainingIgnoreCase(String noteFreeText);
}
