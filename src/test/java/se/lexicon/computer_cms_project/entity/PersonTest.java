package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonTest {
    private Person testPerson;
    private String testFirstName = "Ture";
    private String testLastName = "Test";
    private LocationInformation testLocationInformation;
    private String testStreetName = "Hjalmar Petris Väg 32";
    private String testPostalCode = "352 46";
    private String testCityName = "Växjö";
    private String testCountryName = "SWEDEN";
    private ContactInformation testContactInformation;
    private String testEmail = "ture.test@gmail.com";
    private String testPhoneNr = "555 - TEST";
    private boolean testActiveStatus = true;

    @BeforeEach
    public void createComputerWhereAbout() {
        testLocationInformation = new LocationInformation(testStreetName, testPostalCode, testCityName, testCountryName);
        testContactInformation = new ContactInformation(testEmail, testPhoneNr);
        testPerson = new Person(testFirstName, testLastName, testLocationInformation, testContactInformation, testActiveStatus);
    }

    @AfterEach
    public void endComputerWhereAbout() {
        testLocationInformation = null;
        testContactInformation = null;
        testPerson = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedFirstName = testFirstName;
        String expectedLastName = testLastName;
        LocationInformation expectedLocationInformation = testLocationInformation;
        ContactInformation expectedContactInformation = testContactInformation;
        Boolean expectedActiveStatus = testActiveStatus;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testPerson.getId() > -1);
        assertEquals(expectedFirstName, testPerson.getFirstName());
        assertEquals(expectedLastName, testPerson.getLastName());
        assertEquals(expectedLocationInformation, testPerson.getLocationInformation());
        assertEquals(expectedContactInformation, testPerson.getContactInformation());
        assertEquals(expectedActiveStatus,testPerson.isActive());
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        Person alternatePerson = new Person(testFirstName,testLastName,testLocationInformation,
                testContactInformation,true);

        //Assert
        assertEquals(alternatePerson, testPerson);
        assertEquals(alternatePerson.hashCode(),testPerson.hashCode());
    }

    @Test
    public void testToString() {

        //Act
        String result = testPerson.toString();

        //Assert
        assertTrue(result.contains(testFirstName));
        assertTrue(result.contains(testLastName));
        assertTrue(result.contains(String.valueOf(testPerson.getLocationInformation())));
        assertTrue(result.contains(String.valueOf(testPerson.getContactInformation())));
    }


}