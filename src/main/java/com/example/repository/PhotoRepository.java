package com.example.repository;

import com.example.model.Photo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PhotoRepository implements PanacheRepository<Photo> {
}
