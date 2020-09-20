package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LocationInformationTest {
    private LocationInformation testLocationInformation;
    private String testStreetName = "Hjalmar Petris Väg 32";
    private String testPostalCode = "352 46";
    private String testCityName = "Växjö";
    private String testCountryName = "SWEDEN";

    @BeforeEach
    public void createLocation() {
        testLocationInformation = new LocationInformation(testStreetName,testPostalCode,testCityName,testCountryName);
    }

    @AfterEach
    public void endContact() {
        testLocationInformation = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedStreetName = testStreetName;
        String expectedPostalCode = testPostalCode;
        String expectedCityName = testCityName;
        String expectedCountryName = testCountryName;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testLocationInformation.getId() > -1);
        assertEquals(expectedStreetName, testLocationInformation.getStreetName());
        assertEquals(expectedPostalCode,testLocationInformation.getPostalCode());
        assertEquals(expectedCityName, testLocationInformation.getCityName());
        assertEquals(expectedCountryName,testLocationInformation.getCountryName());
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        LocationInformation alternateLocationInformation = new LocationInformation(testStreetName,testPostalCode,
                testCityName,testCountryName);

        //Assert
        assertEquals(alternateLocationInformation, testLocationInformation);
        assertEquals(alternateLocationInformation.hashCode(),testLocationInformation.hashCode());
    }

    @Test
    public void testToString() {

        //Act
        String result = testLocationInformation.toString();

        //Assert
        assertTrue(result.contains(testStreetName));
        assertTrue(result.contains(testPostalCode));
        assertTrue(result.contains(testCityName));
        assertTrue(result.contains(testCountryName));
    }



}
