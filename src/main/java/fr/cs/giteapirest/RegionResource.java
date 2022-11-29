package fr.cs.giteapirest;


import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Region;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/Regions")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "regions")
public class RegionResource {
    @GET
    @Operation(summary = "liste des regions")

    public Response getAll() {
        ArrayList<Region> regions = DaoFactory.getRegionDAO().getAll();
        return Response.ok(regions).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id) {
        Region region = DaoFactory.getRegionDAO().getByID(id);
        return Response.ok(region).build();
    }
}
