package de.groeschn.javaee.rest;

import de.groeschn.javaee.dao.UserDao;
import de.groeschn.javaee.entity.User;
import de.groeschn.javaee.rest.authentication.interceptor.AuthorisedUser;
import de.groeschn.javaee.rest.authentication.producer.RequestUser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class DemoResource {

    @Inject
    UserDao userDao;
    @Inject
    @RequestUser
    User user;

    @GET
    @Path("users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GET
    @Path("user")
    public User getRequestUser() {
        return user;
    }

    /*
     * Method only available to authenticated users.
     */
    @GET
    @Path("authenticated")
    @AuthorisedUser
    public DemoResponse demoAuthenticatedUser() {
        return new DemoResponse("you are authenticated");
    }

    /*
     * Method only available to authenticated users in the DEMO_ROLE2 role.
     */
    @GET
    @Path("in-role")
    @AuthorisedUser("DEMO_ROLE2")
    public DemoResponse demoRole2() {
        return new DemoResponse("you are in role DEMO_ROLE2");
    }
}
