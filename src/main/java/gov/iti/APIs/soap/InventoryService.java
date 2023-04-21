package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.bytebuddy.asm.Advice.Return;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.InventoryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class InventoryService {
    
    private CrudServices<InventoryDto> inventoryService;
    
    public InventoryService() {
        inventoryService = new CrudServices<>(InventoryDto.class);
    }
    
    public InventoryDto getInventoryById(Integer id) {
        InventoryDto inventoryDto = (InventoryDto) inventoryService.getdtoById(id);
        if (inventoryDto== null)
        throw new ResourceNotFoundException("Inventory with ID:" + id + " Not Found");
        return inventoryDto;
    }
    
    public void deleteInventory(Integer id) {
        inventoryService.delete(id);
    }
    
    public void updateInventory(InventoryDto inventoryDto) {
        inventoryService.update(inventoryDto);
    }
    
    public void addInventory(InventoryDto inventoryDto) {
        inventoryService.add(inventoryDto);
    }
    
    public List<InventoryDto> findAllInventories() {
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : inventoryService.findAll()) {
            InventoryDto inventoryDto = (InventoryDto) sakilaDto;
            inventoryDtos.add(inventoryDto);
        }
        return inventoryDtos;
    }
}
