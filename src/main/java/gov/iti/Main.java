package gov.iti;

import gov.iti.models.dtos.AddressDto;
import gov.iti.services.rest.CrudServices;

public class Main {
    public  static void main(String ... args){

        CrudServices<AddressDto> crudServices=new CrudServices<>(AddressDto.class);

        System.out.println(crudServices.getdtoById(1));
    }
}
