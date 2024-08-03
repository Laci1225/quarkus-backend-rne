package com.example.mapper;

import com.example.model.PhotoData;
import com.example.model.PhotoCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PhotoMapper {

    PhotoData fromCreateDtoToPhoto(PhotoCreateDto photoCreateDto);
    PhotoCreateDto fromPhotoToCreateDto(PhotoData photoData);
}
