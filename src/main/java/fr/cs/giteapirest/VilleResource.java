package fr.cs.giteapirest;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Ville;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Tag(name = "Villes")

@Path("/villes")
public class VilleResource {

    @GET
    @Operation(summary = "liste des villes")

    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        ArrayList<Ville> villes = DaoFactory.getVilleDAO().getAll();
        return Response.ok(villes).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id){
        Ville ville = DaoFactory.getVilleDAO().getByID(id);
        return Response.ok(ville).build();
    }

}
