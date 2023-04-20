package gov.iti.APIs.rest.Resources;

import gov.iti.models.dtos.AddressDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("AddressResource")
public class AddressResource {
    private CrudServices<AddressDto> crudService = new CrudServices<>(AddressDto.class);
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllAddresses() {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<AddressDto> addressDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
           AddressDto addressDto = (AddressDto) sakilaDto;
           addressDtos.add(addressDto);
        }

        GenericEntity entity = new GenericEntity<List<AddressDto>>(addressDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAddressById(@PathParam("id") int id, @Context UriInfo uriInfo) {
       AddressDto addressDto = (AddressDto) crudService.getdtoById(id);
        //AddressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        return Response.ok().entity(addressDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAddressById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAddress(AddressDto addressDto) {
       crudService.add(addressDto);
        return Response.ok().build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAddress(@PathParam("id") int id,AddressDto addressDto) {
        crudService.update(addressDto,id);
        return Response.ok().build();

    }
}
