package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Computer;

public interface ComputerDAO extends CrudRepository<Computer, Integer> {
}
