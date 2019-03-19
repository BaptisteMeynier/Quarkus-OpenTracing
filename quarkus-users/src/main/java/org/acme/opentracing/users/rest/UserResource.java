package org.acme.opentracing.users.rest;


import org.acme.opentracing.users.model.User;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Path("/user")
public class UserResource {

    private static Set<User> usersSet = new HashSet<>(10);
    static {
        usersSet.add(new User("Antoine",new String[]{"PTF004","PTF005","PTF009"}));
        usersSet.add(new User("Bernard",new String[]{"PTF000","PTF006"}));
        usersSet.add(new User("Achref",new String[]{"PTF001","PTF002"}));
        usersSet.add(new User("Baptiste",new String[]{"PTF007"}));
        usersSet.add(new User("John",new String[]{"PTF003","PTF008"}));
    }

    @GET
    @Path("{ptfCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getManager(@PathParam("ptfCode") @NotEmpty String ptfCode) {

        User manager = usersSet.stream()
                .filter(user ->
                        Arrays.stream(user.getManagedPtf())
                                .anyMatch(ptf -> ptf.equalsIgnoreCase(ptfCode)))
                .findFirst()
                .orElse(new User("NOBODY"));

        return manager;
    }

}