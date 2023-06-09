package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.dtos.StoreDto;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class StoreService {

    private CrudServices<StoreDto> storeService;

    public StoreService() {
        storeService = new CrudServices<>(StoreDto.class);
    }

    public StoreDto getStoreById(Integer id) {
        StoreDto storeDto = (StoreDto) storeService.getdtoById(id);
        if (storeDto == null)
        throw new ResourceNotFoundException("Store with ID:" + id + " Not Found");
        return storeDto;
    }

    public void deleteStore(Integer id) {
        storeService.delete(id);
    }

    public void updateStore(StoreDto storeDto) {
        storeService.update(storeDto);
    }

    public void addStore(StoreDto storeDto) {
        storeService.add(storeDto);
    }

    public List<StoreDto> findAllStores() {
        List<StoreDto> storeDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : storeService.findAll()) {
            StoreDto storeDto = (StoreDto) sakilaDto;
            storeDtos.add(storeDto);
        }
        return storeDtos;
    }
}
