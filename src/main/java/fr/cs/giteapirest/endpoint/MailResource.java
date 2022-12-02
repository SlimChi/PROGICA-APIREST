package fr.cs.giteapirest.endpoint;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Mail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Tag(name = "Mails")
@Path("/mails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MailResource {
    @GET
    @Operation(summary = "Liste des mails")
    public Response getAll(){
        ArrayList<Mail> mails = DaoFactory.getMailDAO().getAll();
        return Response.ok(mails).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Récupère le mail")
    public Response getbyId(@PathParam("id") String id){
        Mail mail = DaoFactory.getMailDAO().getbyMail(id);
        return Response.ok(mail).build();
    }
}
