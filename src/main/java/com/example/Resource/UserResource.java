package com.example.Resource;

import com.example.model.User;
import com.example.service.UserService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User userDto) {
        userService.createUser(userDto.getUsername(), userDto.getEmail());
        return userDto;
    }
}