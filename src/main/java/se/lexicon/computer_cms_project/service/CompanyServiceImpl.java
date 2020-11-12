package se.lexicon.computer_cms_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.computer_cms_project.data.CompanyRepository;
import se.lexicon.computer_cms_project.dto.CompanyDto;
import se.lexicon.computer_cms_project.entity.Company;
import se.lexicon.computer_cms_project.exception.EntityNotFoundException;
import se.lexicon.computer_cms_project.exception.Exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository userRepo;
    private DtoConversionService conversionService;

    @Autowired
    public void setUserRepo(CompanyRepository userRepo) { this.userRepo = userRepo; }

    @Autowired
    public void setConversionService(DtoConversionService conversionService) {
        this.conversionService = conversionService; }

    @Override
    public CompanyDto createNewCompany(CompanyDto newCompanyDto) throws  IllegalArgumentException {
        if(newCompanyDto.getCompanyId() !=0){
            throw new IllegalArgumentException("Company had invalid ID: " + newCompanyDto.getCompanyId());
        }
        Company newCompany = conversionService.dtoToCompany(newCompanyDto);
        newCompany = userRepo.save(newCompany);
        return conversionService.companyToDto(newCompany);
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto) throws IllegalArgumentException, EntityNotFoundException {
        if(companyDto.getCompanyId() == 0){
            throw new IllegalArgumentException("Company had invalid ID: " + companyDto.getCompanyId());
        }
        Company company = userRepo.findById(companyDto.getCompanyId()).orElseThrow(Exceptions
                .entityNotFoundException("Requested Company could not be found"));
        company.setActive(companyDto.isCompanyActive());
        company.setContactInformation(
                conversionService.dtoToContactInformation(companyDto.getContactInformation())
        );
        company.setLocationInformation(
                conversionService.dtoToLocationInformation(companyDto.getLocationInformation())
        );
        company.setCompanyName(companyDto.getCompanyName());
        userRepo.save(company);
        return  companyDto;
    }

    @Override
    public CompanyDto findByEmail(String email) {
        Optional<Company> companyOptional = userRepo.findByEmailContactInformationEmailIgnoreCase(email.trim());
        CompanyDto dto = conversionService.companyToDto(companyOptional.orElseThrow(Exceptions
                .entityNotFoundException("Requested Company with email "+ email.trim() + " could not be found")));
        return dto;
    }

    @Override
    public CompanyDto findByPhoneNr(String phoneNr) {
        Optional<Company> companyOptional = userRepo.findByPhoneNrContractInformationPhoneNrIgnoreCase(phoneNr.trim());
        CompanyDto dto = conversionService.companyToDto(companyOptional.orElseThrow((Exceptions
                .entityNotFoundException("Requested Company with phoneNr "+ phoneNr.trim() + " could not be found"))));
        return dto;
    }

    @Override
    public CompanyDto findById(int companyId) {
        Optional<Company> optionalCompany = userRepo.findById(companyId);
        Company company = optionalCompany.orElseThrow(Exceptions
                .entityNotFoundException("Requested Company could not be found"));
        return conversionService.companyToDto(company);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDto> findByCountryName(String countryName) {
        List<Company> companies = userRepo.findByCountryLocationInformationCountryNameIgnoreCase(countryName);
        List<CompanyDto> companyDtos = new ArrayList<>();
        for(Company company : companies) {
            companyDtos.add(conversionService.companyToDto(company));
        }
        return companyDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDto> findByCityName(String cityName) {
        List<Company> companies = userRepo.findByCityLocationInformationCityNameIgnoreCase(cityName);
        List<CompanyDto> companyDtos = new ArrayList<>();
        for(Company company : companies) {
            companyDtos.add(conversionService.companyToDto(company));
        }
        return companyDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDto> findByPostalCode(String postalCode) {
        List<Company> companies = userRepo.findByPostalCodeLocationInformationPostalCodeIgnoreCase(postalCode);
        List<CompanyDto> companyDtos = new ArrayList<>();
        for(Company company : companies) {
            companyDtos.add(conversionService.companyToDto(company));
        }
        return companyDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyDto> findByStreetName(String streetName) {
        List<Company> companies = userRepo.findByStreetNameLocationInformationStreetNameIgnoreCase(streetName);
        List<CompanyDto> companyDtos = new ArrayList<>();
        for(Company company : companies) {
            companyDtos.add(conversionService.companyToDto(company));
        }
        return companyDtos;
    }

    @Override
    public List<CompanyDto> findAllByActiveStatus(boolean activeStatus) {
        List<Company> companies = userRepo.findByActive(activeStatus);
        return  companies.stream()
                .map(company -> conversionService.companyToDto(company))
                .collect(Collectors.toList());
    }

}
