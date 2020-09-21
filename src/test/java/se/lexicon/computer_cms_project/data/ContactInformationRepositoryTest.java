package se.lexicon.computer_cms_project.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.computer_cms_project.entity.ContactInformation;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ContactInformationRepositoryTest {
    @Autowired
    ContactInformationRepository contactInformationRepository;

    @Autowired
    TestEntityManager entityManager;

    private ContactInformation testContactInformation;
    private String testEmail = "ture.test@gmail.com";
    private String testPhoneNr = "555 - TEST";

    @BeforeEach
    void createTestContactInformation(){
        testContactInformation = entityManager.persistAndFlush(new ContactInformation(testEmail,testPhoneNr));
    }

    @Test
    void given_valid_email_findByEmail_return_ContactInformation() {
        Optional<ContactInformation> matchingUser = contactInformationRepository.findByEmailIgnoreCase("ture.test@gmail.com");
        assertTrue(matchingUser.isPresent());
    }

    @Test
    void given_valid_phoneNr_findByPhoneNr_return_ContactInformation() {
        Optional<ContactInformation> matchingUser = contactInformationRepository.findByPhoneNrIgnoreCase("555 - TEST");
        assertTrue(matchingUser.isPresent());
    }



}
