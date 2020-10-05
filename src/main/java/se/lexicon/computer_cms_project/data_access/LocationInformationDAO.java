package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.LocationInformation;

import java.util.List;

public interface LocationInformationDAO extends CrudRepository<LocationInformation, Integer> {
    List<LocationInformation>findByStreetNameIgnoreCase(String streetName);
    List<LocationInformation>findByPostalCodeIgnoreCase(String postalCode);
    List<LocationInformation>findByCityNameIgnoreCase(String cityName);
    List<LocationInformation> findByCountryNameIgnoreCase(String countryName);
}
