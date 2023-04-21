package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CustomerDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class CustomerService {
    
    private CrudServices<CustomerDto> customerService;
    
    public CustomerService() {
        customerService = new CrudServices<>(CustomerDto.class);
    }
    
    public CustomerDto getCustomerById(Integer id) {
        CustomerDto customerDto = (CustomerDto) customerService.getdtoById(id);
        if ( customerDto== null)
        throw new ResourceNotFoundException("Customer with ID:" + id + " Not Found");
        return  customerDto;
    }
    
    public void deleteCustomer(Integer id) {
        customerService.delete(id);
    }
    
    public void updateCustomer(CustomerDto customerDto) {
        customerService.update(customerDto);
    }
    
    public void addCustomer(CustomerDto customerDto) {
        customerService.add(customerDto);
    }
    
    public List<CustomerDto> findAllCustomers() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : customerService.findAll()) {
            CustomerDto customerDto = (CustomerDto) sakilaDto;
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }
}
