package gov.iti.APIs.rest.Resources;

import gov.iti.models.dtos.InventoryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("InventoryResource")
public class InventoryResource {
    private CrudServices<InventoryDto> crudService = new CrudServices<>(InventoryDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllInventories() {
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            InventoryDto inventoryDto = (InventoryDto) sakilaDto;
            inventoryDtos.add(inventoryDto);
        }

        GenericEntity entity = new GenericEntity<List<InventoryDto>>(inventoryDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getInventoryById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        InventoryDto inventoryDto = (InventoryDto) crudService.getdtoById(id);
        return Response.ok().entity(inventoryDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteInventoryById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addInventory(InventoryDto inventoryDto) {
        crudService.add(inventoryDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateInventory(@PathParam("id") int id, InventoryDto inventoryDto) {
        crudService.update(inventoryDto);
        return Response.ok().build();
    }
}
