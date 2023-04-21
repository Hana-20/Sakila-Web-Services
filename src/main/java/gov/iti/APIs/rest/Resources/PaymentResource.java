package gov.iti.APIs.rest.Resources;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.PaymentDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("PaymentResource")
public class PaymentResource {
    private CrudServices<PaymentDto> crudService = new CrudServices<>(PaymentDto.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllPayments() {
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : crudService.findAll()) {
            PaymentDto paymentDto = (PaymentDto) sakilaDto;
            paymentDtos.add(paymentDto);
        }

        GenericEntity entity = new GenericEntity<List<PaymentDto>>(paymentDtos) {};
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getPaymentById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        PaymentDto paymentDto = (PaymentDto) crudService.getdtoById(id);
        if (paymentDto== null)
        throw new ResourceNotFoundException("Payment with ID:" + id + " Not Found");
        return Response.ok().entity(paymentDto).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePaymentById(@PathParam("id") int id) {
        crudService.delete(id);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPayment(PaymentDto paymentDto) {
        crudService.add(paymentDto);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePayment(@PathParam("id") int id, PaymentDto paymentDto) {
        crudService.update(paymentDto);
        return Response.ok().build();
    }
}
