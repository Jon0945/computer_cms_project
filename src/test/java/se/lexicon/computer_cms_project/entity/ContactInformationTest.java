package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactInformationTest {
    private ContactInformation testContactInformation;
    private String testEmail = "ture.test@gmail.com";
    private String testPhoneNr = "555 - TEST";

    @BeforeEach
    public void createContact() {
        testContactInformation = new ContactInformation(testEmail,testPhoneNr);
    }

    @AfterEach
    public void endContact() {
        testContactInformation = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedEmail = testEmail;
        String expectedPhoneNr = testPhoneNr;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testContactInformation.getId() > -1);
        assertEquals(expectedEmail, testContactInformation.getEmail());
        assertEquals(expectedPhoneNr,testContactInformation.getPhoneNr());
    }

    @Test
    public void testToString() {

        //Act
        String result = testContactInformation.toString();

        //Assert
        assertTrue(result.contains(testEmail));
        assertTrue(result.contains(testPhoneNr));
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        ContactInformation alternateContactInformation = new ContactInformation(testEmail,testPhoneNr);

        //Assert
        assertEquals(alternateContactInformation, testContactInformation);
        assertEquals(alternateContactInformation.hashCode(),testContactInformation.hashCode());
    }

}
