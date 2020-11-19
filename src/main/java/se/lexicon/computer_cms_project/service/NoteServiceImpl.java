package se.lexicon.computer_cms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.computer_cms_project.data.NoteRepository;
import se.lexicon.computer_cms_project.dto.NoteDto;
import se.lexicon.computer_cms_project.entity.Note;

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
}
