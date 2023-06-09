package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CountryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class CountryService {
    
    private CrudServices<CountryDto> countryService;
    
    public CountryService() {
        countryService = new CrudServices<>(CountryDto.class);
    }
    
    public CountryDto getCountryById(Integer id) {
        CountryDto countryDto = (CountryDto) countryService.getdtoById(id);
        if (countryDto== null)
        throw new ResourceNotFoundException("Country with ID:" + id + " Not Found");
        return countryDto;
    }
    
    public void deleteCountry(Integer id) {
        countryService.delete(id);
    }
    
    public void updateCountry(CountryDto countryDto) {
        countryService.update(countryDto);
    }
    
    public void addCountry(CountryDto countryDto) {
        countryService.add(countryDto);
    }
    
    public List<CountryDto> findAllCountries() {
        List<CountryDto> countryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : countryService.findAll()) {
            CountryDto countryDto = (CountryDto) sakilaDto;
            countryDtos.add(countryDto);
        }
        return countryDtos;
    }
}
