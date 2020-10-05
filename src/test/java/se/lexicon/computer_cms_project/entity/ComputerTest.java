package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ComputerTest {
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

    private Note testSupportNote;
    private String testSupportNoteTitle = "Testing Note Functions";
    private String testSupportNoteFreeText = "The computer is undergoing tests";
    private Note testOtherNote;
    private String testOtherNoteTitle = "What a cool machine!";
    private String testOtherNoteFreeText = "That doesn't exist";
    private ComputerWhereabout testComputerWhereAbout;
    private String test_brand = "Lenovo";
    private String test_model = "Thinkpad T420s";
    private String test_osSerialKey = "4FOO-BAR2-4TE9-ST34";
    private String test_serialNumber = "FU123456";
    private String test_cpuSpeed = "QuadCore 3.4 Ghz";
    private String test_gpuCard = "NVIDIA GeForce 2080Ti";
    private String test_ramSize = "32 GB";
    private String test_hddSize = "100 TB";
    private String test_screenResolution = "1024x480";

    private Computer testComputer;

    @BeforeEach
    public void createComputer() {
        testLocationInformation = new LocationInformation(testStreetName,testPostalCode,testCityName,testCountryName);
        testContactInformation = new ContactInformation(testEmail,testPhoneNr);
        testSupportNote = new Note(testSupportNoteTitle,testSupportNoteFreeText);
        testOtherNote = new Note(testOtherNoteTitle,testOtherNoteFreeText);
        testComputerWhereAbout = new ComputerWhereabout(testLocationInformation,testContactInformation,
                testStartTime,testEndTime,testSupportNote);
        testComputer = new Computer(test_brand,test_model,test_osSerialKey,test_serialNumber,test_cpuSpeed,
                test_gpuCard,test_ramSize,test_hddSize,test_screenResolution,testSupportNote,testOtherNote,
                true,testComputerWhereAbout);
    }

    @AfterEach
    public void endComputer() {
        testLocationInformation = null;
        testContactInformation = null;
        testSupportNote = null;
        testOtherNote = null;
        testComputerWhereAbout = null;
        testComputer = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedBrand = test_brand;
        String expectedModel = test_model;
        String expectedOsSerialKey = test_osSerialKey;
        String expectedSerialNumber = test_serialNumber;
        String expectedCpuSpeed = test_cpuSpeed;
        String expectedGpuCard = test_gpuCard;
        String expectedRamSize = test_ramSize;
        String expectedHddSize = test_hddSize;
        String expectedScreenResolution = test_screenResolution;
        Note expectedSupportNote = testSupportNote;
        Note expectedOtherNote = testOtherNote;
        ComputerWhereabout expectedComputerWhereAbout = testComputerWhereAbout;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testComputer.getId() > -1);
        assertEquals(expectedBrand, testComputer.getBrand());
        assertEquals(expectedModel, testComputer.getModel());
        assertEquals(expectedOsSerialKey, testComputer.getOsSerialKey());
        assertEquals(expectedSerialNumber, testComputer.getSerialNumber());
        assertEquals(expectedCpuSpeed,testComputer.getCpuSpeed());
        assertEquals(expectedGpuCard,testComputer.getGpuCard());
        assertEquals(expectedRamSize,testComputer.getRamSize());
        assertEquals(expectedHddSize,testComputer.getHddSize());
        assertEquals(expectedScreenResolution, testComputer.getScreenResolution());
        assertEquals(expectedSupportNote, testComputer.getSupportNote());
        assertEquals(expectedOtherNote, testComputer.getOtherNotes());
        assertEquals(expectedComputerWhereAbout, testComputer.getComputerWhereabout());
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        Computer alternateComputer = new Computer(test_brand,test_model,test_osSerialKey,test_serialNumber,test_cpuSpeed,
                test_gpuCard,test_ramSize,test_hddSize,test_screenResolution,testSupportNote,testOtherNote,
                true,testComputerWhereAbout);

        //Assert
        assertEquals(alternateComputer, testComputer);
        assertEquals(alternateComputer.hashCode(),testComputer.hashCode());
    }

    @Test
    public void testToString() {

        //Act
        String result = testComputer.toString();

        //Assert
        assertTrue(result.contains(String.valueOf(testComputer.getBrand())));
        assertTrue(result.contains(String.valueOf(testComputer.getModel())));
        assertTrue(result.contains(String.valueOf(testComputer.getOsSerialKey())));
        assertTrue(result.contains(String.valueOf(testComputer.getSerialNumber())));
        assertTrue(result.contains(String.valueOf(testComputer.getCpuSpeed())));
        assertTrue(result.contains(String.valueOf(testComputer.getGpuCard())));
        assertTrue(result.contains(String.valueOf(testComputer.getRamSize())));
        assertTrue(result.contains(String.valueOf(testComputer.getHddSize())));
        assertTrue(result.contains(String.valueOf(testComputer.getScreenResolution())));
        assertTrue(result.contains(String.valueOf(testComputer.getSupportNote())));
        assertTrue(result.contains(String.valueOf(testComputer.getOtherNotes())));
        assertTrue(result.contains(String.valueOf(testComputer.isActiveStatus())));
        assertTrue(result.contains(String.valueOf(testComputer.getComputerWhereabout())));
    }
}
