package fr.cs.giteapirest;


import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Region;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/regions")
public class RegonResorce {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
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
