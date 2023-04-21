package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.LanguageDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("LanguageResource")
public class LanguageResource {
    private CrudServices<LanguageDto> crudService = new CrudServices<>(LanguageDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllLanguages() {
        List<LanguageDto> languageDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            LanguageDto languageDto = (LanguageDto) sakilaDto;
            languageDtos.add(languageDto);
        }

        GenericEntity entity = new GenericEntity<List<LanguageDto>>(languageDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getLanguageById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        LanguageDto languageDto = (LanguageDto) crudService.getdtoById(id);
        if (languageDto== null)
        throw new ResourceNotFoundException("Language with ID:" + id + " Not Found");
        return Response.ok().entity(languageDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteLanguageById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLanguage(LanguageDto languageDto) {
        crudService.add(languageDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateLanguage(@PathParam("id") int id, LanguageDto languageDto) {
        crudService.update(languageDto);
        return Response.ok().build();
    }
}
