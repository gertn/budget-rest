package be.budget.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/notes")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class NotesHandler {

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public NotesList list() {
        return new NotesList("Hello World, I still need some work to be useful!!");
    }

}
