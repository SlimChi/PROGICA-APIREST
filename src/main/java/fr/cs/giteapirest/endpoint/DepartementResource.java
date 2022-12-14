package fr.cs.giteapirest.endpoint;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
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
@Tag(name = "Departements")
@Path("/departements")
public class DepartementResource {
    @GET
    @Operation(summary = "liste des departements")

    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        ArrayList<Departement> departements = DaoFactory.getDepartementDAO().getAll();
        return Response.ok(departements).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id){
        Departement departement = DaoFactory.getDepartementDAO().getByID(id);
        return Response.ok(departement).build();
    }

}
