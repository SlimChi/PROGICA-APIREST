package fr.cs.giteapirest;

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
public class EquipementResource {

    @GET
    @Operation(summary = "liste des equipements")
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

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
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
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(@PathParam("id") Integer id, Equipement equipement){
        if(equipement == null || id == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(id != equipement.getId()){
            return Response.status(Response.Status.CONFLICT).entity(equipement).build();
        }
        if(DaoFactory.getEquipementDAO().insert(equipement))
            return Response.ok(equipement).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @ApiResponse(responseCode = "204", description = "supprimé!!")
    @ApiResponse(responseCode = "400", description = "!non supprimé!!")

    public Response delete(@PathParam("id") Integer id){
        if(id == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(DaoFactory.getEquipementDAO().delete(new Equipement())){
            return Response.status(204).build();
        }
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
