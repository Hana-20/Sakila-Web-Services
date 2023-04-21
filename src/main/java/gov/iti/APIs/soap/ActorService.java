package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.ActorDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class ActorService {

    private CrudServices<ActorDto> actorService;

    
    public ActorService() {
        actorService = new CrudServices<>(ActorDto.class);
    }


    public ActorDto getActorById(Integer id) {
        ActorDto actor=(ActorDto)actorService.getdtoById(id);
        if(actor == null)
        throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        return actor;
    }

    public void deleteActor(Integer id) {
        actorService.delete(id);
    }

    public void updateActor(ActorDto actorDto) {
        actorService.update(actorDto);
    }

    public void addActor(ActorDto actorDto) {
        actorService.add(actorDto);
    }

    public List<ActorDto> findAllActors() {
        List<ActorDto> actorDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : actorService.findAll()) {
            ActorDto actorDto = (ActorDto) sakilaDto;
            actorDtos.add(actorDto);
        }
        return actorDtos;
    }
}

