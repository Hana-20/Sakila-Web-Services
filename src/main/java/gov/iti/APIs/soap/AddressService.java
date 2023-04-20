package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.models.dtos.AddressDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class AddressService {
    
    private CrudServices<AddressDto> addressService;
    
    public AddressService() {
        addressService = new CrudServices<>(AddressDto.class);
    }
    
    public AddressDto getAddressById(Integer id) {
        return (AddressDto)addressService.getdtoById(id);
    }
    
    public void deleteAddress(Integer id) {
        addressService.delete(id);
    }
    
    public void updateAddress(AddressDto addressDto) {
        addressService.update(addressDto);
    }
    
    public void addAddress(AddressDto addressDto) {
        addressService.add(addressDto);
    }
    
    public List<AddressDto> findAllAddresses() {
        List<AddressDto> addressDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : addressService.findAll()) {
            AddressDto addressDto = (AddressDto) sakilaDto;
            addressDtos.add(addressDto);
        }
        return addressDtos;
    }
}
