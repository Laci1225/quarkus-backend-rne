package com.example.mapper;

import com.example.model.Photo;
import com.example.model.PhotoCreateDto;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PhotoMapper {

    Photo fromCreateDtoToPhoto(PhotoCreateDto photoCreateDto);
    PhotoCreateDto fromPhotoToCreateDto(Photo photo);
}
