package se.lexicon.computer_cms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.computer_cms_project.data.ComputerRepository;
import se.lexicon.computer_cms_project.dto.ComputerDto;
import se.lexicon.computer_cms_project.entity.Computer;
import se.lexicon.computer_cms_project.exception.EntityNotFoundException;
import se.lexicon.computer_cms_project.exception.Exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl implements ComputerService {
    private ComputerRepository computerRepo;
    private DtoConversionService conversionService;

    @Autowired
    public void setComputerRepo(ComputerRepository computerRepo) {
        this.computerRepo = computerRepo;
    }

    @Autowired
    public void setDtoConversionService(DtoConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ComputerDto createNewComputer(ComputerDto newComputerDto) throws IllegalArgumentException {
        if(newComputerDto.getComputerId() !=0){
            throw new IllegalArgumentException("Computer had invalid ID" + newComputerDto.getComputerId());
        }
        Computer newComputer = conversionService.dtoToComputer(newComputerDto);
        newComputer = computerRepo.save(newComputer);
        return conversionService.computerToDto(newComputer);
    }

    @Override
    public ComputerDto updateComputer(ComputerDto computerDto) throws IllegalArgumentException,
            EntityNotFoundException {
        if(computerDto.getComputerId() == 0){
            throw new IllegalArgumentException("Computer had invalid ID" + computerDto.getComputerId());
        }
        Computer computer = computerRepo.findById(computerDto.getComputerId()).orElseThrow(Exceptions
                .entityNotFoundException("Requested Computer could not be found"));
        computer.setComputerWhereabout(conversionService.dtoToComputerWhereAbout(computerDto.getComputerWhereabout()));
        computer.setActiveStatus(computerDto.isActiveStatus());
        computer.setOtherNotes(conversionService.dtoToNote(computerDto.getComputerOtherNotes()));
        computer.setSupportNote(conversionService.dtoToNote((computerDto.getComputerSupportNote())));
        computer.setScreenResolution(computerDto.getComputerScreenResolution());
        computer.setHddSize(computerDto.getComputerHddSize());
        computer.setRamSize(computerDto.getComputerRamSize());
        computer.setGpuCard(computerDto.getComputerGpuCard());
        computer.setCpuSpeed(computerDto.getComputerCpuSpeed());
        computer.setSerialNumber(computerDto.getComputerSerialNumber());
        computer.setOsSerialKey(computerDto.getComputerOsSerialKey());
        computer.setModel(computerDto.getComputerModel());
        computer.setBrand(computerDto.getComputerBrand());
        computerRepo.save(computer);
        return computerDto;
    }

    @Override
    public List<ComputerDto> findByBrand(String brand) {
        List<Computer> computerList = computerRepo.findByBrand(brand);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByModel(String model) {
        List<Computer> computerList = computerRepo.findByModel(model);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByOsSerialKey(String serialKey) {
        List<Computer> computerList = computerRepo.findByOsSerialKey(serialKey);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findBySerialNumber(String serialNumber) {
        List<Computer> computerList = computerRepo.findBySerialNumber(serialNumber);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByCpuSpeed(String cpuSpeed) {
        List<Computer> computerList = computerRepo.findByCpuSpeed(cpuSpeed);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByGpuCard(String gpuCard) {
        List<Computer> computerList = computerRepo.findByGpuCard(gpuCard);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByRamSize(String ramSize) {
        List<Computer> computerList = computerRepo.findByRamSize(ramSize);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByHddSize(String hddSize) {
        List<Computer> computerList = computerRepo.findByHddSize(hddSize);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByScreenResolution(String screenResolution) {
        List<Computer> computerList = computerRepo.findByScreenResolution(screenResolution);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findAllByActiveStatus(boolean activeStatus) {
        List<Computer> computers = computerRepo.findByActive(activeStatus);
        return  computers.stream()
                .map(computer -> conversionService.computerToDto(computer))
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputerDto> findBySupportNoteTitle(String supportNoteTitle) {
        List<Computer> computerList = computerRepo.findBySupportNoteNoteNoteTitle(supportNoteTitle);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findBySupportNoteFreeText(String supportNoteFreeText) {
        List<Computer> computerList = computerRepo.findBySupportNoteNoteNoteFreeTextContaining(supportNoteFreeText);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByOtherNoteTitle(String otherNoteTitle) {
        List<Computer> computerList = computerRepo.findByOtherNoteNoteNoteTitle(otherNoteTitle);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByOtherNoteFreeText(String otherNoteFreeText) {
        List<Computer> computerList = computerRepo.findByOtherNoteNoteNoteFreeTextContaining(otherNoteFreeText);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComputerDto> findByCountryName(String countryName) {
        List<Computer> computerList = computerRepo.
                findByCountryComputerWhereAboutLocationInformationCountryNameIgnoreCase(countryName);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComputerDto> findByCityName(String cityName) {
        List<Computer> computerList = computerRepo.
                findByCityComputerWhereAboutLocationInformationCityNameIgnoreCase(cityName);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComputerDto> findByPostalCode(String postalCode) {
        List<Computer> computerList = computerRepo.
                findByPostalCodeComputerWhereAboutLocationInformationPostalCodeIgnoreCase(postalCode);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComputerDto> findByStreetName(String streetName) {
        List<Computer> computerList = computerRepo.
                findByStreetNameComputerWhereAboutLocationInformationStreetNameIgnoreCase(streetName);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByEmail(String email) {
        List<Computer> computerList = computerRepo.
                findByEmailComputerWhereAboutContactInformationEmailIgnoreCase(email);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public List<ComputerDto> findByPhoneNr(String phoneNr) {
        List<Computer> computerList = computerRepo.
                findByPhoneNrComputerWhereAboutContactInformationPhoneNrIgnoreCase(phoneNr);
        List<ComputerDto> dtoList = new ArrayList<>();
        computerList.forEach(computer -> dtoList.add(conversionService.computerToDto(computer)));
        return dtoList;
    }

    @Override
    public ComputerDto findById(int computerId) {
        Optional<Computer> optionalComputer = computerRepo.findById(computerId);
        Computer computer = optionalComputer.orElseThrow(Exceptions
                .entityNotFoundException("Requested Computer could not be found"));
        return conversionService.computerToDto(computer);
    }

}
