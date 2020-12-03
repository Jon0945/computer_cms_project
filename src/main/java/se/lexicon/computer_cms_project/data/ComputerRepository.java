package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Computer;

import java.time.LocalDate;
import java.util.List;

public interface ComputerRepository extends CrudRepository<Computer, Integer> {
    List<Computer> findByBrand(String brand);
    List<Computer> findByModel(String model);
    List<Computer> findByOsSerialKey(String serialKey);
    List<Computer> findBySerialNumber(String serialNumber);
    List<Computer> findByCpuSpeed(String cpuSpeed);
    List<Computer> findByGpuCard(String gpuCard);
    List<Computer> findByRamSize(String ramSize);
    List<Computer> findByHddSize(String hddSize);
    List<Computer> findByScreenResolution(String screenResolution);
    List<Computer> findBySupportNoteNoteNoteTitle(String supportNoteTitle);
    List<Computer> findBySupportNoteNoteNoteFreeTextContaining(String supportNoteFreeText);
    List<Computer> findByOtherNoteNoteNoteTitle(String otherNoteTitle);
    List<Computer> findByOtherNoteNoteNoteFreeTextContaining(String otherNoteFreeText);
    List<Computer> findByActive(boolean active);
    List<Computer> findByStreetNameComputerWhereAboutLocationInformationStreetNameIgnoreCase(String streetName);
    List<Computer> findByPostalCodeComputerWhereAboutLocationInformationPostalCodeIgnoreCase(String postalCode);
    List<Computer> findByCityComputerWhereAboutLocationInformationCityNameIgnoreCase(String cityName);
    List<Computer> findByCountryComputerWhereAboutLocationInformationCountryNameIgnoreCase(String countryName);
    List<Computer>findByEmailComputerWhereAboutContactInformationEmailIgnoreCase(String email);
    List<Computer>findByPhoneNrComputerWhereAboutContactInformationPhoneNrIgnoreCase(String phoneNr);
    List<Computer> findByComputerWhereAboutDateTimeBetween(LocalDate start, LocalDate end);
}
