package fr.cs.giteapirest;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Gite;
import fr.cs.giteapirest.service.GiteSearch;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/gites")
public class GiteResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        GiteSearch giteSearch = new GiteSearch();
        ArrayList<Gite> gites = DaoFactory.getGiteDAO().getLike(giteSearch);
        return Response.ok(gites).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id){
        Gite gite = DaoFactory.getGiteDAO().getByID(id);
        return Response.ok(gite).build();
    }

}
