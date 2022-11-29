package fr.cs.giteapirest;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Equipement;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/equipements")
public class EquipementResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        ArrayList<Equipement> equipements = DaoFactory.getEquipementDAO().getAll();
        return Response.ok(equipements).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id){
        Equipement equipement = DaoFactory.getEquipementDAO().getByID(id);
        return Response.ok(equipement).build();
    }
}