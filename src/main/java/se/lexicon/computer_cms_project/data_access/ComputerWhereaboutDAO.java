package se.lexicon.computer_cms_project.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.ComputerWhereabout;

public interface ComputerWhereaboutDAO extends CrudRepository<ComputerWhereabout, Integer> {
}
