package gov.iti.APIs.rest.Resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;

import gov.iti.models.dtos.ActorDto;
import gov.iti.models.dtos.FilmTextDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.dtos.StoreDto;
import gov.iti.services.CrudServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("ActorResource")
public class ActorResource {
    private CrudServices<ActorDto> crudService = new CrudServices<>(ActorDto.class);
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllStores() {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<ActorDto> actorDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            ActorDto actorDto = (ActorDto) sakilaDto;
            actorDtos.add(actorDto);
        }

        GenericEntity entity = new GenericEntity<List<ActorDto>>(actorDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getActorById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        ActorDto actorDto = (ActorDto) crudService.getdtoById(id);
        // actorDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        return Response.ok().entity(actorDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteActorById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addActor(ActorDto actorDto) {
       crudService.add(actorDto);
        return Response.ok().build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateActor(@PathParam("id") int id, ActorDto actorDto) {
        crudService.update(actorDto);
        return Response.ok().build();

    }
}
