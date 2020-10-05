package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteDAO extends CrudRepository<Note, Integer> {
    Optional<Note> findByNoteTitleIgnoreCase(String noteTitle);
    List<Note> findByNoteFreeTextContainingIgnoreCase(String noteFreeText);
}
