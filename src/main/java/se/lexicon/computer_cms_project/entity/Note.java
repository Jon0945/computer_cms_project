package se.lexicon.computer_cms_project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Note {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;
    private String noteTitle;
    private String noteFreeText;

    //Getters & Setters
    public int getId() { return noteId; }
    public String getNoteTitle() { return noteTitle; }
    public void setNoteTitle(String noteTitle) { this.noteTitle = noteTitle; }
    public String getNoteFreeText() { return noteFreeText; }
    public void setNoteFreeText(String noteFreeText) { this.noteFreeText = noteFreeText; }

    //Constructor 1
    public Note(int noteId, String noteTitle, String noteFreeText) {
        this.noteId = noteId;
        this.setNoteTitle(noteTitle);
        this.setNoteFreeText(noteFreeText);
    }
    //Constructor 2
    public Note(String noteTitle, String noteFreeText) { this(0,noteTitle,noteFreeText); }

    //Constructor 3
    public Note() {}

    //Equals & Hashcode Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return noteId == note.noteId &&
                noteTitle.equals(note.noteTitle) &&
                noteFreeText.equals(note.noteFreeText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, noteTitle, noteFreeText);
    }

    //toString Override
    @Override
    public String toString() {
        return "Note{" +
                "id=" + noteId +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteFreeText='" + noteFreeText + '\'' +
                '}';
    }
}
