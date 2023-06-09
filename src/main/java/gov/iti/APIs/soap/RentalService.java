package gov.iti.APIs.soap;


import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.RentalDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class RentalService {
    
    private CrudServices<RentalDto> rentalService;
    
    public RentalService() {
        rentalService = new CrudServices<>(RentalDto.class);
    }
    
    public RentalDto getRentalById(Integer id) {
        RentalDto rentalDto = (RentalDto) rentalService.getdtoById(id);
        if (rentalDto== null)
        throw new ResourceNotFoundException("Rental with ID:" + id + " Not Found");
        return rentalDto;
    }
    
    public void deleteRental(Integer id) {
        rentalService.delete(id);
    }
    
    public void updateRental(RentalDto rentalDto) {
        rentalService.update(rentalDto);
    }
    
    public void addRental(RentalDto rentalDto) {
        rentalService.add(rentalDto);
    }
    
    public List<RentalDto> findAllRentals() {
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : rentalService.findAll()) {
            RentalDto rentalDto = (RentalDto) sakilaDto;
            rentalDtos.add(rentalDto);
        }
        return rentalDtos;
    }
}
