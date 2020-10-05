package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.ContactInformation;

import java.util.Optional;

public interface ContactInformationDAO extends CrudRepository <ContactInformation, Integer> {
    Optional<ContactInformation> findByEmailIgnoreCase(String email);
    Optional<ContactInformation> findByPhoneNrIgnoreCase(String phoneNr);
}