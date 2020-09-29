package se.lexicon.computer_cms_project.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.computer_cms_project.entity.ContactInformation;
import se.lexicon.computer_cms_project.entity.Note;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class NoteRepositoryTest {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    TestEntityManager entityManager;

    private Note testNote;
    private String testNoteTitle = "Testing Note Functions";
    private String testNoteFreeText = "The computer is undergoing tests";

    @BeforeEach
    void createTestNote(){
        testNote = entityManager.persistAndFlush(new Note(testNoteTitle,testNoteFreeText));
    }

    @Test
    void given_valid_title_findByNoteTitle_return_Note() {
        Optional<Note> matchingUser = noteRepository.findBynoteTitleIgnoreCase("Testing Note Functions");
        assertTrue(matchingUser.isPresent());
    }

    @Test
    void given_valid_freetext_findByNoteFreeText_return_Note() {
        Optional<Note> matchingUser = noteRepository.findBynoteFreeTextIgnoreCase("The computer is undergoing tests");
        assertTrue(matchingUser.isPresent());
    }
}
