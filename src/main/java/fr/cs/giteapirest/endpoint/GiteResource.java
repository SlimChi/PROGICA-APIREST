package fr.cs.giteapirest.endpoint;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Gite;
import fr.cs.giteapirest.service.GiteSearch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Tag(name = "Gites")
@Path("/gites")
public class GiteResource {
    @GET
    @Operation(summary = "liste des gites")
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

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Gite gite){
        if(gite == null || id == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(id != gite.getId()){
            return Response.status(Response.Status.CONFLICT).entity(gite).build();
        }
        if(DaoFactory.getGiteDAO().update(gite))
            return Response.ok(gite).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(@PathParam("id") Integer id, Gite gite){
        if(gite == null || id == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if(id != gite.getId()){
            return Response.status(Response.Status.CONFLICT).entity(gite).build();
        }
        if(DaoFactory.getGiteDAO().insert(gite))
            return Response.ok(gite).build();
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
        if(DaoFactory.getGiteDAO().delete(new Gite())){
            return Response.status(204).build();
        }
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
