package se.lexicon.computer_cms_project.service;

import se.lexicon.computer_cms_project.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto createNewCompany(CompanyDto newCompanyDto);
    CompanyDto updateCompany(CompanyDto companyDto);
    CompanyDto findByEmail (String email);
    CompanyDto findByPhoneNr (String phoneNr);
    CompanyDto findById(int companyId);
    List<CompanyDto> findByCountryName (String countryName);
    List<CompanyDto> findByCityName(String cityName);
    List<CompanyDto> findByPostalCode(String postalCode);
    List<CompanyDto> findByStreetName(String streetName);
    List<CompanyDto> findAllByActiveStatus(boolean activeStatus);
}
