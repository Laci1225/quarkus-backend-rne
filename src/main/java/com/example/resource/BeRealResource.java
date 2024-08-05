package com.example.resource;


import com.example.model.BeReal;
import com.example.service.BeRealService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/bereals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BeRealResource {

    @Inject
    BeRealService berealService;

    @POST
    public void createBeReal(BeReal bereal) {
        berealService.saveBeReal(bereal);
    }

    @GET
    @Path("/user/{userId}")
    public List<BeReal> getUserBeReals(@PathParam("userId") Long userId) {
        return berealService.getUserBeReals(userId);
    }

    @GET
    @Path("/friends/{userId}")
    public List<BeReal> getFriendsBeReals(@PathParam("userId") Long userId) {
        return berealService.getFriendsBeReals(userId);
    }
}

