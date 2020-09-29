package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends CrudRepository<Note, Integer> {
    Optional<Note> findBynoteTitleIgnoreCase(String notetitle);
    Optional<Note> findBynoteFreeTextIgnoreCase(String notefreetext);
}
