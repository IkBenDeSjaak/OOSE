package oose.dea.resources;

import oose.dea.services.ItemService;
import oose.dea.services.dto.ItemDTO;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Singleton
@Path("/items")
public class ItemResource {

    private ItemService itemService;

    public ItemResource() {
        this.itemService = new ItemService();
    }

    //3
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getItems() {
        return "bread, butter";
    }

    //4
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJsonItems() {
//        return "[\"bread\", \"butter\"]";
//    }

    //6
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ItemDTO> getJsonItems() {
//        return itemService.getAll();
//    }

    //7
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonItems() {
        return Response.status(200).entity(itemService.getAll()).build();
    }

    //8
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("id") int id) {
        return Response.status(200).entity(itemService.getItem(id)).build();
    }

    //9
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(ItemDTO item) {
        itemService.addItem(item);
        return Response.status(201).build();
    }

    //11
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") int id) {
        itemService.deleteItem(id);
        return Response.status(200).build();
    }

}
