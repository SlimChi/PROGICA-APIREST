package fr.cs.giteapirest.endpoint;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Equipement;
import fr.cs.giteapirest.metier.Gite;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Tag(name = "Equipements")
@Path("/equipements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipementResource {

    @GET
    @Operation(summary = "liste des equipements")
    public Response getAll(){

        ArrayList<Equipement> equipements = DaoFactory.getEquipementDAO().getAll();
        return Response.ok(equipements).build();
    }
    @GET
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id){
        Equipement equipement = DaoFactory.getEquipementDAO().getByID(id);
        return Response.ok(equipement).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, Equipement equipement){
        if(equipement == null || id == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(id != equipement.getId()){
            return Response.status(Response.Status.CONFLICT).entity(equipement).build();
        }
        if(DaoFactory.getEquipementDAO().update(equipement))
            return Response.ok(equipement).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    public Response insert(Equipement equipement){
        if(equipement == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(DaoFactory.getEquipementDAO().insert(equipement))
            return Response.ok(equipement).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id){
        Equipement equipement = new Equipement();
        equipement.setId(id);

        if(DaoFactory.getEquipementDAO().delete(equipement))
            return Response.ok(equipement).build();

        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
