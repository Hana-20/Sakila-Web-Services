package gov.iti.models.mappers;

import gov.iti.models.dtos.InventoryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.entities.Inventory;
import gov.iti.models.entities.SakilaEntities;
import org.modelmapper.ModelMapper;

public class InventoryMapper implements SakilaMapper{
    private final ModelMapper modelMapper;

    public  InventoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public SakilaDtos toDto(SakilaEntities entity) {
        return modelMapper.map(entity, InventoryDto.class);
    }

    @Override
    public SakilaEntities toEntity(SakilaDtos dto) {
        return modelMapper.map(dto, Inventory.class);
    }
}
