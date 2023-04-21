package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CityDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("CityResource")
public class CityResource {
    private CrudServices<CityDto> crudService = new CrudServices<>(CityDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllCities(@Context UriInfo uriInfo) {
        List<CityDto> cityDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            CityDto cityDto = (CityDto) sakilaDto;
            cityDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
            cityDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Delete-city").build());
            cityDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Update-city").build());
            cityDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Get-city-By-Id").build());
            cityDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("add-city").build());
           
            cityDtos.add(cityDto);
        }

        GenericEntity entity = new GenericEntity<List<CityDto>>(cityDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCityById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        CityDto cityDto = (CityDto) crudService.getdtoById(id);
        if (cityDto== null)
        throw new ResourceNotFoundException("City with ID:" + id + " Not Found");
        cityDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        cityDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Delete-city").build());
        cityDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Update-city").build());
        cityDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("all-citys").build());
        cityDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("add-city").build());
        return Response.ok().entity(cityDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCityById(@PathParam("id") int id,@Context UriInfo uriInfo) {
        crudService.delete(id);
        List <Link>cityLinks=new ArrayList<>();
        cityLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Update-city").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Get-city-By-Id").build());
        cityLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("add-city").build());
        cityLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("all-citys").build());

        GenericEntity entity = new GenericEntity<List<Link>>(cityLinks) {};

        return Response.ok().entity(entity).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCity(CityDto cityDto,@Context UriInfo uriInfo) {
        crudService.add(cityDto);
        List <Link>cityLinks=new ArrayList<>();
        cityLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Delete-city").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Update-city").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(cityDto.getId()))).rel("Get-city-By-Id").build());
        cityLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("all-citys").build());
        GenericEntity entity = new GenericEntity<List<Link>>(cityLinks) {};
 
        return Response.ok().entity(entity).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCity(@PathParam("id") int id, CityDto cityDto,@Context UriInfo uriInfo) {
        crudService.update(cityDto);
        List <Link>cityLinks=new ArrayList<>();
        cityLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("delete-city").build());
        cityLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("get-city-by-id").build());
        cityLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("add-city").build());
        cityLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CityResource.class).build()).rel("all-citys").build());

        GenericEntity entity = new GenericEntity<List<Link>>(cityLinks) {};
        return Response.ok().entity(entity).build();
    }
}
