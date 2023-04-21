package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.rest.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CustomerDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("CustomerResource")
public class CustomerResource {
    private CrudServices<CustomerDto> crudService = new CrudServices<>(CustomerDto.class);
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllStores() {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
           CustomerDto customerDto = (CustomerDto) sakilaDto;
           customerDtos.add(customerDto);
        }

        GenericEntity entity = new GenericEntity<List<CustomerDto>>(customerDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCustomerById(@PathParam("id") int id, @Context UriInfo uriInfo) {
       CustomerDto customerDto = (CustomerDto) crudService.getdtoById(id);
       if ( customerDto== null)
       throw new ResourceNotFoundException("Actor with ID:" + id + " Not Found");
        //CustomerDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        return Response.ok().entity(customerDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomerById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDto customerDto) {
       crudService.add(customerDto);
        return Response.ok().build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCustomer(@PathParam("id") int id,CustomerDto customerDto) {
        crudService.update(customerDto);
        return Response.ok().build();

    }
}
