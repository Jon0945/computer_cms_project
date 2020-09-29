package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyTest {
    private Company testCompany;
    private String testCompanyName = "Test AB";
    private LocationInformation testLocationInformation;
    private String testStreetName = "Hjalmar Petris Väg 32";
    private String testPostalCode = "352 46";
    private String testCityName = "Växjö";
    private String testCountryName = "SWEDEN";
    private ContactInformation testContactInformation;
    private String testEmail = "ture.test@gmail.com";
    private String testPhoneNr = "555 - TEST";
    private Boolean testActiveStatus = true;

    @BeforeEach
    public void createComputerWhereAbout() {
        testLocationInformation = new LocationInformation(testStreetName, testPostalCode, testCityName, testCountryName);
        testContactInformation = new ContactInformation(testEmail, testPhoneNr);
        testCompany = new Company(testCompanyName, testLocationInformation, testContactInformation, testActiveStatus);
    }

    @AfterEach
    public void endComputerWhereAbout() {
        testLocationInformation = null;
        testContactInformation = null;
        testCompany = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedCompanyName = testCompanyName;
        LocationInformation expectedLocationInformation = testLocationInformation;
        ContactInformation expectedContactInformation = testContactInformation;
        Boolean expectedActiveStatus = testActiveStatus;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testCompany.getId() > -1);
        assertEquals(expectedCompanyName, testCompany.getCompanyName());
        assertEquals(expectedLocationInformation, testCompany.getLocationInformation());
        assertEquals(expectedContactInformation, testCompany.getContactInformation());
        assertEquals(expectedActiveStatus,testCompany.getActive());
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        Company alternateCompany = new Company(testCompanyName,testLocationInformation,
                testContactInformation,testActiveStatus);

        //Assert
        assertEquals(alternateCompany, testCompany);
        assertEquals(alternateCompany.hashCode(),testCompany.hashCode());
    }

    @Test
    public void testToString() {

        //Act
        String result = testCompany.toString();

        //Assert
        assertTrue(result.contains(testCompanyName));
        assertTrue(result.contains(String.valueOf(testCompany.getLocationInformation())));
        assertTrue(result.contains(String.valueOf(testCompany.getContactInformation())));
        assertTrue(result.contains((String.valueOf(testCompany.getActive()))));
    }
}
