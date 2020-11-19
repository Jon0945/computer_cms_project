package se.lexicon.computer_cms_project.service;

import se.lexicon.computer_cms_project.dto.NoteDto;

public interface NoteService {
    NoteDto createNewNote(NoteDto newNoteDto);
    NoteDto updateNote(NoteDto noteDto);
}
