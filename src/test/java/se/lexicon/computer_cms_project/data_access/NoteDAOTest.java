package se.lexicon.computer_cms_project.data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.computer_cms_project.entity.Note;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class NoteDAOTest {
    @Autowired
    NoteDAO noteDAO;

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
        Optional<Note> matchingUser = noteDAO.findByNoteTitleIgnoreCase("Testing Note Functions");
        assertTrue(matchingUser.isPresent());
    }

    @Test
    void given_valid_freetext_findByNoteFreeText_return_Note() {
        List<Note> matchingNotes = noteDAO.findByNoteFreeTextContainingIgnoreCase("computer is undergoing");
        assertEquals(1,matchingNotes.size());
        assertEquals(testNoteFreeText,matchingNotes.get(0).getNoteFreeText());
    }
}
