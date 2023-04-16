package gov.iti;

import java.time.Instant;

import gov.iti.models.dtos.ActorDto;
import gov.iti.models.dtos.AddressDto;
import gov.iti.models.dtos.FilmTextDto;
import gov.iti.models.entities.Actor;
import gov.iti.services.CrudServices;

public class Main {
    public  static void main(String ... args){

        // CrudServices<AddressDto> crudServices=new CrudServices<>(AddressDto.class);
        // CrudServices<ActorDto> crudService=new CrudServices<>(ActorDto.class);
        // crudService.delete(0);
        // // System.out.println(crudServices.getdtoById(1));
        // ActorDto actorDto=new ActorDto();
        // actorDto.setFirstName("hana");
        // actorDto.setId(201);
        // actorDto.setLastName("alaa");
        // actorDto.setLastUpdate(Instant.now());
        // crudService.add(actorDto);
        // System.out.println(crudService.getdtoById(201));

        CrudServices<FilmTextDto> crudService=new CrudServices<>(FilmTextDto.class);
        crudService.findAll().forEach(e->System.out.println(e.toString()));
       
        
        // System.out.println(Actor.class.getName().split("\\.")[4]);
    }
}
