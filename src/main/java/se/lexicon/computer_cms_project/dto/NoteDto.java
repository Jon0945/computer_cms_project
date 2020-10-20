package se.lexicon.computer_cms_project.dto;

public class NoteDto {
    private int noteId;
    private String noteTitle;
    private String noteFreeText;

    public NoteDto(int noteId, String noteTitle, String noteFreeText) {
        this.setNoteId(noteId);
        this.setNoteTitle(noteTitle);
        this.setNoteFreeText(noteFreeText);
    }
    public NoteDto() {}

    public int getNoteId() { return noteId; }
    public void setNoteId(int noteId) { this.noteId = noteId; }
    public String getNoteTitle() { return noteTitle; }
    public void setNoteTitle(String noteTitle) { this.noteTitle = noteTitle; }
    public String getNoteFreeText() { return noteFreeText; }
    public void setNoteFreeText(String noteFreeText) { this.noteFreeText = noteFreeText; }
}
