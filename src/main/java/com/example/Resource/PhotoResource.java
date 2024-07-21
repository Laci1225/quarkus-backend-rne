package com.example.Resource;

import com.example.model.Photo;
import com.example.model.PhotoCreateDto;
import com.example.model.User;
import com.example.service.PhotoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/photos")
public class PhotoResource {

    @Inject
    PhotoService photoService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Transactional
    public void savePhoto(PhotoCreateDto photoCreateDto) {
        photoService.savePhoto(photoCreateDto);
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Photo getPhoto(@PathParam("id") Long id) {
        return photoService.getPhoto(id);
    }
}
