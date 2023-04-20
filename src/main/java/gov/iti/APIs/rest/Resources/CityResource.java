package gov.iti.APIs.rest.Resources;

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
    public Response getAllCities() {
        List<CityDto> cityDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            CityDto cityDto = (CityDto) sakilaDto;
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
        return Response.ok().entity(cityDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCityById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCity(CityDto cityDto) {
        crudService.add(cityDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCity(@PathParam("id") int id, CityDto cityDto) {
        crudService.update(cityDto);
        return Response.ok().build();
    }
}
