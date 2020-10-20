package se.lexicon.computer_cms_project.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.computer_cms_project.entity.Computer;

import java.time.LocalDate;
import java.util.List;

//TODO - Move TODO marked commands to service layer as they're too verbose
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
    List<Computer>findByActive(boolean active);
    //TODO List<Computer> findByStreetNameComputerWhereAboutLocationInformationStreetNameIgnoreCase(String streetName);
    //TODO List<Computer>findByPostalCodeComputerWhereAboutLocationInformationPostalCodeIgnoreCase(String postalCode);
    //TODO List<Computer>findByCityComputerWhereAboutLocationInformationCityNameIgnoreCase(String cityName);
    //TODO List<Computer>findByCountryComputerWhereAboutLocationInformationCountryNameIgnoreCase(String countryName);
    //TODO List<Computer>findByEmailComputerWhereAboutContactInformationEmailIgnoreCase(String email);
    //TODO List<Computer>findByPhoneNrComputerWhereAboutContractInformationPhoneNrIgnoreCase(String phoneNr);
    List<Computer>findByComputerWhereAboutDateTimeBetween(LocalDate start, LocalDate end);
}
