package gov.iti.APIs.rest.Resources;

import gov.iti.models.dtos.FilmDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("FilmResource")
public class FilmResource {
    private CrudServices<FilmDto> crudService = new CrudServices<>(FilmDto.class);
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllFilms() {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<FilmDto> filmDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
           FilmDto filmDto = (FilmDto) sakilaDto;
           filmDtos.add(filmDto);
        }

        GenericEntity entity = new GenericEntity<List<FilmDto>>(filmDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getFilmById(@PathParam("id") int id, @Context UriInfo uriInfo) {
       FilmDto filmDto = (FilmDto) crudService.getdtoById(id);
        //FilmDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        return Response.ok().entity(filmDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteFilmById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilm(FilmDto filmDto) {
       crudService.add(filmDto);
        return Response.ok().build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateFilm(@PathParam("id") int id,FilmDto filmDto) {
        crudService.update(filmDto,id);
        return Response.ok().build();

    }
}
