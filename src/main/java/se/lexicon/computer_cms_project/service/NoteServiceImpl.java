package se.lexicon.computer_cms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.computer_cms_project.data.NoteRepository;
import se.lexicon.computer_cms_project.dto.NoteDto;
import se.lexicon.computer_cms_project.entity.Note;
import se.lexicon.computer_cms_project.exception.EntityNotFoundException;
import se.lexicon.computer_cms_project.exception.Exceptions;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepository noteRepo;
    private DtoConversionService conversionService;

    @Autowired
    public void setNoteRepo(NoteRepository noteRepo) { this.noteRepo = noteRepo; }

    @Autowired
    public void setConversionService(DtoConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public NoteDto createNewNote(NoteDto newNoteDto) throws IllegalArgumentException {
        if(newNoteDto.getNoteId() !=0){
            throw new IllegalArgumentException("Note had invalid ID: "+  newNoteDto.getNoteId());
        }
        Note newNote = conversionService.dtoToNote(newNoteDto);
        newNote = noteRepo.save(newNote);
        return conversionService.noteToDto(newNote);
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) throws IllegalArgumentException,EntityNotFoundException {
        if(noteDto.getNoteId() == 0){
            throw new IllegalArgumentException("Note had invalid ID: "+ noteDto.getNoteId());
        }
        Note note = noteRepo.findById(noteDto.getNoteId()).orElseThrow(Exceptions
                .entityNotFoundException("Requested Note could not be found"));
        note.setNoteFreeText(noteDto.getNoteFreeText());
        note.setNoteTitle(noteDto.getNoteTitle());
        noteRepo.save(note);
        return noteDto;
    }
}
