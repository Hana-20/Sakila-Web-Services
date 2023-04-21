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
    public Response getAllCountries(@Context UriInfo uriInfo) {
        List<CountryDto> countryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            CountryDto countryDto = (CountryDto) sakilaDto;
            countryDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
            countryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Delete-Country").build());
            countryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Update-Country").build());
            countryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Get-Country-By-Id").build());
            countryDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("add-Country").build());
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
        throw new ResourceNotFoundException("Country with ID:" + id + " Not Found");
        countryDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        countryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Delete-Country").build());
        countryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Update-Country").build());
        countryDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("all-Countrys").build());
        countryDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("add-Country").build());
        return Response.ok().entity(countryDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCountryById(@PathParam("id") int id,@Context UriInfo uriInfo) {
        crudService.delete(id);
        List <Link>countryLinks=new ArrayList<>();
        countryLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Update-Country").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Get-Country-By-Id").build());
        countryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("add-Country").build());
        countryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("all-Countrys").build());

        GenericEntity entity = new GenericEntity<List<Link>>(countryLinks) {};
        return Response.ok().entity(entity).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCountry(CountryDto countryDto,@Context UriInfo uriInfo) {
        crudService.add(countryDto);
        List <Link>countryLinks=new ArrayList<>();
        countryLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Delete-Country").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Update-Country").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(countryDto.getId()))).rel("Get-Country-By-Id").build());
        countryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("all-Countrys").build());
        GenericEntity entity = new GenericEntity<List<Link>>(countryLinks) {};
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCountry(@PathParam("id") int id, CountryDto countryDto,@Context UriInfo uriInfo) {
        crudService.update(countryDto);
        List <Link>countryLinks=new ArrayList<>();
        countryLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("delete-Country").build());
        countryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("get-Country-by-id").build());
        countryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("add-Country").build());
        countryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CountryResource.class).build()).rel("all-Countrys").build());

        GenericEntity entity = new GenericEntity<List<Link>>(countryLinks) {};
        return Response.ok().entity(entity).build();
}
}