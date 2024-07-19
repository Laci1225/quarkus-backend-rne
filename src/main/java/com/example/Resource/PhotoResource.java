package com.example.Resource;

import com.example.model.PhotoCreateDto;
import com.example.model.User;
import com.example.service.PhotoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;


@Path("/photos")
public class PhotoResource {

    @Inject
    PhotoService photoService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Transactional
    public void savePhoto(@MultipartForm PhotoCreateDto photoCreateDto) {
        photoService.savePhoto(photoCreateDto);
    }
}
