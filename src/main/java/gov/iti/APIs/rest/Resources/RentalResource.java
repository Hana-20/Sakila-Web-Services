package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.RentalDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("RentalResource")
public class RentalResource {
    private CrudServices<RentalDto> crudService = new CrudServices<>(RentalDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllRentals() {
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            RentalDto rentalDto = (RentalDto) sakilaDto;
            rentalDtos.add(rentalDto);
        }

        GenericEntity entity = new GenericEntity<List<RentalDto>>(rentalDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getRentalById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        RentalDto rentalDto = (RentalDto) crudService.getdtoById(id);
        if (rentalDto== null)
        throw new ResourceNotFoundException("Rental with ID:" + id + " Not Found");
        return Response.ok().entity(rentalDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteRentalById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRental(RentalDto rentalDto) {
        crudService.add(rentalDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateRental(@PathParam("id") int id, RentalDto rentalDto) {
        crudService.update(rentalDto);
        return Response.ok().build();
    }
}
