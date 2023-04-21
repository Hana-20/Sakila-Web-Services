package gov.iti.APIs.rest.Resources;


import gov.iti.APIs.rest.Exception.ResourceNotFoundException;
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
    public Response getAllCategory(@Context UriInfo uriInfo) {

        // crudService.findAll().forEach(e->System.out.println(e.toString()));
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
           CategoryDto categoryDto = (CategoryDto) sakilaDto;
           categoryDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
           categoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Delete-category").build());
           categoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Update-category").build());
           categoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Get-category-By-Id").build());
           categoryDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("add-category").build());
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
       if (categoryDto== null)
       throw new ResourceNotFoundException("Category with ID:" + id + " Not Found");
        //CategoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        categoryDto.getLinks().add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        categoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Delete-category").build());
        categoryDto.getLinks().add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Update-category").build());
        categoryDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("all-categorys").build());
        categoryDto.getLinks().add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("add-category").build());
        return Response.ok().entity(categoryDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategoryById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        crudService.delete(id);
        List <Link>categoryLinks=new ArrayList<>();
        categoryLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Update-category").build());
        categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("Get-category-By-Id").build());
        categoryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("add-category").build());
        categoryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("all-categorys").build());

        GenericEntity entity = new GenericEntity<List<Link>>(categoryLinks) {};

        return Response.ok().entity(entity).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategory(CategoryDto categoryDto, @Context UriInfo uriInfo) {
       crudService.add(categoryDto);
       List <Link>categoryLinks=new ArrayList<>();
       categoryLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
       categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Delete-category").build());
       categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Update-category").build());
       categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(String.valueOf(categoryDto.getId()))).rel("Get-category-By-Id").build());
       categoryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("all-categorys").build());
       GenericEntity entity = new GenericEntity<List<Link>>(categoryLinks) {};

       return Response.ok().entity(entity).build();
       // return Response.ok("").build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateCategory(@PathParam("id") int id,CategoryDto categoryDto,@Context UriInfo uriInfo) {
        crudService.update(categoryDto);
        List <Link>categoryLinks=new ArrayList<>();
        categoryLinks.add( Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build());
        categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("delete-category").build());
        categoryLinks.add(Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder().path(""+id+"")).rel("get-category-by-id").build());
        categoryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("add-category").build());
        categoryLinks.add(Link.fromUri(uriInfo.getBaseUriBuilder().path(CategoryResource.class).build()).rel("all-categorys").build());

        GenericEntity entity = new GenericEntity<List<Link>>(categoryLinks) {};
        return Response.ok().entity(entity).build();


    }
}
