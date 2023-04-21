package gov.iti.APIs.rest.Resources;

import jakarta.ws.rs.Path;
import gov.iti.APIs.rest.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.dtos.StaffDto;
import gov.iti.services.CrudServices;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("StaffResource")
public class StaffResource {
    private CrudServices<StaffDto> crudService = new CrudServices<>(StaffDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllStaff() {
        List<StaffDto> staffDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            StaffDto staffDto = (StaffDto) sakilaDto;
            staffDtos.add(staffDto);
        }

        GenericEntity entity = new GenericEntity<List<StaffDto>>(staffDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStaffById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        StaffDto staffDto = (StaffDto) crudService.getdtoById(id);
        if (staffDto== null)
        throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        return Response.ok().entity(staffDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteStaffById(@PathParam("id") int id) {
       
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStaff(StaffDto staffDto) {
        crudService.add(staffDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateStaff(@PathParam("id") int id, StaffDto staffDto) {
        crudService.update(staffDto);
        return Response.ok().build();
    }
}
