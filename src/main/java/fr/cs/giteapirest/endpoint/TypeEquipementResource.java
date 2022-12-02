package fr.cs.giteapirest.endpoint;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Gite;
import fr.cs.giteapirest.metier.TypeEquipement;
import fr.cs.giteapirest.service.GiteSearch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;




@Tag(name = "TypeEquipement")
@Path("/TypeEquipement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeEquipementResource {

    @GET
    @Operation(summary = "Liste des types equipements")
    public Response getAll(){
        TypeEquipement typeEquipement = new TypeEquipement();
        ArrayList<TypeEquipement> typeEquipements = DaoFactory.getTypeEquipementDAO().getAll();
        return Response.ok(typeEquipements).build();
    }
    @GET
    @Operation(summary = "Liste des couleurs par id")
    @Path("{id}")
    public Response getbyId(@PathParam("id") Integer id){
        TypeEquipement typeEquipement = DaoFactory.getTypeEquipementDAO().getByID(id);
        return Response.ok(typeEquipement).build();
    }

    @PUT
    @Operation(summary = "Update")
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, TypeEquipement typeEquipement){
        if(typeEquipement == null || id == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(id != typeEquipement.getId()){
            return Response.status(Response.Status.CONFLICT).entity(typeEquipement).build();
        }
        if(DaoFactory.getTypeEquipementDAO().update(typeEquipement))
            return Response.ok(typeEquipement).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    @Operation(summary = "Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(TypeEquipement typeEquipement){
        if(typeEquipement == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(DaoFactory.getTypeEquipementDAO().insert(typeEquipement))
            return Response.ok(typeEquipement).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id){

      TypeEquipement typeEquipement = new TypeEquipement();
      typeEquipement.setId(id);

        if(DaoFactory.getTypeEquipementDAO().delete(typeEquipement))
            return Response.ok(typeEquipement).build();

        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
