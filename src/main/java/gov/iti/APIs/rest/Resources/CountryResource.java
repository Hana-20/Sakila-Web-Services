package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.rest.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CountryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("CountryResource")
public class CountryResource {
    private CrudServices<CountryDto> crudService = new CrudServices<>(CountryDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllCountries() {
        List<CountryDto> countryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            CountryDto countryDto = (CountryDto) sakilaDto;
            countryDtos.add(countryDto);
        }

        GenericEntity entity = new GenericEntity<List<CountryDto>>(countryDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCountryById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        CountryDto countryDto = (CountryDto) crudService.getdtoById(id);
        if (countryDto== null)
        throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        return Response.ok().entity(countryDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCountryById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCountry(CountryDto countryDto) {
        crudService.add(countryDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCountry(@PathParam("id") int id, CountryDto countryDto) {
        crudService.update(countryDto);
        return Response.ok().build();
    }
}
