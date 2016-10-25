package resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import dao.UserDAO;
import model.Person;

@Path("user")
public class UserResource {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;
    
    @Inject
    private UserDAO userDAO;

    /**
     * Default constructor. 
     */
    public UserResource() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of UserResource
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
       
        @SuppressWarnings("unchecked")
		List<Person> persons = 
				userDAO.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Person person : persons){
        	sb.append("{name :");
        	sb.append(person.getName());
        	sb.append(" }");
        }
        sb.append("]");
        
        return sb.toString();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}