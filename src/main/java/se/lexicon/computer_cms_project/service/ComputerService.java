package se.lexicon.computer_cms_project.service;

import se.lexicon.computer_cms_project.dto.ComputerDto;

import java.util.List;

public interface ComputerService {
    ComputerDto createNewComputer(ComputerDto newComputerDto);
    ComputerDto updateComputer(ComputerDto computerDto);
    List<ComputerDto> findByBrand(String brand);
    List<ComputerDto> findByModel(String model);
    List<ComputerDto> findByOsSerialKey(String serialKey);
    List<ComputerDto> findBySerialNumber(String serialNumber);
    List<ComputerDto> findByCpuSpeed(String cpuSpeed);
    List<ComputerDto> findByGpuCard(String gpuCard);
    List<ComputerDto> findByRamSize(String ramSize);
    List<ComputerDto> findByHddSize(String hddSize);
    List<ComputerDto> findByScreenResolution(String screenResolution);
    List<ComputerDto> findBySupportNoteTitle(String supportNoteTitle);
    List<ComputerDto> findBySupportNoteFreeText(String supportNoteFreeText);
    List<ComputerDto> findByOtherNoteTitle(String otherNoteTitle);
    List<ComputerDto> findByOtherNoteFreeText(String otherNoteFreeText);
    List<ComputerDto> findAllByActiveStatus(boolean activeStatus);
    List<ComputerDto> findByCountryName (String countryName);
    List<ComputerDto> findByCityName(String cityName);
    List<ComputerDto> findByPostalCode(String postalCode);
    List<ComputerDto> findByStreetName(String streetName);
    List<ComputerDto> findByEmail(String email);
    List<ComputerDto> findByPhoneNr(String phoneNr);
    ComputerDto findById(int computerId);
}
