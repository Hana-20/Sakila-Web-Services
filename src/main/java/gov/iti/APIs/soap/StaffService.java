package gov.iti.APIs.soap;


import java.util.ArrayList;
import java.util.List;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.dtos.StaffDto;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class StaffService {
    
    private CrudServices<StaffDto> staffService;
    
    public StaffService() {
        staffService = new CrudServices<>(StaffDto.class);
    }
    
    public StaffDto getStaffById(Integer id) {
        return (StaffDto) staffService.getdtoById(id);
    }
    
    public void deleteStaff(Integer id) {
        staffService.delete(id);
    }
    
    public void updateStaff(StaffDto staffDto) {
        staffService.update(staffDto);
    }
    
    public void addStaff(StaffDto staffDto) {
        staffService.add(staffDto);
    }
    
    public List<StaffDto> findAllStaff() {
        List<StaffDto> staffDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : staffService.findAll()) {
            StaffDto staffDto = (StaffDto) sakilaDto;
            staffDtos.add(staffDto);
        }
        return staffDtos;
    }
}
