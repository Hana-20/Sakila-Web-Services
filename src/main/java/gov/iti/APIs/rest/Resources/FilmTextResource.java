package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.FilmTextDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("FilmTextResource")
public class FilmTextResource {
    private CrudServices<FilmTextDto> crudService = new CrudServices<>(FilmTextDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllFilmTexts() {
        List<FilmTextDto> filmTextDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            FilmTextDto filmTextDto = (FilmTextDto) sakilaDto;
            filmTextDtos.add(filmTextDto);
        }

        GenericEntity entity = new GenericEntity<List<FilmTextDto>>(filmTextDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getFilmTextById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        FilmTextDto filmTextDto = (FilmTextDto) crudService.getdtoById(id);
        if (filmTextDto== null)
        throw new ResourceNotFoundException("FilmText with ID:" + id + " Not Found");
        return Response.ok().entity(filmTextDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteFilmTextById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilmText(FilmTextDto filmTextDto) {
        crudService.add(filmTextDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateFilmText(@PathParam("id") int id, FilmTextDto filmTextDto) {
        crudService.update(filmTextDto);
        return Response.ok().build();
    }
}
