package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public Response saveUser(User user) {
        userRepository.persist(user);
        return Response.created(null).build();
    }


}

