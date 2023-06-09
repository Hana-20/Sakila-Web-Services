package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CityDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class CityService {
    
    private CrudServices<CityDto> cityService;
    
    public CityService() {
        cityService = new CrudServices<>(CityDto.class);
    }
    
    public CityDto getCityById(Integer id) {
        CityDto cityDto = (CityDto) cityService.getdtoById(id);
        if (cityDto== null)
        throw new ResourceNotFoundException("City with ID:" + id + " Not Found");
        return cityDto;
    }
    
    public void deleteCity(Integer id) {
        cityService.delete(id);
    }
    
    public void updateCity(CityDto cityDto) {
        cityService.update(cityDto);
    }
    
    public void addCity(CityDto cityDto) {
        cityService.add(cityDto);
    }
    
    public List<CityDto> findAllCities() {
        List<CityDto> cityDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : cityService.findAll()) {
            CityDto cityDto = (CityDto) sakilaDto;
            cityDtos.add(cityDto);
        }
        return cityDtos;
    }
}
