package com.example.repository;

import com.example.model.CapturedPhotos;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CapturedRepository implements PanacheRepository<CapturedPhotos> {
}
