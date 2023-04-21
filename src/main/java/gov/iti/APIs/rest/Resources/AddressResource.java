package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.rest.Exception.ResourceNotFoundException;
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
    public Response getAllAddresses(@Context UriInfo uriInfo) {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<AddressDto> addressDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
           AddressDto addressDto = (AddressDto) sakilaDto;
           addressDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
           addressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Delete-address").build());
           addressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Update-address").build());
           addressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Get-address-By-Id").build());
           addressDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("add-address").build());
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
       if (addressDto== null)
       throw new ResourceNotFoundException("Address with ID:" + id + " Not Found");
        //AddressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        addressDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        addressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Delete-address").build());
        addressDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Update-address").build());
        addressDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("all-addresss").build());
        addressDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("add-address").build());
        return Response.ok().entity(addressDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAddressById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        crudService.delete(id);
        List <Link>addressLinks=new ArrayList<>();
        addressLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Update-address").build());
        addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Get-address-By-Id").build());
        addressLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("add-address").build());
        addressLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("all-addresss").build());

        GenericEntity entity = new GenericEntity<List<Link>>(addressLinks) {};

        return Response.ok().entity(entity).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAddress(AddressDto addressDto, @Context UriInfo uriInfo) {
       crudService.add(addressDto);
       List <Link>addressLinks=new ArrayList<>();
       addressLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
       addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Delete-address").build());
       addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Update-address").build());
       addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(addressDto.getAddressId()))).rel("Get-address-By-Id").build());
       addressLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("all-addresss").build());
       GenericEntity entity = new GenericEntity<List<Link>>(addressLinks) {};

       return Response.ok().entity(entity).build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAddress(@PathParam("id") int id,AddressDto addressDto, @Context UriInfo uriInfo) {
        crudService.update(addressDto);
        List <Link>addressLinks=new ArrayList<>();
        addressLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("delete-address").build());
        addressLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("get-address-by-id").build());
        addressLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("add-address").build());
        addressLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(AddressResource.class).build()).rel("all-addresss").build());

        GenericEntity entity = new GenericEntity<List<Link>>(addressLinks) {};
        return Response.ok().entity(entity).build();

    }
}
