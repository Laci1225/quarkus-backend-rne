package com.example.service;

import com.example.mapper.PhotoMapper;
import com.example.model.CapturedPhotos;
import com.example.model.PhotoData;
import com.example.repository.CapturedRepository;
import com.example.repository.PhotoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PhotoService {
    @Inject
    PhotoMapper photoMapper;
    @Inject
    PhotoRepository photoRepository;

    @Inject
    CapturedRepository capturedRepository;

    public void savePhoto(CapturedPhotos capturedPhotos) {
        photoRepository.persist(photoMapper.fromCreateDtoToPhoto(capturedPhotos.getFront()));
        photoRepository.persist(photoMapper.fromCreateDtoToPhoto(capturedPhotos.getBack()));

    }
    public PhotoData getPhoto(Long id) {
        return photoRepository.findById(id);
    }
    public PhotoData getMyTodayPhoto(Long id) {
        var todayDate = java.time.LocalDate.now();
        return photoRepository.find("id = ?1 and date = ?2", id, todayDate).firstResult();
    }
}
