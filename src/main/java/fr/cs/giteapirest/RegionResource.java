package fr.cs.giteapirest;


import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Region;
import fr.cs.giteapirest.metier.TypeEquipement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Tag(name = "Regions")
@Path("/Regions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegionResource {
    @GET
    @Operation(summary = "Liste des regions")

    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        Region region = new Region();
        ArrayList<Region> regions = DaoFactory.getRegionDAO().getAll();
        return Response.ok(regions).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id){
       Region region = DaoFactory.getRegionDAO().getByID(id);
        return Response.ok(region).build();
    }
}
