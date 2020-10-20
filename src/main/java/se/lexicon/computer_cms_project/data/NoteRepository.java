package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {
}
