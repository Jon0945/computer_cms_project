package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ComputerWhereaboutTest {
    private LocationInformation testLocationInformation;
    private String testStreetName = "Hjalmar Petris Väg 32";
    private String testPostalCode = "352 46";
    private String testCityName = "Växjö";
    private String testCountryName = "SWEDEN";
    private ContactInformation testContactInformation;
    private String testEmail = "ture.test@gmail.com";
    private String testPhoneNr = "555 - TEST";
    private LocalDate testStartTime = LocalDate.parse("2020-01-01");
    private LocalDate testEndTime = LocalDate.parse("2022-01-01");
    private Note testNote;
    private String testNoteTitle = "Testing Note Functions";
    private String testNoteFreeText = "The computer is undergoing tests";
    private ComputerWhereabout testComputerWhereAbout;

    @BeforeEach
    public void createComputerWhereAbout() {
        testLocationInformation = new LocationInformation(testStreetName,testPostalCode,testCityName,testCountryName);
        testContactInformation = new ContactInformation(testEmail,testPhoneNr);
        testNote = new Note(testNoteTitle,testNoteFreeText);
        testComputerWhereAbout = new ComputerWhereabout(testLocationInformation,testContactInformation,
                testStartTime,testEndTime,testNote);
    }

    @AfterEach
    public void endComputerWhereAbout() {
        testLocationInformation = null;
        testContactInformation = null;
        testNote = null;
        testComputerWhereAbout = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        LocationInformation expectedLocationInformation = testLocationInformation;
        ContactInformation expectedContactInformation = testContactInformation;
        LocalDate expectedStartDate = testStartTime;
        LocalDate expectedEndDate = testEndTime;
        Note expectedNote = testNote;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testComputerWhereAbout.getId() > -1);
        assertEquals(expectedLocationInformation, testComputerWhereAbout.getLocationInformation());
        assertEquals(expectedContactInformation, testComputerWhereAbout.getContactInformation());
        assertEquals(expectedStartDate, testComputerWhereAbout.getStartTime());
        assertEquals(expectedEndDate, testComputerWhereAbout.getEndTime());
        assertEquals(expectedNote,testComputerWhereAbout.getNote());
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        ComputerWhereabout alternateComputerWhereAbout = new ComputerWhereabout(testLocationInformation,
                testContactInformation,testStartTime,testEndTime,testNote);

        //Assert
        assertEquals(alternateComputerWhereAbout, testComputerWhereAbout);
        assertEquals(alternateComputerWhereAbout.hashCode(),testComputerWhereAbout.hashCode());
    }

    @Test
    public void testToString() {

        //Act
        String result = testComputerWhereAbout.toString();

        //Assert
        assertTrue(result.contains(String.valueOf(testComputerWhereAbout.getLocationInformation())));
        assertTrue(result.contains(String.valueOf(testComputerWhereAbout.getContactInformation())));
        assertTrue(result.contains(String.valueOf(testComputerWhereAbout.getStartTime())));
        assertTrue(result.contains(String.valueOf(testComputerWhereAbout.getEndTime())));
        assertTrue(result.contains(String.valueOf(testComputerWhereAbout.getNote())));
    }



}
