package oose.dea;

import oose.dea.oose.dea.dto.APKDTO;
import oose.dea.oose.dea.dto.JediDTO;
import oose.dea.oose.dea.dto.ShipDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("starwars")
public class StarWars {

    @GET
    @Path("hi")
    public String helloWorld(){
        return "May the force be with you, Luke!";
    }

    @GET
    @Path("jedi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJedi(@PathParam("id") int id){
        if (id != 41){
            // help de jedi bestaat niet! wat doen we nu?
            return Response.status(404).entity("niet gevonden").build();
        }
        JediDTO jediDTO = new JediDTO();
        jediDTO.name = "Thijmen";
        jediDTO.customerId = id;

        return Response.status(200).entity(jediDTO).build();

    }

    @POST
    @Path("apk")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAPKForShip(ShipDTO shipDTO) {
        APKDTO apkdto = new APKDTO();
        apkdto.isValid = false;
        apkdto.comments = "This ship has not been approved.";

        if(shipDTO.name.equals("goodShip")) {
            apkdto.isValid = true;
            apkdto.comments = "This ship has been approved.";
        }

        return Response.status(200).entity(apkdto).build();
    }

}
