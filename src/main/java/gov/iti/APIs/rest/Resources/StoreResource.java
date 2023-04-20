package gov.iti.APIs.rest.Resources;

import gov.iti.models.dtos.SakilaDtos;
import gov.iti.models.dtos.StoreDto;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path(value = "StoreResource")
public class StoreResource {
    private CrudServices<StoreDto> crudService = new CrudServices<>(StoreDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllStores() {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<StoreDto> storeDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            StoreDto storeDto = (StoreDto) sakilaDto;
            storeDtos.add(storeDto);
        }

        GenericEntity entity = new GenericEntity<List<StoreDto>>(storeDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getStoreById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        StoreDto storeDto = (StoreDto) crudService.getdtoById(id);
        storeDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        return Response.ok().entity(storeDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteStoreById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStore(StoreDto storeDto) {
       crudService.add(storeDto);
        return Response.ok().build();
        // return Response.ok("").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateStore(@PathParam("id") int id, StoreDto storeDto) {
        crudService.update(storeDto);
        return Response.ok().build();

    }
}
