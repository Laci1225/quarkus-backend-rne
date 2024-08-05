package com.example.repository;

import com.example.model.BeReal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeRealRepository implements PanacheRepository<BeReal> {
}
