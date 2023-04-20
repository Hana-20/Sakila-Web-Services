package gov.iti.APIs.rest.Resources;


import gov.iti.models.dtos.CategoryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("CategoryResource")
public class CategoryResource {
    private CrudServices<CategoryDto> crudService = new CrudServices<>(CategoryDto.class);
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllCategory() {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
           CategoryDto categoryDto = (CategoryDto) sakilaDto;
           categoryDtos.add(categoryDto);
        }

        GenericEntity entity = new GenericEntity<List<CategoryDto>>(categoryDtos) {
        };
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getCategoryById(@PathParam("id") int id, @Context UriInfo uriInfo) {
       CategoryDto categoryDto = (CategoryDto) crudService.getdtoById(id);
        //CategoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        return Response.ok().entity(categoryDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategoryById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategory(CategoryDto categoryDto) {
       crudService.add(categoryDto);
        return Response.ok().build();
        // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCategory(@PathParam("id") int id,CategoryDto categoryDto) {
        crudService.update(categoryDto);
        return Response.ok().build();

    }
}
