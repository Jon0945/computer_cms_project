package se.lexicon.computer_cms_project.data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.computer_cms_project.entity.LocationInformation;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LocationInformationDAOTest {
    @Autowired
    LocationInformationDAO locationInformationDAO;

    @Autowired
    TestEntityManager entityManager;

    private LocationInformation testLocationInformation;
    private String testStreetName = "Hjalmar Petris Väg 32";
    private String testPostalCode = "352 46";
    private String testCityName = "Växjö";
    private String testCountryName = "SWEDEN";

    @BeforeEach
    void createTestLocationInformation() {
        testLocationInformation = entityManager.persistAndFlush(new LocationInformation(testStreetName,
                testPostalCode,testCityName,testCountryName));
    }

    @Test
    void given_valid_countryName_findByCountryName_return_LocationInformation() {
        List<LocationInformation> matchingLocations = locationInformationDAO.findByCountryNameIgnoreCase("sweden");
        assertEquals(1, matchingLocations.size());
        assertEquals(testCountryName, matchingLocations.get(0).getCountryName());
    }

    @Test
    void given_valid_cityName_findByCityName_return_LocationInformation() {
        List<LocationInformation> matchingLocations = locationInformationDAO.findByCityNameIgnoreCase("växjö");
        assertEquals(1, matchingLocations.size());
        assertEquals(testCityName,matchingLocations.get(0).getCityName());
    }

    @Test
    void given_valid_postalCode_findByPostalCode_return_LocationInformation() {
        List<LocationInformation> matchingLocation = locationInformationDAO.findByPostalCodeIgnoreCase("352 46");
        assertEquals(1,matchingLocation.size());
        assertEquals(testPostalCode,matchingLocation.get(0).getPostalCode());
    }

    @Test
    void given_valid_streetName_findByStreetName_return_LocationInformation() {
        List<LocationInformation> matchingLocation =
                locationInformationDAO.findByStreetNameIgnoreCase("hjalmar petris väg 32");
        assertEquals(1,matchingLocation.size());
        assertEquals(testStreetName,matchingLocation.get(0).getStreetName());
    }
}
