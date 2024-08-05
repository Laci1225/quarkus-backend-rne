package com.example.resource;

import com.example.model.CapturedPhotos;
import com.example.model.PhotoData;
import com.example.service.PhotoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/photos")
public class PhotoResource {

    @Inject
    PhotoService photoService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Transactional
    public Response savePhoto(CapturedPhotos capturedPhotos) {
        photoService.savePhoto(capturedPhotos);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public PhotoData getPhoto(@PathParam("id") Long id) {
        return photoService.getPhoto(id);
    }

    @GET
    @Path("/today/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public PhotoData getMyTodayPhoto(@PathParam("id") Long id) {
        return photoService.getMyTodayPhoto(id);
    }
}
