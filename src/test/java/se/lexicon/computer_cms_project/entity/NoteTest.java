package se.lexicon.computer_cms_project.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteTest {
    private Note testNote;
    private String testNoteTitle = "Testing Note Functions";
    private String testNoteFreeText = "The computer is undergoing tests";

    @BeforeEach
    public void createNote() { testNote = new Note(testNoteTitle,testNoteFreeText); }

    @AfterEach
    public void endNote() {
        testNote = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedNoteTitle = testNoteTitle;
        String expectedNoteFreeText = testNoteFreeText;

        //Act
        // done by @BeforeEach

        //Assert
        assertTrue(testNote.getId() > -1);
        assertEquals(expectedNoteTitle, testNote.getNoteTitle());
        assertEquals(expectedNoteFreeText,testNote.getNoteFreeText());
    }

    @Test
    public void testToString() {

        //Act
        String result = testNote.toString();

        //Assert
        assertTrue(result.contains(testNoteTitle));
        assertTrue(result.contains(testNoteFreeText));
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        Note alternateNote = new Note(testNoteTitle,testNoteFreeText);

        //Assert
        assertEquals(alternateNote, testNote);
        assertEquals(alternateNote.hashCode(),testNote.hashCode());
    }
}
