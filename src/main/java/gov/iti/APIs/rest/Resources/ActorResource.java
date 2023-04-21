package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.ActorDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("ActorResource")
public class ActorResource {
    private CrudServices<ActorDto> crudService = new CrudServices<>(ActorDto.class);
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllActores(@Context UriInfo uriInfo){

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<ActorDto> actorDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            ActorDto actorDto = (ActorDto) sakilaDto;
            actorDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
            actorDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Delete-Actor").build());
            actorDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Update-Actor").build());
            actorDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Get-Actor-By-Id").build());
            actorDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("add-actor").build());
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
        if (actorDto== null)
        throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        actorDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        actorDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Delete-Actor").build());
        actorDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Update-Actor").build());
        actorDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("all-actors").build());
        actorDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("add-actor").build());

        return Response.ok().entity(actorDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteActorById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        crudService.delete(id);
        List <Link>actorLinks=new ArrayList<>();
        actorLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Update-Actor").build());
        actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Get-Actor-By-Id").build());
        actorLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("add-actor").build());
        actorLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("all-actors").build());

        GenericEntity entity = new GenericEntity<List<Link>>(actorLinks) {};

        return Response.ok().entity(entity).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addActor(ActorDto actorDto, @Context UriInfo uriInfo) {
       crudService.add(actorDto);
       List <Link>actorLinks=new ArrayList<>();
       actorLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
       actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Delete-Actor").build());
       actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Update-Actor").build());
       actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(actorDto.getId()))).rel("Get-Actor-By-Id").build());
       actorLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("all-actors").build());

       GenericEntity entity = new GenericEntity<List<Link>>(actorLinks) {};
        return Response.ok().entity(entity).build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateActor(@PathParam("id") int id, ActorDto actorDto, @Context UriInfo uriInfo) {
        actorDto.setId(id);
        crudService.update(actorDto);
        List <Link>actorLinks=new ArrayList<>();
        actorLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("delete-Actor").build());
        actorLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("get-actor-by-id").build());
        actorLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("add-actor").build());
        actorLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(ActorResource.class).build()).rel("all-actors").build());

        GenericEntity entity = new GenericEntity<List<Link>>(actorLinks) {};
        return Response.ok().entity(entity).build();

    }
}
