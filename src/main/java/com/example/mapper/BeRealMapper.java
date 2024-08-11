package com.example.mapper;

import com.example.model.BeReal;
import com.example.model.BeRealCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface BeRealMapper {

    BeReal fromBeRealCreateDtoToBeReal(BeRealCreateDto beRealCreateDto);
    BeRealCreateDto fromBeRealToCreateDto(BeReal beReal);
}
