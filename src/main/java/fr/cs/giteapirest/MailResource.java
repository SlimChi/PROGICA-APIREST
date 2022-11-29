package fr.cs.giteapirest;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Mail;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
@Tag(name = "Mails")

@Path("/mails")
public class MailResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        ArrayList<Mail> mails = DaoFactory.getMailDAO().getAll();
        return Response.ok(mails).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyId(@PathParam("id") Integer id){
        Mail mail = DaoFactory.getMailDAO().getByID(id);
        return Response.ok(mail).build();
    }
}
