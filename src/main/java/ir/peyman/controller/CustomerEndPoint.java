package ir.peyman.controller;

import ir.peyman.entity.CustomerEntity;
import ir.peyman.service.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value = "customer")
public class CustomerEndPoint{

    private  CustomerService customerService;

    public CustomerEndPoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    @Path(value = "retrieve/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerEntity getCustomer(@PathParam("id") Long id) {
        return customerService.retrieve(id);
    }

    @POST
    @Path(value = "delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(Long id) {
        customerService.delete(id);

        return Response.status(Response.Status.OK).entity("customer has been successfully deleted").type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path(value = "save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCustomer(CustomerEntity customer) {
        customerService.save(customer);

        return Response.status(Response.Status.OK).entity("customer has been successfully saved").type(MediaType.APPLICATION_JSON).build();
    }
}
