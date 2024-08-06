package com.example.resource;


import com.example.model.BeReal;
import com.example.model.BeRealCreateDto;
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
    @Path("/upload")
    public void createBeReal(BeRealCreateDto beRealCreateDto) {
        berealService.saveBeReal(beRealCreateDto);
    }

    /*@GET
    @Path("/user/{userId}")
    public List<BeReal> getUserBeReals(@PathParam("userId") Long userId) {
        return berealService.getUserBeReals(userId);
    }

    @GET
    @Path("/friends/{userId}")
    public List<BeReal> getFriendsBeReals(@PathParam("userId") Long userId) {
        return berealService.getFriendsBeReals(userId);
    }*/

    @GET
    @Path("/feed")
    public List<BeReal> getUserFeed(@QueryParam("userId") Long userId) {
        //List<BeReal> userBeReals = berealService.getUserBeReals(userId);
        List<BeReal> friendsBeReals = berealService.getFriendsBeReals(userId);
        //userBeReals.addAll(friendsBeReals);
        //return userBeReals;
        return friendsBeReals;
    }

    @GET
    @Path("/today")
    public List<BeReal> getTodayBeReals(@QueryParam("userId") Long userId) {
        return berealService.getTodayBeReals(userId);
    }
}

