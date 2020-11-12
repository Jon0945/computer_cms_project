package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.LocationInformation;

public interface LocationInformationRepository extends CrudRepository<LocationInformation, Integer> {
}
