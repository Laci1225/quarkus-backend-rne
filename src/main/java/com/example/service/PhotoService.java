package com.example.service;

import com.example.mapper.PhotoMapper;
import com.example.model.PhotoCreateDto;
import com.example.repository.PhotoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PhotoService {
    @Inject
    PhotoMapper photoMapper;
    @Inject
    PhotoRepository photoRepository;
    public void savePhoto(PhotoCreateDto photoCreateDto) {
        photoRepository.persist(photoMapper.fromCreateDtoToPhoto(photoCreateDto));
    }
}
