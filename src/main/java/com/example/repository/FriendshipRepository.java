package com.example.repository;

import com.example.model.Friendship;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FriendshipRepository implements PanacheRepository<Friendship> {
}
