package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.ContactInformation;

public interface ContactInformationRepository extends CrudRepository <ContactInformation, Integer> {
}
